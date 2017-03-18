package versificacao;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

public class EscansaoTest {

	private Escansao escansao;

	@Before
	public void setUp() {
		escansao = new Escansao();
	}

	// @Test
	public void fazerSeparacaoSilabicaGramaticalTest() throws Exception {
		String verso = "E de sozinho o que se fez contente";
		String silabasGramaticaisSeparadas = escansao.fazerSeparacaoSilabicaDoVerso(verso);
		String silabas = "E de so zi nho o que se fez con ten te";
		Assert.assertEquals(silabas.toLowerCase(), silabasGramaticaisSeparadas);
	}

	// @Test
	public void fazerSeparacaoSilabicaGramaticalDeUmVersoComVirgulaTest() throws Exception {
		String verso = "De repente, n�o mais que de repente";
		String silabasGramaticaisSeparadas = escansao.fazerSeparacaoSilabicaDoVerso(verso);
		String silabas = "De re pen te, n�o mais que de re pen te";
		Assert.assertEquals(silabas.toLowerCase(), silabasGramaticaisSeparadas);
	}

	// @Test
	public void palavraTemQueVirSemAcentuacaoEPontuacaoTest() {
		Assert.assertEquals("atencao", escansao.removerAcentuacao("aten��o!"));
		Assert.assertEquals("axe", escansao.removerAcentuacao("ax�!"));
		Assert.assertEquals("sera", escansao.removerAcentuacao("ser�?"));
		Assert.assertEquals("assim", escansao.removerAcentuacao("assim,"));
	}

	// @Test
	public void palavraPesquisadaIgualAPalavaDaPagina() throws Exception {
		String dicio = "https://www.dicio.com.br/";
		String palavraMais = "mais";
		AcessoASiteUtils.acessarOSiteECriarOArquivo(Escansao.getPagina(dicio + palavraMais));
		Assert.assertFalse(escansao.palavrasSaoIguais(palavraMais));

	}

	// @Test
	// public void fazerSeparcaoSilabicaDeUmaPalavra() throws
	// FileNotFoundException, IOException, Exception {
	// String palavraSeparada = escansao.separarAPalavra("conceder");
	// Assert.assertEquals("con-ce-der", palavraSeparada);
	// }

	// @Test
	public void deveRetornarUmaPalavraComAsSilabasSeparadas() {
		String palavraSeparada = Escansao.fazerSeparacaoSilabica("bolsa");
		Assert.assertEquals("bol-sa", palavraSeparada);
		String palavraSeparada2 = Escansao.fazerSeparacaoSilabica("conceder");
		Assert.assertEquals("con-ce-der", palavraSeparada2);
	}

	// @Test
	public void deveRetornarUmVerboNaoConjugado() throws Exception {
		String verbo = Escansao.descobrirVerboNaoConjugado("morando");
		Assert.assertEquals("morar", verbo);
	}

	// @Test
	public void deveRetornarInterjeicaoESubstantivoFeminino() throws Exception {
		List<String> classesGramaticais = Escansao.descobrirClassesGramaticais("isca");
		Assert.assertTrue(classesGramaticais.contains("interjei��o"));
		Assert.assertTrue(classesGramaticais.contains("substantivo feminino"));
	}

	@Test
	public void deveRetornarOTituloDoSite() throws SAXException, IOException, Exception {
//		String dicio = "https://www.dicio.com.br/";
//		String titulo = escansao.acessarPagina(dicio + "paciencia");
//		Assert.assertEquals("Paci�ncia - Dicion�rio Online de Portugu�s", null);
	}

}
