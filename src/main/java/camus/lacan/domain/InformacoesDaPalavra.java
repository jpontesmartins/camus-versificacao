package camus.lacan.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camus.lacan.domain.separacao.SepararPalavra;
import camus.lacan.domain.tonicidade.TonicidadeEnum;
import camus.lacan.domain.tonicidade.monossilabos.Tonicidade;

public class InformacoesDaPalavra {
	
	public List<Palavra> preencherInformacoesDasPalavras(String frase) {
		List<Palavra> palavrasComInfomacoes = new ArrayList<>();
		String palavras[] = frase.split(" ");

		for (String palavra : palavras) {
			Palavra palavraInfo = new Palavra();
			palavraInfo.setGrafia(palavra);
			palavraInfo.setSilabas(Arrays.asList(new SepararPalavra().separar(palavra).split(" ")));
			palavraInfo.setSilabaTonica(new Tonicidade().encontrarSilabaTonica(palavra));
			palavraInfo.setTonicidade(TonicidadeEnum.descricao(new Tonicidade().encontrarTonicidadeDaPalavra(palavra)));

			palavrasComInfomacoes.add(palavraInfo);
		}

		return palavrasComInfomacoes;
	}

}
