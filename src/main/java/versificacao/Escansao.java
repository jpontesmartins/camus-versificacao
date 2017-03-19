package versificacao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Escansao {
	
	private static final int TAMAMANHO_MARCADOR_GRAFIA_CORRETA = 17;
	public static final String C_TESTE_PAGE4_TXT = "C:\\teste\\page4.txt";
	public static final String C_TESTE_PAGE3_TXT = "C:\\teste\\page3.txt";
	private static final String MARCADOR_CLASSE_GRAMATICAL = "Classe gramatical:";
	private static final String MARCADOR_DIVISAO_SILABICA = " Separacao das silabas: ";
	private static final String MARCADOR_NAO_CONFUNDIR_COM = "<span>N„o confundir com:";
	private static final String MARCADOR_GRAFIA_CORRETA = "tit-significado";

	public static final String DICIO = "https://www.dicio.com.br/";

	public String fazerSeparacaoSilabicaDoVerso(String frase) throws FileNotFoundException, IOException, Exception {
		String palavrasDaFrase[] = frase.trim().toLowerCase().split(" ");
		String fraseSeparadaPorSilabas = "";

		for (String palavra : palavrasDaFrase) {
			palavra = removerAcentuacao(palavra);
			palavra = fazerSeparacaoSilabica(palavra);
			fraseSeparadaPorSilabas += " " + palavra.replace("-", " ");
		}
		fraseSeparadaPorSilabas = fraseSeparadaPorSilabas.replaceFirst(" ", "");

		return fraseSeparadaPorSilabas;
	}

	public String removerAcentuacao(String palavra) {
		String caracteresARemover = "·‡„‚‰ÈËÍÎÌÏÓÔÛÚıÙˆ˙˘˚¸Á¡¿√¬ƒ…» ÀÕÃŒœ”“’÷‘⁄Ÿ€‹«";
		String caracteresAceitaveis = "aaaaaeeeeiiiiooooouuuucAAAAAEEEEIIIIOOOOOUUUUC";
		String pontuacao = " ?!,.;";

		for (int i = 0; i < caracteresARemover.length(); i++) {
			palavra = palavra.replace(caracteresARemover.charAt(i), caracteresAceitaveis.charAt(i));
			if (i < pontuacao.length()) {
				palavra = palavra.replace(pontuacao.charAt(i), pontuacao.charAt(0));
			}
		}
		palavra = palavra.replace(" ", "");

		return palavra;
	}

	public boolean identificarLinhaNaoConfundirCom(String linhaAEncontrar) throws Exception {

		AcessoASiteUtils.acessarOSiteECriarOArquivo(getPagina(DICIO + linhaAEncontrar));
		String linha = buscarPalavraSugerida(linhaAEncontrar);
		if (linha != null) {
			AcessoASiteUtils.acessarOSiteECriarOArquivo(getPagina(DICIO +linha.replaceFirst(DICIO,"")));
			linha = buscarPalavraSugerida(linha);
		}
		return false;
	}

	public boolean palavrasSaoIguais(String palavraDoVerso) throws IOException {
		String linhaPoluidaDaGrafiaCorreta = lerLinhaDaGrafiaCorreta();
		int marcadorInicio = linhaPoluidaDaGrafiaCorreta.indexOf("itemprop=\"name\" >") + 17;
		int marcadorFinal = linhaPoluidaDaGrafiaCorreta.indexOf("</h1>");
		String palavraDaPagina = linhaPoluidaDaGrafiaCorreta.substring(marcadorInicio, marcadorFinal);
		return palavraDoVerso.equalsIgnoreCase(palavraDaPagina);
		
	}
	
	
	
	public static InputStream getPagina(String link) throws Exception {
		URLConnection connection = AcessoASiteUtils.acessarOLink(link);
		return (InputStream) connection.getContent();
	}

	public static List<String> descobrirClassesGramaticais(String palavra) throws Exception {
		String linkParaExtracao = DICIO + palavra;
		InputStream codigoFonteDaPagina = getPagina(linkParaExtracao);

		AcessoASiteUtils.acessarOSiteECriarOArquivo(codigoFonteDaPagina);

		String linhaComAClasseGramatical = lerLinhaDaClasseGramatical();
		linhaComAClasseGramatical = linhaComAClasseGramatical.replace("class=\"adicional\"> ", "");
		linhaComAClasseGramatical = linhaComAClasseGramatical.replace("<br", "");
		linhaComAClasseGramatical = linhaComAClasseGramatical.replace("Classe gramatical: ", "");
		linhaComAClasseGramatical = linhaComAClasseGramatical.replace("<b>", "");
		linhaComAClasseGramatical = linhaComAClasseGramatical.replace("</b>", "");

		if (linhaComAClasseGramatical.length() == 0) {
			descobrirVerboNaoConjugado(palavra);
			return null;
		}

		String primeirasClassesGramaticais[] = linhaComAClasseGramatical.split(",");
		String ultimasClassesGramaticais[] = primeirasClassesGramaticais[primeirasClassesGramaticais.length - 1]
				.split(" e ");
		List<String> juncaoDasClassesGramaticais = new ArrayList<String>();

		for (int x = 0; x < primeirasClassesGramaticais.length - 1; x++) {
			juncaoDasClassesGramaticais.add(primeirasClassesGramaticais[x].trim());
		}

		if (ultimasClassesGramaticais.length > 0) {
			for (String string : ultimasClassesGramaticais) {
				juncaoDasClassesGramaticais.add(string.trim());
			}
		}
		return juncaoDasClassesGramaticais;
	}

	public static String lerLinhaDaDivisaoSilabica() throws IOException {
		List<String> arquivo = Files.readAllLines(Paths.get(C_TESTE_PAGE3_TXT), StandardCharsets.ISO_8859_1);
		String linhaComADivisaoSilabica = "";

		for (String linha : arquivo) {
			if (linha.contains(MARCADOR_DIVISAO_SILABICA)) {
				linhaComADivisaoSilabica = linha;
				return linhaComADivisaoSilabica;
			}
		}
		return linhaComADivisaoSilabica;
	}

	public static String lerLinhaDaGrafiaCorreta() throws IOException {
		List<String> arquivo = Files.readAllLines(Paths.get(C_TESTE_PAGE3_TXT), StandardCharsets.ISO_8859_1);
		String linhaComAGrafiaCorreta = "";

		for (String linha : arquivo) {
			if (linha.contains(MARCADOR_GRAFIA_CORRETA)) {
				linhaComAGrafiaCorreta = linha;
				return linhaComAGrafiaCorreta;
			}
		}
		return linhaComAGrafiaCorreta;
	}

	public static String lerLinhaDaClasseGramatical() throws IOException {
		List<String> arquivo = Files.readAllLines(Paths.get(C_TESTE_PAGE3_TXT), StandardCharsets.ISO_8859_1);
		String linhaComAClasseGramatical = "";
		for (String linha : arquivo) {
			if (linha.contains(MARCADOR_CLASSE_GRAMATICAL)) {
				linhaComAClasseGramatical = linha;
				return linhaComAClasseGramatical;
			}
		}
		return linhaComAClasseGramatical;
	}

	public static String descobrirVerboNaoConjugado(String palavra) throws Exception {
		String linkParaExtracao = DICIO + palavra;
		InputStream codigoFonteDaPagina = getPagina(linkParaExtracao);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		while ((length = codigoFonteDaPagina.read(buffer)) != -1) {
			baos.write(buffer, 0, length);
		}

		FileOutputStream fos = new FileOutputStream(new File(C_TESTE_PAGE4_TXT));
		baos.writeTo(fos);

		List<String> arquivo = Files.readAllLines(Paths.get(C_TESTE_PAGE4_TXT), StandardCharsets.ISO_8859_1);
		String linhaFlexaoDoVerbo = "";
		String linhaDoVerbo = "";
		for (String linha : arquivo) {
			if (!linhaFlexaoDoVerbo.equals("")) {
				linhaDoVerbo = linha;
				break;
			}
			if (linha.contains("Flex„o do verbo")) {
				linhaFlexaoDoVerbo = linha;
			}
		}

		int inicio = linhaDoVerbo.indexOf(">");
		linhaDoVerbo = linhaDoVerbo.substring(inicio + 1);
		int fim = linhaDoVerbo.indexOf("<");
		if (fim < 0)
			return "";
		linhaDoVerbo = linhaDoVerbo.substring(0, fim);
		descobrirClassesGramaticais(linhaDoVerbo);

		return linhaDoVerbo;
	}

	public static String fazerSeparacaoSilabica(String palavra) {
		String linha = "";
		try {
			AcessoASiteUtils.acessarOSiteECriarOArquivo(getPagina(DICIO + palavra));
			
			//se a palavra consultada for a mesma da palavra da p·gina: continuar
			Escansao escansao = new Escansao();
			boolean mesmaPalavra = escansao.palavrasSaoIguais(palavra);
			if (!mesmaPalavra) throw new Exception("implmentar...");
//			linha = descobrirPalavra(palavra);
			
			//daqui pra baixo È pra pegar a divis„o mesmo
			linha = lerLinhaDaDivisaoSilabica();
			linha = linha.replace(MARCADOR_DIVISAO_SILABICA, "");
			linha = linha.replace("/>", "").replace("</b>", "").replace("<br", "").replace("<b>", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return linha;
	}


	/**
	 * 
	 * linha original para filtrar: href="/mais-2/">mais</a>.</span><br
	 * 
	 * @param linhaPoluida
	 * @return
	 * @throws Exception 
	 */
	public static String buscarPalavraSugerida(String linhaPoluida) throws Exception {
		List<String> linhasDoarquivo = Files.readAllLines(Paths.get(C_TESTE_PAGE3_TXT), StandardCharsets.ISO_8859_1);
		String linha = "";
		// se n„o tiver a linha nem vai continuar...
		linha = pegarLinhaNaoConfundirCom(linhasDoarquivo);
		if (linha == "")
			return linha;

		String retorno = "";
		String proximoLink = linkDaPalavraSugerida(linha);
		System.out.println("proximo link: " + proximoLink);

		// antes de ir para o prÛximo link, verificar a grafia em 'Significado
		// de <palavra>'
		// parar quando a grafia for igual (acentos, cedilhas, tios, etc)
//		pegarGrafiaCorretaDaPalavraNaPagina(linhaPoluida, linha, proximoLink);

		//

		// se na linha do marcador 'tit-significado ">Significado de
		// '<palavra></h2><p
		// 1. marcador inicio: <h1 itemprop="name" >
		// 2. marcador fim: </h1>

		return proximoLink;
	}

	//palavra sugerida: a d
	//palavra desejada: a palavra do verso com a acentuaÁ„o, cedilha e hifen
	
//	private static void pegarGrafiaCorretaDaPalavraNaPagina(String linhaPoluida, String linha, String proximoLink) throws Exception {
//		String linhaPoluidaDaGrafiaCorreta = lerLinhaDaGrafiaCorreta();
//		int marcadorInicio = linhaPoluidaDaGrafiaCorreta.indexOf("itemprop=\"name\" >") + TAMAMANHO_MARCADOR_GRAFIA_CORRETA;
//		int marcadorFinal = linhaPoluidaDaGrafiaCorreta.indexOf("</h1>");
//		String grafiaCorretaNaDefinicao = linhaPoluidaDaGrafiaCorreta.substring(marcadorInicio, marcadorFinal);
//		
//	}

	private static String linkDaPalavraSugerida(String linha) {
		int ultimosCaracteres = linha.indexOf("/\">");
		String palavraAlterada = linha.substring(0, ultimosCaracteres);
		String palavraSugerida = palavraAlterada.replace("href=\"/", "/").replaceAll("/", "");
		String proximoLink = DICIO + palavraSugerida;
		return proximoLink;
	}

	private static String pegarLinhaNaoConfundirCom(List<String> linhasDoArquivo) {
		for (int i = 0; i < linhasDoArquivo.size(); i++) {
			if (linhasDoArquivo.get(i).contains(MARCADOR_NAO_CONFUNDIR_COM)) {
				return linhasDoArquivo.get(i + 1);
			}
		}
		return "";
	}

	public String acessarPagina(String linkCompleto) throws SAXException, IOException, Exception {
		return AcessoASiteUtils.acessarAPagina(linkCompleto);
	}

}
