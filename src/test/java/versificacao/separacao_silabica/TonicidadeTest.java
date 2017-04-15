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
	public void palavrasOxitonasTest() {
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
