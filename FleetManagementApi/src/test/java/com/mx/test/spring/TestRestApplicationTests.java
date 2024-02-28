package com.mx.test.spring;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mx.test.spring.controller.Taxis;
import com.mx.test.spring.controller.TaxisController;
import com.mx.test.spring.controller.TaxisService;

@WebMvcTest(TaxisController.class)
@WithMockUser
class TestRestApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TaxisService taxisService;

	Taxis mockTaxis = new Taxis(6418, "DDNG-0487");
	
	
	@Test
	public void taxisService() throws Exception{
		
		List<Taxis> listTaxis = new ArrayList<>();
		listTaxis.add(mockTaxis);
				
		Mockito.when(taxisService.getAllTaxis()).thenReturn(listTaxis);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/taxis").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expected ="[{\"id\":6418,\"plate\":\"DDNG-0487\"}]";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
	}
	
	
	@Test
	public void taxisServiceById() throws Exception{
		Taxis idTaxi = new Taxis();
		idTaxi.setId(6418);
		idTaxi.setPlate("DDNG-0487");
		Mockito.when(taxisService.getTaxisById(Mockito.anyInt())).thenReturn(idTaxi);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/taxis/{id}", 1).accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expected ="{\"id\":6418,\"plate\":\"DDNG-0487\"}";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
 

}
