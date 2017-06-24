package versificacao.separacao_silabica;

import org.junit.Assert;
import org.junit.Test;

public class DigrafoTest {

	@Test
	public void SCSendoDigrafo() {
		Digrafo digrafo = new Digrafo();
		Assert.assertTrue(digrafo.contemDigrafo("sc", "desci"));
		Assert.assertTrue(digrafo.contemDigrafo("sc", "descer"));
		Assert.assertTrue(digrafo.contemDigrafo("sc", "nascer"));
		Assert.assertTrue(digrafo.contemDigrafo("sc", "piscina"));
	}

	@Test
	public void SCNaoSendoDigrafo() {
		Digrafo digrafo = new Digrafo();
		Assert.assertFalse(digrafo.contemDigrafo("sc", "pisca"));
	}

	@Test
	public void XCSendoDigrafo() {
		Digrafo digrafo = new Digrafo();
		Assert.assertTrue(digrafo.contemDigrafo("xc", "exceção"));
		Assert.assertTrue(digrafo.contemDigrafo("xc", "excelente"));
		Assert.assertTrue(digrafo.contemDigrafo("xc", "excitação"));
	}

	@Test
	public void XCNaoSendoDigrafo() {
		Digrafo digrafo = new Digrafo();
		Assert.assertFalse(digrafo.contemDigrafo("xc", "excarcerar"));
		Assert.assertFalse(digrafo.contemDigrafo("xc", "excomungar"));
		Assert.assertFalse(digrafo.contemDigrafo("xc", "excursão"));
		Assert.assertFalse(digrafo.contemDigrafo("xc", "exclamação"));
		Assert.assertFalse(digrafo.contemDigrafo("xc", "excremento"));
	}

	@Test
	public void XSSendoDigrafo() {
		Digrafo digrafo = new Digrafo();
		Assert.assertTrue(digrafo.contemDigrafo("xs", "exsuar"));
		Assert.assertTrue(digrafo.contemDigrafo("xs", "exsicação"));
	}

	@Test
	public void XSNaoSendoDigrafo() {
		Digrafo digrafo = new Digrafo();
		Assert.assertFalse(digrafo.contemDigrafo("xc", "exclamação"));
		Assert.assertFalse(digrafo.contemDigrafo("xc", "excremento"));
	}

	@Test
	public void QUSendoDigrafo() {
		Digrafo digrafo = new Digrafo();
		Assert.assertTrue(digrafo.contemDigrafo("qu", "queda"));
		Assert.assertTrue(digrafo.contemDigrafo("qu", "quinta"));
		Assert.assertTrue(digrafo.contemDigrafo("qu", "quero"));
	}

	@Test
	public void QUNaoSendoDigrafo() {
		Digrafo digrafo = new Digrafo();
		Assert.assertFalse(digrafo.contemDigrafo("qu", "quadro"));
		Assert.assertFalse(digrafo.contemDigrafo("qu", "quanto"));
		Assert.assertFalse(digrafo.contemDigrafo("qu", "qual"));
	}

	@Test
	public void GUSendoDigrafo() {
		Digrafo digrafo = new Digrafo();
		Assert.assertTrue(digrafo.contemDigrafo("gu", "guerra"));
		Assert.assertTrue(digrafo.contemDigrafo("gu", "guilhotina"));
		Assert.assertTrue(digrafo.contemDigrafo("gu", "gueto"));
	}

	@Test
	public void GUNaoSendoDigrafo() {
		Digrafo digrafo = new Digrafo();
		Assert.assertFalse(digrafo.contemDigrafo("gu", "guarda-roupa"));
	}

}
