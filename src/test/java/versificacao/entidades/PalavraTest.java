package versificacao.entidades;

import org.junit.Assert;
import org.junit.Test;

public class PalavraTest {

	@Test
	public void deveReconhecerProparoxitonas() {
		Palavra palavra = new Palavra("modéstia");
		Assert.assertEquals("proparoxítona", palavra.getTonicidade());
		Assert.assertEquals("dés", palavra.getSilabaTonica());

	}

	@Test
	public void deveReconherParoxitonas() {
		Palavra palavra2 = new Palavra("modesto");
		Assert.assertEquals("paroxítona", palavra2.getTonicidade());
		Assert.assertEquals("des", palavra2.getSilabaTonica());
	}

}
