package versificacao;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EscansaoServiceTest {

	private EscansaoService escansao;

	@Before
	public void setUp() {
		escansao = new EscansaoService();
	}
	
	
	@Test
	public void deveRetornarPalavraSeparada() {
		Assert.assertEquals("tes-tar", escansao.fazerSeparacaoSilabicaDeUmaPalavra("testar"));
	}


	@Test
	public void deveRetornarVersoEscansado() throws FileNotFoundException, IOException, Exception {
		String verso = "testar assim";
		String retorno = escansao.fazerSeparacaoSilabicaDoVerso(verso);
		Assert.assertEquals("tes-tar as-sim", retorno);
	}


	
}
