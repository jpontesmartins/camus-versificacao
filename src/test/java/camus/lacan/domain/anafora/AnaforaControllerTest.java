package camus.lacan.domain.anafora;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class AnaforaControllerTest {

	@MockBean
	AnaforaController anaforaController;

	@Autowired
	private WebApplicationContext context;

	MockMvc mockMvc;

	@Test
	public void should_return_2xx() throws Exception {
		when(anaforaController.analisarEstrofe("")).thenReturn(null);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		mockMvc.perform(get("/anafora/estrofe/teste")).andExpect(status().isOk());

	}

}
