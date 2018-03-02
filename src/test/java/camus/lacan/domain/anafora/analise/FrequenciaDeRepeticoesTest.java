package camus.lacan.domain.anafora.analise;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FrequenciaDeRepeticoesTest {
	
	
	@Test
	public void algo() {
		
		List<String> versos = new ArrayList<>();
		versos.add("e tudo acabou");
		versos.add("e tudo fugiu");
		
		FrequenciaDeRepeticoes frequencia = new FrequenciaDeRepeticoes(versos);
		
		Assert.assertEquals("e tudo", frequencia.getExpressoesRepetidas().get(0).getExpressao());
		Assert.assertEquals(2, frequencia.getFrequenciaDasExpressoes().get("e tudo").intValue());
	}

}
