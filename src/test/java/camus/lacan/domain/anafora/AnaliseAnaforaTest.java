package camus.lacan.domain.anafora;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import camus.lacan.domain.anafora.AnaliseAnafora;

public class AnaliseAnaforaTest {

	@Test
	public void deve_reconhecer_primeiras_palavras_iguais() {
		List<String> versos = new ArrayList<>();
		versos.add("e tudo acabou");
		versos.add("e tudo fugiu");
		versos.add("e tudo mofou");
		versos.add("e agora, josé?");
		
		Assert.assertTrue(new AnaliseAnafora().temAnaforaNosVersos(versos));
	}

}
