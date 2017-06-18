package versificacao.figurasdelinguagem;

import org.junit.Assert;
import org.junit.Test;

public class AliteracaoTest {

	@Test
	public void fraseComRMaisFrequenteTest() {
		Aliteracao figuras = new Aliteracao();
		String frase = "o rato roeu a roupa do rei de roma";
		Assert.assertEquals(10, figuras.descobrirConsoantesMaisFrequentes(frase).get("r").intValue());

	}
	
	@Test
	public void fraseComVEZMaisFrequentesTest() {
		Aliteracao figuras = new Aliteracao();
		String frase = "vozes veladas, veludosas vozes";
		Assert.assertEquals(8, figuras.descobrirConsoantesMaisFrequentes(frase).get("v").intValue());
		Assert.assertEquals(5, figuras.descobrirConsoantesMaisFrequentes(frase).get("s").intValue());
		Assert.assertEquals(2, figuras.descobrirConsoantesMaisFrequentes(frase).get("z").intValue());

	}
	
	@Test
	public void fraseComVEDMaisFrequentesTest() {
		Aliteracao figuras = new Aliteracao();
		String frase = "quem me vê apanhando da vida duvida que eu vá revidar";
		Assert.assertEquals(8, figuras.descobrirConsoantesMaisFrequentes(frase).get("d").intValue());
		Assert.assertEquals(8, figuras.descobrirConsoantesMaisFrequentes(frase).get("v").intValue());
	}

}
