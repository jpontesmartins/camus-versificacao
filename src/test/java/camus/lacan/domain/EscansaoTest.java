package camus.lacan.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import camus.lacan.controllers.Escansao;

public class EscansaoTest {

	Escansao escansao;
	

	@Before
	public void setUp() {
		escansao = new Escansao();
	}

	@Test
	public void queMesmoEmFaceDMaiorEncanto() {
		String verso1 = "Que mesmo em face do maior encanto";
		Assert.assertEquals(10, escansao.contarSilabasPoeticas(verso1));
	}

	@Test
	public void antesEComTalZeloESempreETanto() {
		String verso1 = "Antes, e com tal zelo, e sempre, e tanto";
		Assert.assertEquals(10, escansao.contarSilabasPoeticas(verso1));
	}

	@Test
	public void deTudoAoMeuAmorSereiAtento() {
		String verso1 = "De tudo ao meu amor serei atento";
		Assert.assertEquals(10, escansao.contarSilabasPoeticas(verso1));
	}

	@Test
	public void eFeridaQueDoiENaoSeSenteTest() {
		String verso1 = "é ferida que dói e não se sente";
		Assert.assertEquals(9, escansao.contarSilabasPoeticas(verso1));
	}

	@Test
	public void subiuAConstrucaoComoSeFosseMaquina() {
		String verso1 = "Subiu a construção como se fosse máquina";
		Assert.assertEquals(12, escansao.contarSilabasPoeticas(verso1));
	}

	@Test
	public void deveConter12SilabasPoeticasConstrucaoTest() {
		String verso1 = "Amou daquela vez como se fosse a última";
		String verso2 = "Beijou sua mulher como se fosse a última";
		String verso3 = "E cada filho seu como se fosse o único";
		String verso4 = "E atravessou a rua com seu passo tímido";
		String verso5 = "Subiu a construção como se fosse máquina";
		String verso6 = "Ergueu no patamar quatro paredes sólidas"; // ergueu tá
																	// separando
																	// errado
		String verso7 = "Tijolo com tijolo num desenho mágico";
		String verso8 = "Seus olhos embotados de cimento e lágrima";
		String verso9 = "Sentou pra descansar como se fosse sábado";
		// String verso10 = "Comeu feijão com arroz como se fosse um príncipe";
		// //parece ser o unico verso com 13 silaas poeticas

		Assert.assertEquals(12, escansao.contarSilabasPoeticas(verso1));
		Assert.assertEquals(12, escansao.contarSilabasPoeticas(verso2));
		Assert.assertEquals(12, escansao.contarSilabasPoeticas(verso3));
		Assert.assertEquals(12, escansao.contarSilabasPoeticas(verso4));
		Assert.assertEquals(12, escansao.contarSilabasPoeticas(verso5));
		Assert.assertEquals(12, escansao.contarSilabasPoeticas(verso6));
		Assert.assertEquals(12, escansao.contarSilabasPoeticas(verso7));
		Assert.assertEquals(12, escansao.contarSilabasPoeticas(verso8));
		Assert.assertEquals(12, escansao.contarSilabasPoeticas(verso9));
		// Assert.assertEquals(12, escansao.quantidadeSilabasPoeticas(verso10));

	}

	@Test
	public void deveConter12SilabasPoeticasTest() {
		String verso1 = "Amou daquela vez como se fosse a última";
		Assert.assertEquals(12, escansao.contarSilabasPoeticas(verso1));
	}

	@Test
	public void deveConter15SilabasGramaticaisTest() {
		String verso1 = "Amou daquela vez como se fosse a última";
		Assert.assertEquals(15, escansao.contarSilabasGramaticais(verso1));
	}

	@Test
	public void deveConter11SilabasPoeticasTest() {
		String verso1 = "E das bocas unidas fez-se a espuma";
		Assert.assertEquals(11, escansao.contarSilabasPoeticas(verso1));
	}

	@Test
	public void deveConter10SilabasPoeticasTest() {
		String verso = "Silencioso e branco como a bruma";
		Assert.assertEquals(10, escansao.contarSilabasPoeticas(verso));

	}

	@Test
	public void deveConter8SilabasPoeticasTest() {
		String verso = "silencioso estava aqui";
		Assert.assertEquals(8, escansao.contarSilabasPoeticas(verso));
	}

	@Test
	public void deveConter10SilabasGramaticaisTest() {
		String verso = "silencioso estava aqui";
		Assert.assertEquals(10, escansao.contarSilabasGramaticais(verso));
	}

	@Test
	public void quantidadeDeSilabasPoeticasPorVersoTest() {
		String verso0 = "De repente do riso fez-se o pranto";
		String verso1 = "Silencioso e branco como a bruma";
		String verso2 = "E das bocas unidas fez-se a espuma";
		String verso3 = "E das mãos espalmadas fez-se o espanto";

		Assert.assertEquals(10, escansao.contarSilabasPoeticas(verso0));
		Assert.assertEquals(10, escansao.contarSilabasPoeticas(verso1));
		Assert.assertEquals(11, escansao.contarSilabasPoeticas(verso2));
		Assert.assertEquals(11, escansao.contarSilabasPoeticas(verso3));
	}

	@Test
	public void quantidadeDeSilabasGramaticaisPorVersoTest() {
		String verso0 = "De repente do riso fez-se o pranto";
		String verso1 = "Silencioso e branco como a bruma";
		String verso2 = "E das bocas unidas fez-se a espuma";
		String verso3 = "E das mãos espalmadas fez-se o espanto";

		Assert.assertEquals(12, escansao.contarSilabasGramaticais(verso0));
		Assert.assertEquals(13, escansao.contarSilabasGramaticais(verso1));
		Assert.assertEquals(13, escansao.contarSilabasGramaticais(verso2));
		Assert.assertEquals(13, escansao.contarSilabasGramaticais(verso3));
	}

}
