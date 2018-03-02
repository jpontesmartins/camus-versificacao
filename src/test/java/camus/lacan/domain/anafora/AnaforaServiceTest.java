package camus.lacan.domain.anafora;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import camus.lacan.domain.poema.Estrofe;

public class AnaforaServiceTest {

	private static final String ANAFORA = "anáfora";
	AnaforaService anaforaService;

	@Before
	public void setup() {
		anaforaService = new AnaforaService();
	}

	@Test
	public void deve_retornar_estrofe() {
		String versos = "e tudo acabou§e tudo fugiu§e tudo mofou§e agora josé?";
		Estrofe estrofe = new Estrofe(versos);

		Estrofe estrofeRetorno = anaforaService.analisarEstrofe(estrofe);

		Assert.assertEquals(ANAFORA, estrofeRetorno.getFiguras().get(0).getFigura().getDescricao());
		Assert.assertEquals("e tudo", ((Anafora) estrofeRetorno.getFiguras().get(0)).getExpressao());
		Assert.assertEquals(3, ((Anafora) estrofeRetorno.getFiguras().get(0)).getFrequecia().intValue());

	}

}
