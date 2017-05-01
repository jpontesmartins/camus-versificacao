package versificacao.entidades;

import org.junit.Assert;
import org.junit.Test;

public class PalavraTest {

	@Test
	public void deveReconhecerProparoxitonas() {
		Palavra palavra = new Palavra("modéstia");
		Assert.assertEquals("PROPAROXÍTONA", palavra.getTonicidade());
		Assert.assertEquals("dés", palavra.getSilabaTonica());

	}

	@Test
	public void deveReconherParoxitonas() {
		Palavra palavra2 = new Palavra("modesto");
		Assert.assertEquals("PAROXÍTONA", palavra2.getTonicidade());
		Assert.assertEquals("des", palavra2.getSilabaTonica());
	}

}
