package camus.lacan.domain.anafora.analise;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ComparacaoDeVersosTest {

	@Test
	public void deve_retornar_algo() {
		
		String versoUm = "e tudo acabou";
		String versoDois = "e tudo fugiu";
		
		List<String> versos = new ArrayList<>();
		versos.add(versoUm);
		versos.add(versoDois);
		
		ComparacaoDeVersos comparacao = new ComparacaoDeVersos(versos);
		ExpressaoRepetida expressaoRepetida = comparacao.compararComOutroVerso(0, 1);
				
		Assert.assertEquals("e tudo",expressaoRepetida.getExpressao());
		
	}

}
