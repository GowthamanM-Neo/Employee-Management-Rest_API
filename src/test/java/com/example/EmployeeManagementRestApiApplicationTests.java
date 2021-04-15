package com.example;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class EmployeeManagementRestApiApplicationTests {

	@Autowired
    private MockMvc mockMvc;	

	//Add A New Employee
	@Test
    public void TestCase1() throws Exception {
		
		String dataOne = "{\"employeeId\":\"12881\",\"employeeName\":\"Joey Tribianni\",\"employeeEmail\":\"joeyfriends@gmail.com\",\"dept\":\"Actor\"}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/addEmployee")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(dataOne)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andReturn();
	 	
    }
	
	//Get All Employees
	@Test
    public void TestCase2() throws Exception {
		
	 	mockMvc.perform(MockMvcRequestBuilders.get("/getAllEmployee")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$[*].employeeName").exists())
		        .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
	        	.andReturn();
	 	
    }
	
	//Get An Employee By ID
	@Test
	public void TestCase3() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/getEmployee")
				.param("id","12881")
				.contentType(MediaType.APPLICATION_JSON)
		 		.accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.employeeName").value("Joey Tribianni"))
		        .andExpect(jsonPath("$.employeeEmail").value("joeyfriends@gmail.com"))
		        .andReturn();
			
	}
	
	//Delete An Employee
	@Test
	public void TestCase4() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/deleteEmployee")
				.param("id","12881")
				.contentType(MediaType.APPLICATION_JSON)
		 		.accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andReturn();
			
	}

}
