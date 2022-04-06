package com.learning.spring_boot_demo.crud.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.learning.spring_boot_demo.crud.dao.EmployeeRepository;
import com.learning.spring_boot_demo.crud.entity.Employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@SpringBootTest
@TestPropertySource(
		locations = "classpath:application-it.properties"
)
@AutoConfigureMockMvc
class EmployeeRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private EmployeeRepository employeeRepository;

	private final Faker faker = new Faker();

	
	@Test
	void canAddNewEmployee() throws JsonProcessingException, Exception {
		// given:
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = String.format("%s@gmail.com",
				StringUtils.trimAllWhitespace(firstName.trim().toLowerCase()));
		
		Employee newEmp = new Employee(0, firstName, lastName, email);
		
		// when:
		ResultActions resultActions = mockMvc.
				perform(post("/api/v1/employees").
						contentType(MediaType.APPLICATION_JSON).
						content(objectMapper.writeValueAsString(newEmp)));
		
		// then:
		resultActions.andExpect(status().isCreated());
		List<Employee> employees = employeeRepository.findAll();
		assertThat(employees).
				usingRecursiveFieldByFieldElementComparatorIgnoringFields("id").
				contains(newEmp);
		
	}

	@Test
	void cannotAddEmployeeWithDuplicateEmailId() throws Exception {
		// given:
		//First get an existing Email Id from the DB:
		MvcResult employeeListResult = mockMvc.
				perform(get("/api/v1/employees").
						accept(MediaType.APPLICATION_JSON)).
				andExpect(status().isOk()).
				andReturn();
		
		String contentAsString = employeeListResult.
				getResponse().
				getContentAsString();
		
		List<Employee> employees = objectMapper.
				readValue(contentAsString, new TypeReference<>() {});
		
		String email = employees.stream().map(emp -> emp.getEmail()).findFirst().orElse("");
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		
		Employee newEmp = new Employee(0, firstName, lastName, email);
		
		// when:
		ResultActions resultAction = mockMvc.
				perform(post("/api/v1/employees").
						contentType(MediaType.APPLICATION_JSON).
						content(objectMapper.writeValueAsString(newEmp)));
		
		//then:
		MvcResult errorMsg = resultAction.andExpect(status().isConflict()).andReturn();
		
		String errorMsgAsString = errorMsg.
				getResponse().
				getContentAsString();
		
		assertThat(errorMsgAsString).isEqualTo("Employee with Email: "+newEmp.getEmail()+" already exists!");
	}
	
	@Test
	void canDeleteEmployee() throws JsonProcessingException, Exception {
		// given:
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = String.format("%s@gmail.com",
				StringUtils.trimAllWhitespace(firstName.trim().toLowerCase()));
		
		Employee emp = new Employee(0, firstName, lastName, email);
		
		MvcResult postResult = mockMvc.
				perform(post("/api/v1/employees").
						contentType(MediaType.APPLICATION_JSON).
						content(objectMapper.writeValueAsString(emp))).
				andExpect(status().isCreated()).andReturn();
		
		String postResultAsString = postResult.
				getResponse().
				getContentAsString();
		
		Employee savedEmp = objectMapper.
				readValue(postResultAsString, new TypeReference<>() {});
		
		int id = savedEmp.getId();
		
//		MvcResult getEmployeesResult = mockMvc.
//				perform(get("/api/v1/employees").
//						contentType(MediaType.APPLICATION_JSON)).
//				andExpect(status().isOk()).
//				andReturn();
//		
//		String contentAsString = getEmployeesResult.
//				getResponse().
//				getContentAsString();
//		
//		List<Employee> employees = objectMapper.
//				readValue(contentAsString, new TypeReference<>() {});
//		
//		int id = employees.stream().
//				filter(employee -> employee.getEmail().equals(email)).
//				map(Employee::getId).
//				findFirst().
//				orElseThrow(() -> new IllegalStateException("Employee with Email: "+email+" not found"));
		
		// when:
		ResultActions resultAction = mockMvc.perform(delete("/api/v1/employees/" + id));
		
		// then:
		resultAction.andExpect(status().isOk());
		boolean exists = employeeRepository.existsById(id);
		assertThat(exists).isFalse();
	}

	@Test
	void cannotDeleteNonExistingEmployee() throws Exception {
		// given:
		int id = 0;
		
		// when:
		ResultActions resultAction = mockMvc.perform(delete("/api/v1/employees/" + id));
		
		//then:
		MvcResult responseMvcResult = resultAction.andExpect(status().isNotFound()).andReturn();
		
		String stringResponse = responseMvcResult.getResponse().getContentAsString();
		
		assertThat(stringResponse).isEqualTo("Employee with Id: "+id+" not found!");
		boolean exists = employeeRepository.existsById(id);
		assertThat(exists).isFalse();
	}
	
	@Test
	void canFindEmployee() throws JsonProcessingException, Exception {
		// given:
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = String.format("%s@gmail.com",
				StringUtils.trimAllWhitespace(firstName.trim().toLowerCase()));
		
		Employee newEmp = new Employee(0, firstName, lastName, email);
		
		MvcResult savedEmployeeResult = mockMvc.
			perform(post("/api/v1/employees").
				contentType(MediaType.APPLICATION_JSON).
				content(objectMapper.writeValueAsString(newEmp))).
			andExpect(status().isCreated()).
			andReturn();
		
		String contentAsString = savedEmployeeResult.
				getResponse().
				getContentAsString();
		
		Employee savedEmp = objectMapper.
				readValue(contentAsString, new TypeReference<>() {});
		
		int id = savedEmp.getId();
		
		// when:
		// then:
		MvcResult foundEmployeeResult = mockMvc.
				perform(get("/api/v1/employees/" + id).
						accept(MediaType.APPLICATION_JSON)).
				andExpect(status().isFound()).
				andReturn();
		
		String foundContentAsString = foundEmployeeResult.
				getResponse().
				getContentAsString();
		
		Employee foundEmp = objectMapper.
				readValue(foundContentAsString, new TypeReference<>() {});
		
		assertThat(foundEmp).usingRecursiveComparison().isEqualTo(savedEmp);
		Employee internalEmp = employeeRepository.findById(id).
				orElseThrow(() -> new IllegalStateException("Employee with Id: "+id+" not found!"));
		assertThat(foundEmp).usingRecursiveComparison().isEqualTo(internalEmp);
	}

	@Test
	void cannotFindEmployee() throws Exception {
		// given:
		int id = 0;
		
		// when:
		// then:
		MvcResult foundEmployeeResult = mockMvc.
				perform(get("/api/v1/employees/" + id).
						accept(MediaType.APPLICATION_JSON)).
				andExpect(status().isNotFound()).
				andReturn();
		
		String errorMsgAsString = foundEmployeeResult.
				getResponse().
				getContentAsString();
		
		assertThat(errorMsgAsString).isEqualTo("Employee with Id: "+id+" not found!");
	}
	
	@Test
	void canUpdateEmployee() throws JsonProcessingException, Exception {
		// given:
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = String.format("%s@gmail.com",
				StringUtils.trimAllWhitespace(firstName.trim().toLowerCase()));
		
		Employee emp = new Employee(0, firstName, lastName, email);
		
		MvcResult savedEmployeeResult = mockMvc.
				perform(post("/api/v1/employees").
					contentType(MediaType.APPLICATION_JSON).
					content(objectMapper.writeValueAsString(emp))).
				andExpect(status().isCreated()).
				andReturn();
		
		String contentAsString = savedEmployeeResult.
				getResponse().
				getContentAsString();
		
		Employee savedEmp = objectMapper.
				readValue(contentAsString, new TypeReference<>() {});
		
		int id = savedEmp.getId();
		
		// when:
		String updatedFirstName = faker.name().firstName();
		String updatedLastName = faker.name().lastName();
		String updatedEmail = String.format("%s@gmail.com",
				StringUtils.trimAllWhitespace(updatedFirstName.trim().toLowerCase()));
		
		Employee updateEmp = new Employee(id, updatedFirstName, updatedLastName, updatedEmail);
		
		// then:
		MvcResult updatedEmployeeResult = mockMvc.
				perform(put("/api/v1/employees/"+id).
						contentType(MediaType.APPLICATION_JSON).
						content(objectMapper.writeValueAsString(updateEmp)).
						accept(MediaType.APPLICATION_JSON)).
				andExpect(status().isOk()).
				andReturn();
		
		String foundContentAsString = updatedEmployeeResult.
				getResponse().
				getContentAsString();
		
		Employee updatedEmployee = objectMapper.
				readValue(foundContentAsString, new TypeReference<>() {});
		
		assertThat(updatedEmployee).usingRecursiveComparison().isEqualTo(updateEmp);
		Employee internalEmp = employeeRepository.findById(id).
				orElseThrow(() -> new IllegalArgumentException("Employee with Id: " + id + " not found!"));
		assertThat(updatedEmployee).usingRecursiveComparison().isEqualTo(internalEmp);
	}
	
	@Test
	void cannotUpdateEmployeeIfIdDoesnotExist() throws JsonProcessingException, Exception {
		// given:
		int id = 0;
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = String.format("%s@gmail.com",
				StringUtils.trimAllWhitespace(firstName.trim().toLowerCase()));
		
		Employee emp = new Employee(id, firstName, lastName, email);
		
		// when:
		ResultActions updateResultAction = mockMvc.
				perform(put("/api/v1/employees/"+id).
						contentType(MediaType.APPLICATION_JSON).
						content(objectMapper.writeValueAsString(emp)).
						accept(MediaType.APPLICATION_JSON));
		
		// then:
		String responseString = updateResultAction.andExpect(status().isNotFound()).
				andReturn().
				getResponse().
				getContentAsString();
		
		assertThat(responseString).isEqualTo("Employee with Id: "+id+" not found!");
	}
	
	
}
