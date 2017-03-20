package versificacao;

public class EscansaoService {
	
	public static final String DICIO = "https://www.dicio.com.br/";

	public String fazerSeparacaoSilabicaDeUmaPalavra(String palavra) {
		String palavraSemAcentuacao = "teste"+removerAcentuacao(palavra);
		return palavraSemAcentuacao;
	}
	
	public String removerAcentuacao(String palavra) {
		String caracteresARemover = "áàãâäéèêëíìîïóòõôöúùûüçÁÀÃÂÄÉÈÊËÍÌÎÏÓÒÕÖÔÚÙÛÜÇ";
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
	
	
	

}
