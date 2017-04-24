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
	public void deveConter12SilabasPoeticasConstrucaoTest() {
		String verso1 = "Amou daquela vez como se fosse a última";
		String verso2 = "Beijou sua mulher como se fosse a última";
		String verso3 = "E cada filho seu como se fosse o único";
		String verso4 = "E atravessou a rua com seu passo tímido"; 
		String verso5 = "Subiu a construção como se fosse máquina"; 
		String verso6 = "Ergueu no patamar quatro paredes sólidas";  // ergueu tá separando errado 
		String verso7 = "Tijolo com tijolo num desenho mágico";
		String verso8 = "Seus olhos embotados de cimento e lágrima";
		String verso9 = "Sentou pra descansar como se fosse sábado";
//		String verso10 = "Comeu feijão com arroz como se fosse um príncipe"; //parece ser o unico verso com 13 silaas poeticas
		
		Assert.assertEquals(12, escansao.quantidadeSilabasPoeticas(verso1));
		Assert.assertEquals(12, escansao.quantidadeSilabasPoeticas(verso2));
		Assert.assertEquals(12, escansao.quantidadeSilabasPoeticas(verso3));
		Assert.assertEquals(12, escansao.quantidadeSilabasPoeticas(verso4));
		Assert.assertEquals(12, escansao.quantidadeSilabasPoeticas(verso5));
		Assert.assertEquals(12, escansao.quantidadeSilabasPoeticas(verso6));
		Assert.assertEquals(12, escansao.quantidadeSilabasPoeticas(verso7));
		Assert.assertEquals(12, escansao.quantidadeSilabasPoeticas(verso8));
		Assert.assertEquals(12, escansao.quantidadeSilabasPoeticas(verso9));
//		Assert.assertEquals(12, escansao.quantidadeSilabasPoeticas(verso10));
		
	}
	
	
	@Test
	public void deveConter12SilabasPoeticasTest() {
		String verso1 = "Amou daquela vez como se fosse a última";
		Assert.assertEquals(12, escansao.quantidadeSilabasPoeticas(verso1));
	}
	
	@Test
	public void deveConter15SilabasGramaticaisTest() {
		String verso1 = "Amou daquela vez como se fosse a última";
		Assert.assertEquals(15, escansao.quantidadeSilabasGramaticais(verso1));
	}
	
	@Test
	public void deveConter11SilabasPoeticasTest() {
		String verso1 = "E das bocas unidas fez-se a espuma";
		Assert.assertEquals(11, escansao.quantidadeSilabasPoeticas(verso1));
	}
	
	@Test
	public void deveConter10SilabasPoeticasTest() {
		String verso = "Silencioso e branco como a bruma";
		Assert.assertEquals(10, escansao.quantidadeSilabasPoeticas(verso));

	}

	@Test
	public void deveConter8SilabasPoeticasTest() {
		String verso = "silencioso estava aqui";
		Assert.assertEquals(8, escansao.quantidadeSilabasPoeticas(verso));
	}

	@Test
	public void deveConter10SilabasGramaticaisTest() {
		String verso = "silencioso estava aqui";
		Assert.assertEquals(10, escansao.quantidadeSilabasGramaticais(verso));
	}

	@Test
	public void versosSeparadosPorSilabasPoeticasTest() {
		String verso0 = "De repente do riso fez-se o pranto";
		String verso1 = "Silencioso e branco como a bruma";
		String verso2 = "E das bocas unidas fez-se a espuma";
		String verso3 = "E das mãos espalmadas fez-se o espanto";

		Assert.assertEquals(10, escansao.quantidadeSilabasPoeticas(verso0));
		Assert.assertEquals(10, escansao.quantidadeSilabasPoeticas(verso1));
		Assert.assertEquals(11, escansao.quantidadeSilabasPoeticas(verso2));
		Assert.assertEquals(11, escansao.quantidadeSilabasPoeticas(verso3));
	}

	@Test
	public void versosSeparadosPorSilabasGramaticasisTest() {
		String verso0 = "De repente do riso fez-se o pranto";
		String verso1 = "Silencioso e branco como a bruma";
		String verso2 = "E das bocas unidas fez-se a espuma";
		String verso3 = "E das mãos espalmadas fez-se o espanto";

		Assert.assertEquals(12, escansao.quantidadeSilabasGramaticais(verso0));
		Assert.assertEquals(13, escansao.quantidadeSilabasGramaticais(verso1));
		Assert.assertEquals(13, escansao.quantidadeSilabasGramaticais(verso2));
		Assert.assertEquals(13, escansao.quantidadeSilabasGramaticais(verso3));
	}

}
