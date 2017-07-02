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
	public void ANNaoSendoDigrafo() {
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("an", "anos"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("an", "anel"));
	}

	@Test
	public void AMNaoSendoDigrafo() {
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("am", "amar"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("amigo", "amigo"));
	}

	@Test
	public void AMSendoDigrafo() {
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("am", "campo"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("am", "ambulância"));
	}

	@Test
	public void ANSendoDigrafo() {
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("an", "anta"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("an", "canto"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("an", "granja"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("an", "andar"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("an", "quanto"));
	}

	@Test
	public void temDigrafoRR() {
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
	public void SCSendoDigrafo() {
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("sc", "desci"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("sc", "descer"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("sc", "nascer"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("sc", "piscina"));
	}

	@Test
	public void SCNaoSendoDigrafo() {
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("sc", "pisca"));
	}

	@Test
	public void XCSendoDigrafo() {
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("xc", "exceção"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("xc", "excelente"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("xc", "excitação"));
	}

	@Test
	public void XCNaoSendoDigrafo() {
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("xc", "excarcerar"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("xc", "excomungar"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("xc", "excursão"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("xc", "exclamação"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("xc", "excremento"));
	}

	@Test
	public void XSSendoDigrafo() {
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("xs", "exsuar"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("xs", "exsicação"));
	}

	@Test
	public void XSNaoSendoDigrafo() {
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("xc", "exclamação"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("xc", "excremento"));
	}

	@Test
	public void QUSendoDigrafo() {
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("qu", "queda"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("qu", "quinta"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("qu", "quero"));
	}

	@Test
	public void QUNaoSendoDigrafo() {
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("qu", "quadro"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("qu", "quanto"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("qu", "qual"));
	}

	@Test
	public void GUSendoDigrafo() {
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("gu", "guerra"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("gu", "guilhotina"));
		Assert.assertTrue(digrafo.contemDigrafoEspecifico("gu", "gueto"));
	}

	@Test
	public void GUNaoSendoDigrafo() {
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("gu", "guarda-roupa"));
		Assert.assertFalse(digrafo.contemDigrafoEspecifico("gu", "guri"));
	}

}
