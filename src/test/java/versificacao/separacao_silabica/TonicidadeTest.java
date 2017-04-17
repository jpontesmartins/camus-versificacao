package versificacao.separacao_silabica;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TonicidadeTest {
	
Tonicidade tonicidade;
	
	@Before
	public void setUp() {
		tonicidade = new Tonicidade();
	}
	
	
	@Test
	public void reconheceOxitonaTest() {
		Assert.assertEquals(Tonicidade.OXITONA,tonicidade.encontrarTonicidadeDaPalavra("voz"));
		Assert.assertEquals(Tonicidade.OXITONA,tonicidade.encontrarTonicidadeDaPalavra("sabiá"));
		Assert.assertEquals(Tonicidade.OXITONA,tonicidade.encontrarTonicidadeDaPalavra("nós"));
		Assert.assertEquals(Tonicidade.OXITONA,tonicidade.encontrarTonicidadeDaPalavra("jejum"));
		Assert.assertEquals(Tonicidade.OXITONA,tonicidade.encontrarTonicidadeDaPalavra("feliz"));
	}
	
	@Test
	public void reconheceParoxitonaTest() {
		Assert.assertEquals(Tonicidade.PAROXITONA,tonicidade.encontrarTonicidadeDaPalavra("casa"));
		Assert.assertEquals(Tonicidade.PAROXITONA,tonicidade.encontrarTonicidadeDaPalavra("garrafa"));
		Assert.assertEquals(Tonicidade.PAROXITONA,tonicidade.encontrarTonicidadeDaPalavra("tiro"));
		Assert.assertEquals(Tonicidade.PAROXITONA,tonicidade.encontrarTonicidadeDaPalavra("teste"));
	}
	
	
	@Test
	public void reconheceProparoxitonaTest() {
		Assert.assertEquals(Tonicidade.PROPAROXITONA,tonicidade.encontrarTonicidadeDaPalavra("poética"));
		Assert.assertEquals(Tonicidade.PROPAROXITONA,tonicidade.encontrarTonicidadeDaPalavra("árvore"));
		Assert.assertEquals(Tonicidade.PROPAROXITONA,tonicidade.encontrarTonicidadeDaPalavra("última"));
		Assert.assertEquals(Tonicidade.PROPAROXITONA,tonicidade.encontrarTonicidadeDaPalavra("ótimo"));
		Assert.assertEquals(Tonicidade.PROPAROXITONA,tonicidade.encontrarTonicidadeDaPalavra("frutífero"));
	}
	
	@Test
	public void palavrasComAcentoTest() {
		Assert.assertEquals("é",tonicidade.encontrarSilabaTonica("poética"));
		Assert.assertEquals("pós",tonicidade.encontrarSilabaTonica("póstumo"));
		Assert.assertEquals("pró",tonicidade.encontrarSilabaTonica("próximo"));
		Assert.assertEquals("ár",tonicidade.encontrarSilabaTonica("árvore"));
		Assert.assertEquals("ô",tonicidade.encontrarSilabaTonica("ônibus"));
		Assert.assertEquals("úl",tonicidade.encontrarSilabaTonica("último"));
		Assert.assertEquals("á",tonicidade.encontrarSilabaTonica("átimo"));
		Assert.assertEquals("pró",tonicidade.encontrarSilabaTonica("pródigo"));
		Assert.assertEquals("bê",tonicidade.encontrarSilabaTonica("bêbado"));
	}
	
	@Test
	public void palavrasOxitonasTest() {
		Assert.assertEquals("ca",tonicidade.encontrarSilabaTonica("casa"));
		Assert.assertEquals("lher",tonicidade.encontrarSilabaTonica("mulher"));
		Assert.assertEquals("mal",tonicidade.encontrarSilabaTonica("normal"));
		Assert.assertEquals("ru",tonicidade.encontrarSilabaTonica("peru"));
		Assert.assertEquals("zol",tonicidade.encontrarSilabaTonica("anzol"));
		Assert.assertEquals("dor",tonicidade.encontrarSilabaTonica("computador"));
		Assert.assertEquals("ter",tonicidade.encontrarSilabaTonica("cateter"));
		Assert.assertEquals("tal",tonicidade.encontrarSilabaTonica("cristal"));
		Assert.assertEquals("nil",tonicidade.encontrarSilabaTonica("funil"));
		Assert.assertEquals("vil",tonicidade.encontrarSilabaTonica("covil"));
		
	}
	
	@Test
	public void palavrasParoxitonasTest() {
		Assert.assertEquals("clo",tonicidade.encontrarSilabaTonica("ciclope"));
		Assert.assertEquals("po",tonicidade.encontrarSilabaTonica("pipoca"));
		Assert.assertEquals("da",tonicidade.encontrarSilabaTonica("cidade"));
		Assert.assertEquals("ci",tonicidade.encontrarSilabaTonica("acrobacia"));
		Assert.assertEquals("te",tonicidade.encontrarSilabaTonica("caracteres"));
		Assert.assertEquals("di",tonicidade.encontrarSilabaTonica("erudito"));
		Assert.assertEquals("ri",tonicidade.encontrarSilabaTonica("desvario"));
		Assert.assertEquals("e",tonicidade.encontrarSilabaTonica("poema"));
	}
	
	
}
