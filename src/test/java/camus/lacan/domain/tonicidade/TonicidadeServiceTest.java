package camus.lacan.domain.tonicidade;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import camus.lacan.domain.Palavra;

public class TonicidadeServiceTest {

	TonicidadeService tonicidadeService;
	
	@Before
	public void setup() {
		tonicidadeService = new TonicidadeService();
	}

	@Test
	public void deve_retornar_palavra_casa_com_silaba_tonica_e_tonicidade() {
		Palavra palavra = tonicidadeService.encontrarSilabaTonica("casa");

		Assert.assertEquals("casa", palavra.getGrafia());
		Assert.assertEquals("ca", palavra.getSilabaTonica());
		Assert.assertEquals("paroxítona", palavra.getTonicidade());
	}
	
	@Test
	public void deve_retornar_palavra_costume_com_silaba_tonica_e_tonicidade() {
		Palavra palavra = tonicidadeService.encontrarSilabaTonica("costume");

		Assert.assertEquals("costume", palavra.getGrafia());
		Assert.assertEquals("tu", palavra.getSilabaTonica());
		Assert.assertEquals("paroxítona", palavra.getTonicidade());
	}
	
	@Test
	public void deve_retornar_palavra_otimo_com_silaba_tonica_e_tonicidade() {
		Palavra palavra = tonicidadeService.encontrarSilabaTonica("ótimo");

		Assert.assertEquals("ótimo", palavra.getGrafia());
		Assert.assertEquals("ó", palavra.getSilabaTonica());
		Assert.assertEquals("proparoxítona", palavra.getTonicidade());
	}
	
	@Test
	public void deve_retornar_palavra_xicara_com_silaba_tonica_e_tonicidade() {
		Palavra palavra = tonicidadeService.encontrarSilabaTonica("xícara");

		Assert.assertEquals("xícara", palavra.getGrafia());
		Assert.assertEquals("xí", palavra.getSilabaTonica());
		Assert.assertEquals("proparoxítona", palavra.getTonicidade());
	}
	
	@Test
	public void deve_retornar_palavra_nos_acento_com_silaba_tonica_e_tonicidade() {
		Palavra palavra = tonicidadeService.encontrarSilabaTonica("nós");

		Assert.assertEquals("nós", palavra.getGrafia());
		Assert.assertEquals("nós", palavra.getSilabaTonica());
		Assert.assertEquals("monossílabo tônico", palavra.getTonicidade());
	}
	
	@Test
	public void deve_retornar_palavra_voz_com_silaba_tonica_e_tonicidade() {
		Palavra palavra = tonicidadeService.encontrarSilabaTonica("voz");

		Assert.assertEquals("voz", palavra.getGrafia());
		Assert.assertEquals("voz", palavra.getSilabaTonica());
		Assert.assertEquals("monossílabo tônico", palavra.getTonicidade());
	}
	
	@Test
	public void deve_retornar_palavra_nos_com_silaba_tonica_e_tonicidade() {
		Palavra palavra = tonicidadeService.encontrarSilabaTonica("nos");

		Assert.assertEquals("nos", palavra.getGrafia());
		Assert.assertEquals("nos", palavra.getSilabaTonica());
		Assert.assertEquals("monossílabo átono", palavra.getTonicidade());
	}
	
	@Test
	public void deve_retornar_palavra_me_com_silaba_tonica_e_tonicidade() {
		Palavra palavra = tonicidadeService.encontrarSilabaTonica("me");

		Assert.assertEquals("me", palavra.getGrafia());
		Assert.assertEquals("me", palavra.getSilabaTonica());
		Assert.assertEquals("monossílabo átono", palavra.getTonicidade());
	}


}
