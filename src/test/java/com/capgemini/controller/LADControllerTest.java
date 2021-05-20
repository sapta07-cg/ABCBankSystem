package com.capgemini.controller;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.capgemini.entities.LoanStatus;
import com.capgemini.service.ICustomerLoanReport;
@WebMvcTest(LADController.class)
class LADControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ICustomerLoanReport icustomerloanreport;

	@Test
	/*void checkladtest() throws Exception{
    LoanStatus ls = new LoanStatus();
		
		// LEARNING 2
				// providding the implemenation of findById method.
				// mocking the findById method on MockObject employeeService
		
		Mockito.when(icustomerloanreport.hello(Mockito.anyInt())).thenReturn();
		

		mockMvc.perform(get("/api/lad/allrecords")).andExpect(MockMvcResultMatchers.status().isOk());
		
		
	}*/
	void deleteladtest() throws Exception{
		String URI = "/api/lad/3";
		LoanStatus ls = new LoanStatus();
		ls.setStatusid(3);
		ls.setCustomerloantype("home");
		new ArrayList<>();

		icustomerloanreport.deleteById(ls.getStatusid());
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(org.springframework.http.MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		mockHttpServletResponse.getContentAsString();
	}

}
