package versificacao;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.xml.sax.SAXException;

public class Escansao {
	
	private static final int TAMAMANHO_MARCADOR_GRAFIA_CORRETA = 17;
	public static final String C_TESTE_PAGE3_TXT = "C:\\teste\\page3.txt";
	private static final String MARCADOR_DIVISAO_SILABICA = " Separação das sílabas: ";

	private static final String MARCADOR_GRAFIA_CORRETA = "tit-significado";

	public static final String DICIO = "https://www.dicio.com.br/";

	public String fazerSeparacaoSilabica(String palavra) {
		String linha = "";
		try {
			AcessoASiteUtils.acessarOSiteECriarOArquivo(Escansao.getPagina(DICIO + palavra));
			Escansao escansao = new Escansao();
			boolean mesmaPalavra = escansao.palavrasSaoIguais(palavra);
			if (!mesmaPalavra) throw new Exception("implmentar...");
			linha = lerLinhaDaDivisaoSilabica();
			linha = linha.replace(MARCADOR_DIVISAO_SILABICA, "");
			linha = linha.replace("/>", "").replace("</b>", "").replace("<br", "").replace("<b>", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return linha;
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

	public String acessarPagina(String linkCompleto) throws SAXException, IOException, Exception {
		return AcessoASiteUtils.acessarAPagina(linkCompleto);
	}

}
