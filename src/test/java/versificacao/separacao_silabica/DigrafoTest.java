package versificacao.separacao_silabica;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DigrafoTest {

	Digrafo digrafo;

	@Before
	public void setup() {
		digrafo = new Digrafo();
	}

	@Test
	public void anNaoSendoDigrafo() {
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("an", "anos"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("an", "anel"));
	}

	@Test
	public void amNaoSendoDigrafo() {
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("am", "amar"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("amigo", "amigo"));
	}

	@Test
	public void amSendoDigrafo() {
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("am", "campo"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("am", "ambulância"));
	}

	@Test
	public void anSendoDigrafo() {
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("an", "anta"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("an", "canto"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("an", "granja"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("an", "andar"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("an", "quanto"));
	}

	@Test
	public void temDigrafoRr() {
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("rr", "guerra"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("gu", "guerra"));
	}

	@Test
	public void reconhecendoPossiveisDigrafos() {
		Assert.assertEquals("sc", digrafo.encontrarDigrafos("descida").get(0));
		Assert.assertEquals("xc", digrafo.encontrarDigrafos("exceção").get(0));
		Assert.assertEquals("rr", digrafo.encontrarDigrafos("guerra").get(0));
		Assert.assertTrue(digrafo.encontrarDigrafos("guerra").contains("gu"));
		Assert.assertTrue(digrafo.encontrarDigrafos("guerra").contains("rr"));
		Assert.assertTrue(digrafo.encontrarDigrafos("guilhotina").contains("gu"));
		Assert.assertTrue(digrafo.encontrarDigrafos("guilhotina").contains("lh"));

	}

	@Test
	public void scSendoDigrafo() {
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("sc", "desci"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("sc", "descer"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("sc", "nascer"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("sc", "piscina"));
	}

	@Test
	public void scNaoSendoDigrafo() {
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("sc", "pisca"));
	}

	@Test
	public void xcSendoDigrafo() {
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("xc", "exceção"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("xc", "excelente"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("xc", "excitação"));
	}

	@Test
	public void xcNaoSendoDigrafo() {
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("xc", "excarcerar"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("xc", "excomungar"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("xc", "excursão"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("xc", "exclamação"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("xc", "excremento"));
	}

	@Test
	public void xsSendoDigrafo() {
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("xs", "exsuar"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("xs", "exsicação"));
	}

	@Test
	public void quSendoDigrafo() {
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("qu", "queda"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("qu", "quinta"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("qu", "quero"));
	}

	@Test
	public void quNaoSendoDigrafo() {
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("qu", "quadro"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("qu", "quanto"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("qu", "qual"));
	}

	@Test
	public void guSendoDigrafo() {
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("gu", "guerra"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("gu", "guilhotina"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("gu", "gueto"));
	}

	@Test
	public void guNaoSendoDigrafo() {
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("gu", "guarda-roupa"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("gu", "guri"));
	}

}
