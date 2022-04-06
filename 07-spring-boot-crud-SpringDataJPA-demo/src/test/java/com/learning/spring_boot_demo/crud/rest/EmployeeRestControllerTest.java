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
import com.learning.spring_boot_demo.crud.dto.EmployeeDTO;
import com.learning.spring_boot_demo.crud.entity.Employee;
import com.learning.spring_boot_demo.crud.utility.Translator;

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
		
		EmployeeDTO newEmpDto = new EmployeeDTO(0, firstName, lastName, email);
		Employee newEmp = Translator.translateDTOToEntity(newEmpDto);
		
		// when:
		ResultActions resultActions = mockMvc.
				perform(post("/api/v1/employees").
						contentType(MediaType.APPLICATION_JSON).
						content(objectMapper.writeValueAsString(newEmpDto)));
		
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
		
		List<EmployeeDTO> employees = objectMapper.
				readValue(contentAsString, new TypeReference<>() {});
		
		String email = employees.stream().map(emp -> emp.getEmail()).findFirst().orElse("");
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		
		EmployeeDTO newEmpDto = new EmployeeDTO(0, firstName, lastName, email);
		
		// when:
		ResultActions resultAction = mockMvc.
				perform(post("/api/v1/employees").
						contentType(MediaType.APPLICATION_JSON).
						content(objectMapper.writeValueAsString(newEmpDto)));
		
		//then:
		MvcResult errorMsg = resultAction.andExpect(status().isConflict()).andReturn();
		
		String errorMsgAsString = errorMsg.
				getResponse().
				getContentAsString();
		
		assertThat(errorMsgAsString).isEqualTo("Employee with Email: "+newEmpDto.getEmail()+" already exists!");
	}
	
	@Test
	void canDeleteEmployee() throws JsonProcessingException, Exception {
		// given:
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = String.format("%s@gmail.com",
				StringUtils.trimAllWhitespace(firstName.trim().toLowerCase()));
		
		EmployeeDTO empDto = new EmployeeDTO(0, firstName, lastName, email);
		
		MvcResult postResult = mockMvc.
				perform(post("/api/v1/employees").
						contentType(MediaType.APPLICATION_JSON).
						content(objectMapper.writeValueAsString(empDto))).
				andExpect(status().isCreated()).andReturn();
		
		String postResultAsString = postResult.
				getResponse().
				getContentAsString();
		
		EmployeeDTO savedEmpDto = objectMapper.
				readValue(postResultAsString, new TypeReference<>() {});
		
		int id = savedEmpDto.getId();
		
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
		
		EmployeeDTO newEmpDto = new EmployeeDTO(0, firstName, lastName, email);
		
		MvcResult savedEmployeeResult = mockMvc.
			perform(post("/api/v1/employees").
				contentType(MediaType.APPLICATION_JSON).
				content(objectMapper.writeValueAsString(newEmpDto))).
			andExpect(status().isCreated()).
			andReturn();
		
		String contentAsString = savedEmployeeResult.
				getResponse().
				getContentAsString();
		
		EmployeeDTO savedEmpDto = objectMapper.
				readValue(contentAsString, new TypeReference<>() {});
		
		int id = savedEmpDto.getId();
		
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
		
		EmployeeDTO foundEmpDto = objectMapper.
				readValue(foundContentAsString, new TypeReference<>() {});
		
		assertThat(foundEmpDto).usingRecursiveComparison().isEqualTo(savedEmpDto);
		
		Employee internalEmp = employeeRepository.findById(id).
				orElseThrow(() -> new IllegalStateException("Employee with Id: "+id+" not found!"));
		EmployeeDTO internalEmpDto = Translator.translateEntityToDTO(internalEmp);
		
		assertThat(foundEmpDto).usingRecursiveComparison().isEqualTo(internalEmpDto);
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
		
		EmployeeDTO empDto = new EmployeeDTO(0, firstName, lastName, email);
		
		MvcResult savedEmployeeResult = mockMvc.
				perform(post("/api/v1/employees").
					contentType(MediaType.APPLICATION_JSON).
					content(objectMapper.writeValueAsString(empDto))).
				andExpect(status().isCreated()).
				andReturn();
		
		String contentAsString = savedEmployeeResult.
				getResponse().
				getContentAsString();
		
		EmployeeDTO savedEmpDto = objectMapper.
				readValue(contentAsString, new TypeReference<>() {});
		
		int id = savedEmpDto.getId();
		
		// when:
		String updatedFirstName = faker.name().firstName();
		String updatedLastName = faker.name().lastName();
		String updatedEmail = String.format("%s@gmail.com",
				StringUtils.trimAllWhitespace(updatedFirstName.trim().toLowerCase()));
		
		EmployeeDTO updateEmpDto = new EmployeeDTO(id, updatedFirstName, updatedLastName, updatedEmail);
		
		// then:
		MvcResult updatedEmployeeResult = mockMvc.
				perform(put("/api/v1/employees/"+id).
						contentType(MediaType.APPLICATION_JSON).
						content(objectMapper.writeValueAsString(updateEmpDto)).
						accept(MediaType.APPLICATION_JSON)).
				andExpect(status().isOk()).
				andReturn();
		
		String foundContentAsString = updatedEmployeeResult.
				getResponse().
				getContentAsString();
		
		EmployeeDTO updatedEmployeeDto = objectMapper.
				readValue(foundContentAsString, new TypeReference<>() {});
		
		assertThat(updatedEmployeeDto).usingRecursiveComparison().isEqualTo(updateEmpDto);
		
		Employee internalEmp = employeeRepository.findById(id).
				orElseThrow(() -> new IllegalArgumentException("Employee with Id: " + id + " not found!"));
		EmployeeDTO internalEmpDto = Translator.translateEntityToDTO(internalEmp);
		assertThat(updatedEmployeeDto).usingRecursiveComparison().isEqualTo(internalEmpDto);
	}
	
	@Test
	void cannotUpdateEmployeeIfIdDoesnotExist() throws JsonProcessingException, Exception {
		// given:
		int id = 0;
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = String.format("%s@gmail.com",
				StringUtils.trimAllWhitespace(firstName.trim().toLowerCase()));
		
		EmployeeDTO empDto = new EmployeeDTO(id, firstName, lastName, email);
		
		// when:
		ResultActions updateResultAction = mockMvc.
				perform(put("/api/v1/employees/"+id).
						contentType(MediaType.APPLICATION_JSON).
						content(objectMapper.writeValueAsString(empDto)).
						accept(MediaType.APPLICATION_JSON));
		
		// then:
		String responseString = updateResultAction.andExpect(status().isNotFound()).
				andReturn().
				getResponse().
				getContentAsString();
		
		assertThat(responseString).isEqualTo("Employee with Id: "+id+" not found!");
	}
	
	
}
