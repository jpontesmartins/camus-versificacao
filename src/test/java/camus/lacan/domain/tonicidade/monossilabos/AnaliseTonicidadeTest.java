package camus.lacan.domain.tonicidade.monossilabos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import camus.lacan.domain.tonicidade.TonicidadeEnum;
import camus.lacan.domain.tonicidade.monossilabos.AnaliseTonicidade;

public class AnaliseTonicidadeTest {

	AnaliseTonicidade tonicidade;

	@Before
	public void setUp() {
		tonicidade = new AnaliseTonicidade();
	}

	@Test
	public void deve_reconher_oxitona_juiz() {
		Assert.assertEquals(TonicidadeEnum.OXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("juiz"));
	}

	@Test
	public void deve_reconhece_oxitona_sabia() {
		Assert.assertEquals(TonicidadeEnum.OXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("sabiá"));
	}

	@Test
	public void deve_reconhece_oxitona_jejum() {
		Assert.assertEquals(TonicidadeEnum.OXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("jejum"));
	}

	@Test
	public void deve_reconhece_oxitona_feliz() {
		Assert.assertEquals(TonicidadeEnum.OXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("feliz"));
	}

	@Test
	public void deve_reconhecer_paroxitona_casa() {
		Assert.assertEquals(TonicidadeEnum.PAROXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("casa"));
	}

	@Test
	public void deve_reconhecer_paroxitona_garrafa() {
		Assert.assertEquals(TonicidadeEnum.PAROXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("garrafa"));
	}

	@Test
	public void deve_reconhecer_paroxitona_tiro() {
		Assert.assertEquals(TonicidadeEnum.PAROXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("tiro"));
	}

	@Test
	public void deve_reconhecer_paroxitona_teste() {
		Assert.assertEquals(TonicidadeEnum.PAROXITONA.getPosicao(), tonicidade.encontrarTonicidadeDaPalavra("teste"));
	}

	@Test
	public void deve_reonhecer_proparoxitona_poetica() {
		Assert.assertEquals(TonicidadeEnum.PROPAROXITONA.getPosicao(),
				tonicidade.encontrarTonicidadeDaPalavra("poética"));
	}

	@Test
	public void deve_reonhecer_proparoxitona_arvore() {
		Assert.assertEquals(TonicidadeEnum.PROPAROXITONA.getPosicao(),
				tonicidade.encontrarTonicidadeDaPalavra("árvore"));
	}

	@Test
	public void deve_reonhecer_proparoxitona_ultima() {
		Assert.assertEquals(TonicidadeEnum.PROPAROXITONA.getPosicao(),
				tonicidade.encontrarTonicidadeDaPalavra("última"));
	}

	@Test
	public void deve_reonhecer_proparoxitona_otimo() {
		Assert.assertEquals(TonicidadeEnum.PROPAROXITONA.getPosicao(),
				tonicidade.encontrarTonicidadeDaPalavra("ótimo"));
	}
	
	@Test
	public void deve_reonhecer_proparoxitona_frutifero() {
		Assert.assertEquals(TonicidadeEnum.PROPAROXITONA.getPosicao(),
				tonicidade.encontrarTonicidadeDaPalavra("frutífero"));
	}
	
	@Test
	public void deve_reonhecer_proparoxitona_pendulo() {
		Assert.assertEquals(TonicidadeEnum.PROPAROXITONA.getPosicao(),
				tonicidade.encontrarTonicidadeDaPalavra("pêndulo"));
	}

	@Test
	public void deve_retornar_silaba_tonica_acentuada() {
		Assert.assertEquals("é", tonicidade.encontrarSilabaTonica("poética"));
		Assert.assertEquals("pós", tonicidade.encontrarSilabaTonica("póstumo"));
		Assert.assertEquals("pró", tonicidade.encontrarSilabaTonica("próximo"));
		Assert.assertEquals("ár", tonicidade.encontrarSilabaTonica("árvore"));
		Assert.assertEquals("ô", tonicidade.encontrarSilabaTonica("ônibus"));
		Assert.assertEquals("úl", tonicidade.encontrarSilabaTonica("último"));
		Assert.assertEquals("á", tonicidade.encontrarSilabaTonica("átimo"));
		Assert.assertEquals("pró", tonicidade.encontrarSilabaTonica("pródigo"));
		Assert.assertEquals("bê", tonicidade.encontrarSilabaTonica("bêbado"));
	}

	@Test
	public void deve_retornar_silaba_tonica() {
		Assert.assertEquals("ca", tonicidade.encontrarSilabaTonica("casa"));
		Assert.assertEquals("lher", tonicidade.encontrarSilabaTonica("mulher"));
		Assert.assertEquals("mal", tonicidade.encontrarSilabaTonica("normal"));
		Assert.assertEquals("ru", tonicidade.encontrarSilabaTonica("peru"));
		Assert.assertEquals("zol", tonicidade.encontrarSilabaTonica("anzol"));
		Assert.assertEquals("dor", tonicidade.encontrarSilabaTonica("computador"));
		Assert.assertEquals("ter", tonicidade.encontrarSilabaTonica("cateter"));
		Assert.assertEquals("tal", tonicidade.encontrarSilabaTonica("cristal"));
		Assert.assertEquals("nil", tonicidade.encontrarSilabaTonica("funil"));
		Assert.assertEquals("vil", tonicidade.encontrarSilabaTonica("covil"));

	}

	@Test
	public void deve_retornar_silaba_tonica_das_oxitonas() {
		Assert.assertEquals("clo", tonicidade.encontrarSilabaTonica("ciclope"));
		Assert.assertEquals("po", tonicidade.encontrarSilabaTonica("pipoca"));
		Assert.assertEquals("da", tonicidade.encontrarSilabaTonica("cidade"));
		Assert.assertEquals("ci", tonicidade.encontrarSilabaTonica("acrobacia"));
		Assert.assertEquals("te", tonicidade.encontrarSilabaTonica("caracteres"));
		Assert.assertEquals("di", tonicidade.encontrarSilabaTonica("erudito"));
		Assert.assertEquals("ri", tonicidade.encontrarSilabaTonica("desvario"));
		Assert.assertEquals("e", tonicidade.encontrarSilabaTonica("poema"));
	}

}
