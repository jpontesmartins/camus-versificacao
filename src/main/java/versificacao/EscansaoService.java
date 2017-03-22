package versificacao;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EscansaoService {
	
	public static final String DICIO = "https://www.dicio.com.br/";
	public static final String C_TESTE_PAGE3_TXT = "C:\\teste\\page3.txt";
	private static final String MARCADOR_DIVISAO_SILABICA = " Separação das sílabas: ";

	public String fazerSeparacaoSilabicaDeUmaPalavra(String palavra) {
		Escansao escansao = new Escansao();
		String palavraSemAcentuacao = escansao.fazerSeparacaoSilabica(palavra);
		return palavraSemAcentuacao;
	}
	
	public String fazerSeparacaoSilabicaDoVerso(String frase) throws FileNotFoundException, IOException, Exception {
		Escansao escansao = new Escansao();
		String palavrasDaFrase[] = frase.trim().toLowerCase().split(" ");
		String fraseSeparadaPorSilabas = "";

		for (String palavra : palavrasDaFrase) {
			palavra = escansao.fazerSeparacaoSilabica(palavra);
			fraseSeparadaPorSilabas += " " + palavra;
		}
		fraseSeparadaPorSilabas = fraseSeparadaPorSilabas.replaceFirst(" ", "");

		return fraseSeparadaPorSilabas;
	}
}
