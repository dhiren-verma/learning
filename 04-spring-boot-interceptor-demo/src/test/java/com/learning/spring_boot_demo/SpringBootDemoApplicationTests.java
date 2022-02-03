package com.learning.spring_boot_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootDemoApplicationTests {

	@Test
	public void getResultShouldReturn_ok_200(@Autowired MockMvc mockMvc)
			throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/")).
				andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void postResultShouldReturn_notallowed_400(@Autowired MockMvc mockMvc)
			throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/")).
				andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
	}

	@Test
	public void putResultShouldReturn_notallowed_400(@Autowired MockMvc mockMvc)
			throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/")).
				andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
	}

	@Test
	public void deleteResultShouldReturn_notallowed_400(@Autowired MockMvc mockMvc)
			throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/")).
				andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
	}

	@Test
	public void patchResultShouldReturn_notallowed_400(@Autowired MockMvc mockMvc)
			throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.patch("/")).
				andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
	}

	@Test
	public void optionsResultShouldReturn_notallowed_400(@Autowired MockMvc mockMvc)
			throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.options("/")).
				andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
	}
	
}
