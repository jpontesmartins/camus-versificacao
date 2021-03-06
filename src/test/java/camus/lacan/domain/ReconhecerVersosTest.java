package camus.lacan.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import camus.lacan.domain.escansao.EscansaoService;

public class ReconhecerVersosTest {

	EscansaoService escansaoService;

	@Before
	public void setUp() {
		escansaoService = new EscansaoService();
	}
	
	@Test
	public void reconhecerVersos() {
		String poema = "um§dois§três";
		Assert.assertEquals("um", escansaoService.identificarVersos(poema).get(0).getVerso());
		Assert.assertEquals("dois", escansaoService.identificarVersos(poema).get(1).getVerso());
		Assert.assertEquals("três", escansaoService.identificarVersos(poema).get(2).getVerso());

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

}
