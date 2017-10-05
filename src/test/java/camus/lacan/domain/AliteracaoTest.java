package camus.lacan.domain;

import org.junit.Assert;
import org.junit.Test;

public class AliteracaoTest {
	
	

	@Test
	public void oPeitoDoPeDePedroEPretoTest() {
		Aliteracao figuras = new Aliteracao();
		String frase = "o peito do pé de Pedro é preto";
		Assert.assertEquals(8, figuras.descobrirFonemasMaisFrequentes(frase).get("/p/").intValue());
	}

	
	@Test
	public void quemComFerroFereComFerroSeraFeridoTest() {
		Aliteracao figuras = new Aliteracao();
		String frase = "quem com ferro fere, com ferro será ferido";
		Assert.assertEquals(8, figuras.descobrirFonemasMaisFrequentes(frase).get("/f/").intValue());
	}
	
	
	@Test
	public void quemJaViuUmDoceTaoDoceComoODoceDeBatataDoceTest() {
		Aliteracao figuras = new Aliteracao();
		String frase = "quem já viu um doce tão doce, como o doce de batata doce";
		Assert.assertEquals(10, figuras.descobrirFonemasMaisFrequentes(frase).get("/d/").intValue());
	}
	
	@Test
	public void oPatoPatetaPintouOCanecoTest() {
		Aliteracao figuras = new Aliteracao();
		String frase = "O pato pateta pintou o caneco";
		Assert.assertEquals(6, figuras.descobrirFonemasMaisFrequentes(frase).get("/p/").intValue());
	}
	@Test
	public void chegamosDeUmaTerraFeiaFriaFetidaFutilTest() {
		Aliteracao figuras = new Aliteracao();
		String frase = "Chegamos de uma terra feia, fria, fétida, fútil";
		Assert.assertEquals(8, figuras.descobrirFonemasMaisFrequentes(frase).get("/f/").intValue());
	}
	
	
	@Test
	public void todaGenteHomenageiaJanuariaDaJanelaTest() {
		Aliteracao figuras = new Aliteracao();
		String frase = "Toda gente homenageia Januária na janela";
		Assert.assertEquals(7, figuras.descobrirFonemasMaisFrequentes(frase).get("/j/").intValue());
	}
	
	@Test
	public void esperandoParadaPregadaNaPedraDoPortoTest() {
		Aliteracao figuras = new Aliteracao();
		String frase = "Esperando, parada, pregada na pedra do porto";
		Assert.assertEquals(9, figuras.descobrirFonemasMaisFrequentes(frase).get("/p/").intValue());
	}
	
	
	@Test
	public void fraseComRMaisFrequenteTest() {
		Aliteracao figuras = new Aliteracao();
		String frase = "o rato roeu a roupa do rei de roma";
		Assert.assertEquals(10, figuras.descobrirFonemasMaisFrequentes(frase).get("/R/").intValue());

	}
	
	@Test
	public void fraseComVEZMaisFrequentesTest() {
		Aliteracao figuras = new Aliteracao();
		String frase = "vozes veladas, veludosas vozes";
		Assert.assertEquals(8, figuras.descobrirFonemasMaisFrequentes(frase).get("/v/").intValue());
		Assert.assertEquals(4, figuras.descobrirFonemasMaisFrequentes(frase).get("/s/").intValue());
		Assert.assertEquals(3, figuras.descobrirFonemasMaisFrequentes(frase).get("/z/").intValue());

	}
	
	@Test
	public void fraseComVEDMaisFrequentesTest() {
		Aliteracao figuras = new Aliteracao();
		String frase = "quem me vê apanhando da vida duvida que eu vá revidar";
		Assert.assertEquals(8, figuras.descobrirFonemasMaisFrequentes(frase).get("/d/").intValue());
		Assert.assertEquals(8, figuras.descobrirFonemasMaisFrequentes(frase).get("/v/").intValue());
	}

}
