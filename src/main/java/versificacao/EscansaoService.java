package versificacao;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EscansaoService {
	
	public static final String DICIO = "https://www.dicio.com.br/";
	public static final String C_TESTE_PAGE3_TXT = "C:\\teste\\page3.txt";
	private static final String MARCADOR_DIVISAO_SILABICA = " Separação das sílabas: ";

	public String fazerSeparacaoSilabicaDeUmaPalavra(String palavra) {
//		String palavraSemAcentuacao = "teste"+removerAcentuacao(palavra);
		String palavraSemAcentuacao = fazerSeparacaoSilabica(palavra);
		return palavraSemAcentuacao;
	}
	public String removerAcentuacao(String palavra) {
		System.out.println("implementar");
		//TODO: removidas as linhas que substituiam as letras com acentos e cedilhas.
		return palavra;
	}
	
	public static String fazerSeparacaoSilabica(String palavra) {
		String linha = "";
		try {
			AcessoASiteUtils.acessarOSiteECriarOArquivo(Escansao.getPagina(DICIO + palavra));
			
			//se a palavra consultada for a mesma da palavra da página: continuar
			Escansao escansao = new Escansao();
			boolean mesmaPalavra = escansao.palavrasSaoIguais(palavra);
			if (!mesmaPalavra) throw new Exception("implmentar...");
//			linha = descobrirPalavra(palavra);
			
			//daqui pra baixo é pra pegar a divisão mesmo
			linha = lerLinhaDaDivisaoSilabica();
			linha = linha.replace(MARCADOR_DIVISAO_SILABICA, "");
			linha = linha.replace("/>", "").replace("</b>", "").replace("<br", "").replace("<b>", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return linha;
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
}
