package camus.lacan.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import camus.lacan.services.EscansaoService;

public class ReconhecerVersosTest {

	EscansaoService escansaoService;

	@Before
	public void setUp() {
		escansaoService = new EscansaoService();
	}

	@Test
	public void poemaCom2EstrofesDe3VersosCada() {
		String poema = "v1§v2§v3§§v4§v5§v6";
		int qtdeVersos = 6;
		int qtdeEstrofes = 2;
		Assert.assertEquals(qtdeVersos, escansaoService.contarVersos(poema));
		Assert.assertEquals(qtdeEstrofes, escansaoService.contarEstrofes(poema));
	}

	@Test
	public void contar3VersosTest() {
		String verso = "Eu possa lhe dizer do amor (que tive):§Que não seja imortal, posto que é chama§Mas que seja infinito enquanto dure";
		int numeroDeVersos = escansaoService.contarVersos(verso);
		Assert.assertEquals(3, numeroDeVersos);
	}

	@Test
	public void encontrarESubstituirQuebrasDeLinhaTest() {
		String frase = "uma frase§outra frase";
		String fraseTratada = escansaoService.substituirQuebraDeLinha(frase);
		Assert.assertEquals("uma frase\noutra frase", fraseTratada);
	}

}
