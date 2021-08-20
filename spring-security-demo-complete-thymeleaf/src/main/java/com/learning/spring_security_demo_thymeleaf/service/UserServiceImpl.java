package com.learning.spring_security_demo_thymeleaf.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.spring_security_demo_thymeleaf.dao.RoleDao;
import com.learning.spring_security_demo_thymeleaf.dao.UserDao;
import com.learning.spring_security_demo_thymeleaf.entity.Role;
import com.learning.spring_security_demo_thymeleaf.entity.User;
import com.learning.spring_security_demo_thymeleaf.user.CrmUser;

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
	public User findUserByName(String userName) {
		return userDao.getUserByName(userName);
	}
	
	@Override
	@Transactional
	public void saveUser(CrmUser crmUser) {
		User user = new User();
		
		user.setUserName(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
		user.setFirstName(crmUser.getFirstName());
		user.setLastName(crmUser.getLastName());
		user.setEmail(crmUser.getEmail());
		
		//Add Default Role of Employee:
		List<Role> roles = new ArrayList<>();
		
		roles.add(roleDao.getRoleByName("ROLE_EMPLOYEE"));
		
		if (!crmUser.getFormRole().equals("ROLE_EMPLOYEE"))
			roles.add(roleDao.getRoleByName(crmUser.getFormRole()));
		
		user.setRoles(roles);
		
		userDao.saveUser(user);
	}
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUserByName(username);
		
		if (user==null)
			throw new UsernameNotFoundException("No such User found");
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(),
				user.getPassword(), mapRolesToAuthotities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthotities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).
				collect(Collectors.toList());
	}
	
}