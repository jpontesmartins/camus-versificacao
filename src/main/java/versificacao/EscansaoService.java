package versificacao;

public class EscansaoService {
	
	public static final String DICIO = "https://www.dicio.com.br/";

	public String fazerSeparacaoSilabicaDeUmaPalavra(String palavra) {
		String palavraSemAcentuacao = "teste"+removerAcentuacao(palavra);
		return palavraSemAcentuacao;
	}

	public String removerAcentuacao(String palavra) {
		System.out.println("implementar");
		//TODO: removidas as linhas que substituiam as letras com acentos e cedilhas.
		return palavra;
	}
}
