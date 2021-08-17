package com.learning.spring_security_demo_complete.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.spring_security_demo_complete.dao.RoleDao;
import com.learning.spring_security_demo_complete.dao.UserDao;
import com.learning.spring_security_demo_complete.entity.Role;
import com.learning.spring_security_demo_complete.entity.User;
import com.learning.spring_security_demo_complete.user.CrmUser;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public User findByUserName(String username) {
		//Check in DB if the User already exists:
		return userDao.findByUserName(username);
	}
	
	@Override
	@Transactional
	public void save(CrmUser crmUser) {
		User user = new User();
		
		//Assign User Details to the User object:
		user.setUserName(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
		user.setFirstName(crmUser.getFirstName());
		user.setLastName(crmUser.getLastName());
		user.setEmail(crmUser.getEmail());
		
		//Give User default role of "EMPLOYEE":
		List<Role> roleList = new ArrayList<>();
		roleList.add(roleDao.findRoleByName("ROLE_EMPLOYEE"));
		
		if (!crmUser.getFormRole().equals("ROLE_EMPLOYEE"))
			roleList.add(roleDao.findRoleByName(crmUser.getFormRole()));
		
		user.setRoles(roleList);
		
		//Save User in DB:
		userDao.saveUser(user);
	}
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUserName(username);
		
		if (user==null)
			throw new UsernameNotFoundException("Invalid User or Password.");
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(),
				user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
}