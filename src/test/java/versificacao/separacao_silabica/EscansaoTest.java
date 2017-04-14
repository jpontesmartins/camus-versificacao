package versificacao.separacao_silabica;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EscansaoTest {

	Escansao escansao;

	@Before
	public void setUp() {
		escansao = new Escansao();
	}
	
	
	@Test
	public void deveConter11SilabasPoeticasComRegraDasVogais() {
		String verso = "Fez-se de triste o que se fez amante";
		Assert.assertEquals(11, escansao.quantidadeSilabasPoeticas(verso));
	}
	
	@Test
	public void deveConter12SilabasPoeticasComRegraDasVogais() {
		String verso1 = "E das bocas unidas fez-se a espuma";
		Assert.assertEquals(12, escansao.quantidadeSilabasPoeticas(verso1));
	}

	@Test
	public void deveConter13SilabasGramaticaisNoVersoTest() {
		String verso0 = "Silencioso e branco como a bruma";
		String verso1 = "E das bocas unidas fez-se a espuma";
		String verso2 = "E das mãos espalmadas fez-se o espanto";

		Assert.assertEquals(13, escansao.quantidadeSilabasGramaticais(verso0));
		Assert.assertEquals(13, escansao.quantidadeSilabasGramaticais(verso1));
		Assert.assertEquals(13, escansao.quantidadeSilabasGramaticais(verso2));
	}

	@Test
	public void deveConter12SilabasGramaticaisNoVersoTest() {
		String verso = "De repente do riso fez-se o pranto";
		Assert.assertEquals(12, escansao.quantidadeSilabasGramaticais(verso));

	}
}
