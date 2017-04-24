package versificacao.expressao_regular;

import org.junit.Assert;
import org.junit.Test;

// http://www.devmedia.com.br/conceitos-basicos-sobre-expressoes-regulares-em-java/27539

public class ExpressaoRegularTest {

	@Test
	public void palavraCom2DigitosTest() {
		boolean valor = "74".matches("\\d{2}");
		Assert.assertTrue(valor);
	}

	@Test
	public void palavraComMaisDe2DigitosTest() {
		boolean valor = "742".matches("\\d{2,}");
		Assert.assertTrue(valor);
	}

	@Test
	public void palavraComMaisDe2DigitosEMenosDe5Test() {
		String expressao = "\\d{2,5}";

		boolean valor = "74254".matches(expressao);
		Assert.assertTrue(valor);

		valor = "74254a".matches(expressao);
		Assert.assertFalse(valor);

		valor = "abdrg".matches(expressao);
		Assert.assertFalse(valor);

	}

}
