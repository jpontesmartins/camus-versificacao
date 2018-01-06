package camus.lacan.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import camus.lacan.domain.tonicidade.Tonicidade;
import camus.lacan.domain.tonicidade.TonicidadeEnum;

public class TonicidadeTest {

	Tonicidade tonicidade;

	@Before
	public void setUp() {
		tonicidade = new Tonicidade();
	}
	
	@Test
	public void identificarEm() {
		Assert.assertEquals("em", tonicidade.encontrarSilabaTonica("em"));
	}
	

	public void identificarMonossilabosAtonos() {
		Assert.assertEquals(TonicidadeEnum.OXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("que"));
	}
	
	@Test
	public void identificarMonossilabosTonicos() {
		Assert.assertEquals(TonicidadeEnum.MONOSSILABO.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("quê"));
		Assert.assertEquals(TonicidadeEnum.MONOSSILABO.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("nós"));
		Assert.assertEquals(TonicidadeEnum.MONOSSILABO.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("voz"));
	}

	@Test
	public void reconheceJuizComoOxitonaTest() {
		Assert.assertEquals(TonicidadeEnum.OXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("juiz"));
	}

	@Test
	public void reconheceOxitonaTest() {
		Assert.assertEquals(TonicidadeEnum.OXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("sabiá"));
		Assert.assertEquals(TonicidadeEnum.OXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("jejum"));
		Assert.assertEquals(TonicidadeEnum.OXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("feliz"));
	}

	@Test
	public void reconheceParoxitonaTest() {
		Assert.assertEquals(TonicidadeEnum.PAROXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("casa"));
		Assert.assertEquals(TonicidadeEnum.PAROXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("garrafa"));
		Assert.assertEquals(TonicidadeEnum.PAROXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("tiro"));
		Assert.assertEquals(TonicidadeEnum.PAROXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("teste"));
	}

	@Test
	public void reconheceProparoxitonaTest() {
		Assert.assertEquals(TonicidadeEnum.PROPAROXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("poética"));
		Assert.assertEquals(TonicidadeEnum.PROPAROXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("árvore"));
		Assert.assertEquals(TonicidadeEnum.PROPAROXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("última"));
		Assert.assertEquals(TonicidadeEnum.PROPAROXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("ótimo"));
		Assert.assertEquals(TonicidadeEnum.PROPAROXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("frutífero"));
		Assert.assertEquals(TonicidadeEnum.PROPAROXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("frutífero"));
	}

	@Test
	public void palavrasComAcentoTest() {
		Assert.assertEquals("é", tonicidade.encontrarSilabaTonica("poética"));
		Assert.assertEquals("pós", tonicidade.encontrarSilabaTonica("póstumo"));
		Assert.assertEquals("pró", tonicidade.encontrarSilabaTonica("próximo"));
		Assert.assertEquals("ár", tonicidade.encontrarSilabaTonica("árvore"));
		Assert.assertEquals("ô", tonicidade.encontrarSilabaTonica("ônibus"));
		Assert.assertEquals("úl", tonicidade.encontrarSilabaTonica("último"));
		Assert.assertEquals("á", tonicidade.encontrarSilabaTonica("átimo"));
		Assert.assertEquals("pró", tonicidade.encontrarSilabaTonica("pródigo"));
		Assert.assertEquals("bê", tonicidade.encontrarSilabaTonica("bêbado"));
	}

	@Test
	public void palavrasOxitonasTest() {
		Assert.assertEquals("ca", tonicidade.encontrarSilabaTonica("casa"));
		Assert.assertEquals("lher", tonicidade.encontrarSilabaTonica("mulher"));
		Assert.assertEquals("mal", tonicidade.encontrarSilabaTonica("normal"));
		Assert.assertEquals("ru", tonicidade.encontrarSilabaTonica("peru"));
		Assert.assertEquals("zol", tonicidade.encontrarSilabaTonica("anzol"));
		Assert.assertEquals("dor", tonicidade.encontrarSilabaTonica("computador"));
		Assert.assertEquals("ter", tonicidade.encontrarSilabaTonica("cateter"));
		Assert.assertEquals("tal", tonicidade.encontrarSilabaTonica("cristal"));
		Assert.assertEquals("nil", tonicidade.encontrarSilabaTonica("funil"));
		Assert.assertEquals("vil", tonicidade.encontrarSilabaTonica("covil"));

	}

	@Test
	public void palavrasParoxitonasTest() {
		Assert.assertEquals("clo", tonicidade.encontrarSilabaTonica("ciclope"));
		Assert.assertEquals("po", tonicidade.encontrarSilabaTonica("pipoca"));
		Assert.assertEquals("da", tonicidade.encontrarSilabaTonica("cidade"));
		Assert.assertEquals("ci", tonicidade.encontrarSilabaTonica("acrobacia"));
		Assert.assertEquals("te", tonicidade.encontrarSilabaTonica("caracteres"));
		Assert.assertEquals("di", tonicidade.encontrarSilabaTonica("erudito"));
		Assert.assertEquals("ri", tonicidade.encontrarSilabaTonica("desvario"));
		Assert.assertEquals("e", tonicidade.encontrarSilabaTonica("poema"));
	}

}
