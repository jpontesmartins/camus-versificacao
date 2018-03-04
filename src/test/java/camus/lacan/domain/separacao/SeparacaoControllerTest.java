package camus.lacan.domain.separacao;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ContextConfiguration
@WebMvcTest(controllers = SeparacaoController.class)
public class SeparacaoControllerTest {

	@Autowired
	private WebApplicationContext context;

	MockMvc mockMvc;

	@Test
	public void should_return_2xx() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		mockMvc.perform(get("/separacao/poetica/umverso")).andExpect(status().isOk());
	}

}
