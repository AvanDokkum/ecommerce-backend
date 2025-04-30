package com.webcanis.backend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EcommerceBackendApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@ParameterizedTest
	@ValueSource(strings = {"TestCategory"})
	public void testCreateCategoryShouldPass(String input) throws Exception {
		String jsonRequest = "{\"categoryName\" : \"" + input + "\"}";
		mockMvc.perform(
						post("/api/public/categories")
								.content(jsonRequest)
								.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful());
	}

}
