package camus.lacan.domain;

import org.junit.Assert;
import org.junit.Test;

public class AnaliseAnaforaTest {

	@Test
	public void deve_reconhecer_primeira_palavra_igual() {
		String verso1 = "e tudo acabou";
		String verso2 = "e tudo fugiu";
		AnaliseAnafora analiseAnafora = new AnaliseAnafora();
		boolean contemAnaforaNoInicio = analiseAnafora.temAnaforaNosVersos(verso1, verso2);

		Assert.assertTrue(contemAnaforaNoInicio);
	}

}
