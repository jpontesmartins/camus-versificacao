package camus.lacan.domain.anafora.analise;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import camus.lacan.domain.anafora.Anafora;
import camus.lacan.domain.anafora.analise.AnaliseAnafora;

public class AnaliseAnaforaTest {
	
	
	@Test
	public void deve_retornar_as_palavras_mais_repetidas_de_novo() {
		List<String> versos = new ArrayList<>();
		versos.add("está sem mulher,");
		versos.add("está sem discurso,");
		versos.add("está sem carinho,");
		versos.add("já não pode beber,");
		versos.add("já não pode fumar,");
		versos.add("cuspir já não pode");

		List<Anafora> frequenciasDasAnaforasEncontradas = new AnaliseAnafora().encontrarAnaforas(versos);
		Anafora anaforaMaisFrequente = frequenciasDasAnaforasEncontradas.get(0);

		Assert.assertEquals("e tudo acabou", anaforaMaisFrequente.getVersos().get(0));
		Assert.assertEquals("e tudo fugiu", anaforaMaisFrequente.getVersos().get(1));
		Assert.assertEquals("e tudo mofou", anaforaMaisFrequente.getVersos().get(2));
		Assert.assertEquals("e tudo", anaforaMaisFrequente.getExpressao().trim());
		Assert.assertEquals(3, anaforaMaisFrequente.getFrequecia().intValue());
	}
	
	@Test
	public void deve_retornar_as_palavras_mais_repetidas() {
		List<String> versos = new ArrayList<>();
		versos.add("e tudo acabou");
		versos.add("e tudo fugiu");
		versos.add("e tudo mofou");
		versos.add("e agora, josé?");

		List<Anafora> frequenciasDasAnaforasEncontradas = new AnaliseAnafora().encontrarAnaforas(versos);
		Anafora anaforaMaisFrequente = frequenciasDasAnaforasEncontradas.get(0);

		Assert.assertEquals("e tudo acabou", anaforaMaisFrequente.getVersos().get(0));
		Assert.assertEquals("e tudo fugiu", anaforaMaisFrequente.getVersos().get(1));
		Assert.assertEquals("e tudo mofou", anaforaMaisFrequente.getVersos().get(2));
		Assert.assertEquals("e tudo", anaforaMaisFrequente.getExpressao().trim());
		Assert.assertEquals(3, anaforaMaisFrequente.getFrequecia().intValue());
	}

}
