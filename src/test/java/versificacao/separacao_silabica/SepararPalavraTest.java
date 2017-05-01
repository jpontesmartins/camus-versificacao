package versificacao.separacao_silabica;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SepararPalavraTest {

	SepararPalavra separarPalavra;

	@Before
	public void setUp() {
		separarPalavra = new SepararPalavra();
	}
	
//	@Test
//	public void separarHiatoUE() {
//		Assert.assertEquals("tê nu e", separarPalavra.separar("tênue"));
//	}
//
//	 @Test
//	public void separarFluidezTest() {
//		Assert.assertEquals("flu i dez", separarPalavra.separar("fluidez"));
//	}
	 
	 
	 

	@Test
	public void separarAquiTest() {
		Assert.assertEquals("a qui", separarPalavra.separar("aqui"));
	}

	@Test
	public void separarPeru() {
		Assert.assertEquals("pe ru", separarPalavra.separar("peru"));
	}

	@Test
	public void naoSepararDitongoUI() {
		Assert.assertEquals("gra tui to", separarPalavra.separar("gratuito"));
	}

	@Test
	public void separarDitongoUI2() {
		Assert.assertEquals("flui do", separarPalavra.separar("fluido"));
	}

	@Test
	public void separarDitongoUI1() {
		Assert.assertEquals("mui to", separarPalavra.separar("muito"));
	}

	@Test
	public void separarHiatoOuDitongoUI3() {
		Assert.assertEquals("ju í zo", separarPalavra.separar("juízo"));
	}

	// ruir, ru ir - hiato, oxítona
	// muito, mui to - ditongo, paroxítona
	// juiz, ju iz, - hiato, i seguido de z

	@Test
	public void separarHiatoUI() {
		Assert.assertEquals("flu ir", separarPalavra.separar("fluir"));
		Assert.assertEquals("fu nil", separarPalavra.separar("funil"));
		Assert.assertEquals("ru ir", separarPalavra.separar("ruir"));
		Assert.assertEquals("ru im", separarPalavra.separar("ruim"));
		Assert.assertEquals("tos sir", separarPalavra.separar("tossir"));
	}

	// A terminação verbal ui é normalmente o ditongo decrescente;
	// ora os ditongos decrescentes finais de palavra levam a sílaba tónica para
	// a última sílaba.

	@Test
	public void separarUI() {
		// Exceções: se o encontro vocálico 'i' for seguido pela letra 'z' das
		// palavras oxítonas e paroxítonas,
		// as vogais 'u' e 'i' não formam ditongo, constituem um hiato u-iz e
		// como tal, pertencem a sílabas diferentes
		Assert.assertEquals("ju iz", separarPalavra.separar("juiz"));
	}

	@Test
	public void naoSepararUE() {
		Assert.assertEquals("gue de lhar", separarPalavra.separar("guedelhar"));
	}

	@Test
	public void naoSepararUEI() {
		Assert.assertEquals("quei ra", separarPalavra.separar("queira"));
		Assert.assertEquals("guei xa", separarPalavra.separar("gueixa"));
	}

	@Test
	public void naoSepararUA() {
		Assert.assertEquals("qua tro", separarPalavra.separar("quatro"));
		Assert.assertEquals("quar to", separarPalavra.separar("quarto"));
	}

	@Test
	public void naoSepararUEU() {
		Assert.assertEquals("er gueu", separarPalavra.separar("ergueu"));
	}

	@Test
	public void separarComAcento() {
		Assert.assertEquals("po é ti ca", separarPalavra.separar("poética"));
		Assert.assertEquals("bê ba do", separarPalavra.separar("bêbado"));
		Assert.assertEquals("ô ni bus", separarPalavra.separar("ônibus"));
	}

	@Test
	public void separarOsHiatos() {
		Assert.assertEquals("ju í zo", separarPalavra.separar("juízo"));
		Assert.assertEquals("po e ma", separarPalavra.separar("poema"));
		Assert.assertEquals("po e si a", separarPalavra.separar("poesia"));
		Assert.assertEquals("pi a da", separarPalavra.separar("piada"));
		Assert.assertEquals("se rei a", separarPalavra.separar("sereia"));
		Assert.assertEquals("sa í da", separarPalavra.separar("saída"));
		Assert.assertEquals("sa ú de", separarPalavra.separar("saúde"));
		Assert.assertEquals("e go ís ta", separarPalavra.separar("egoísta"));
		Assert.assertEquals("e po pei a", separarPalavra.separar("epopeia"));
		Assert.assertEquals("si len ci o so", separarPalavra.separar("silencioso"));
		Assert.assertEquals("fe ri a do", separarPalavra.separar("feriado"));
		Assert.assertEquals("fa ti a do", separarPalavra.separar("fatiado"));
		Assert.assertEquals("vo o", separarPalavra.separar("voo"));
	}

	@Test
	public void palavrasDaParede() {


		Assert.assertEquals("a ven tal", separarPalavra.separar("avental"));
		Assert.assertEquals("a ten ção", separarPalavra.separar("atenção"));
		Assert.assertEquals("as tu to", separarPalavra.separar("astuto"));
		Assert.assertEquals("a li nha do", separarPalavra.separar("alinhado"));
		Assert.assertEquals("es tre la", separarPalavra.separar("estrela"));
		Assert.assertEquals("pers cru tar", separarPalavra.separar("perscrutar"));
		Assert.assertEquals("pers pi caz", separarPalavra.separar("perspicaz"));
		Assert.assertEquals("sols tí ci o", separarPalavra.separar("solstício"));
		Assert.assertEquals("ab di car", separarPalavra.separar("abdicar"));
		Assert.assertEquals("plan ta", separarPalavra.separar("planta"));
		Assert.assertEquals("mons tro", separarPalavra.separar("monstro"));
		Assert.assertEquals("is quei ro", separarPalavra.separar("isqueiro"));

	}

	@Test
	public void identificarVogaisAcentuadas() {
		Assert.assertEquals("sim pá ti co", separarPalavra.separar("simpático"));
		Assert.assertEquals("não", separarPalavra.separar("não"));
	}

	@Test
	public void separarOsDigrafosSeparaveisTest() {
		Assert.assertEquals("as saz", separarPalavra.separar("assaz"));
		Assert.assertEquals("ar ru ma da", separarPalavra.separar("arrumada"));
		Assert.assertEquals("ar roz", separarPalavra.separar("arroz"));
		Assert.assertEquals("ex ce ção", separarPalavra.separar("exceção"));
	}

	@Test
	public void naoSepararEncontrosConsonantaisComLERTest() {
		Assert.assertEquals("ca pri cho sa", separarPalavra.separar("caprichosa"));
		Assert.assertEquals("tris te za", separarPalavra.separar("tristeza"));
		Assert.assertEquals("re cla me", separarPalavra.separar("reclame"));
		Assert.assertEquals("dra ma", separarPalavra.separar("drama"));
	}

	@Test
	public void naoSepararOsDigrafosInseparaveisTest() {
		Assert.assertEquals("mi lho", separarPalavra.separar("milho"));
		Assert.assertEquals("ni nho", separarPalavra.separar("ninho"));
		Assert.assertEquals("cha péu", separarPalavra.separar("chapéu"));
		Assert.assertEquals("lha ma", separarPalavra.separar("lhama"));
		Assert.assertEquals("es qui lo", separarPalavra.separar("esquilo"));
		Assert.assertEquals("que da", separarPalavra.separar("queda"));
		Assert.assertEquals("guer ra", separarPalavra.separar("guerra"));
	}

	@Test
	public void naoSepararOsDitongosTest() {
		Assert.assertEquals("pai sa gem", separarPalavra.separar("paisagem"));
		Assert.assertEquals("cha péu", separarPalavra.separar("chapéu"));
	}

	@Test
	public void identificarQueEhVogal() {
		Assert.assertTrue(separarPalavra.isVogal('á'));
		Assert.assertTrue(separarPalavra.isVogal('a'));
		Assert.assertTrue(separarPalavra.isVogal('A'));
		Assert.assertTrue(separarPalavra.isVogal('e'));
		Assert.assertTrue(separarPalavra.isVogal('I'));
		Assert.assertFalse(separarPalavra.isVogal('b'));
	}

}
