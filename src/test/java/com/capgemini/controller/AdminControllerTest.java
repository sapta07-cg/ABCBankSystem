package com.capgemini.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.capgemini.entities.LoanProgram;
import com.capgemini.service.ILoanService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AdminController.class)
class AdminControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ILoanService iloanservice;

	@Test
	void addloandetails() throws Exception {
		LoanProgram lp = new LoanProgram();
		lp.setLoanId(1);
		lp.setLoanType("car");

		Mockito.when(iloanservice.addLoanDetails(Mockito.any())).thenReturn("Added");

		mockMvc.perform(post("/api/admin/addloandetails").contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(lp)))
				.andExpect(MockMvcResultMatchers.status().isCreated());

	}
	
	@Test
	void DeleteEmployeeByIdTest() throws Exception{
		String URI = "/api/admin/2";
		LoanProgram lp = new LoanProgram();
		lp.setLoanId(2);
		lp.setLoanType("car");
		new ArrayList<>();

		iloanservice.deleteLoanDetails(lp.getLoanId());
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(org.springframework.http.MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		mockHttpServletResponse.getContentAsString();
	}

}
