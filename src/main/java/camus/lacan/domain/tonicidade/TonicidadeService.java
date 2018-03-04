package camus.lacan.domain.tonicidade;

import camus.lacan.domain.Palavra;

public class TonicidadeService implements ITonicidadeService {
	

	public Palavra encontrarSilabaTonica(String palavra) {
		Palavra vocabulo = new Palavra();
		Tonicidade tonicidade = new Tonicidade();
		vocabulo.setGrafia(palavra);
		vocabulo.setSilabaTonica(tonicidade.encontrarSilabaTonica(palavra));
		vocabulo.setTonicidade(TonicidadeEnum.descricao(tonicidade.encontrarTonicidadeDaPalavra(palavra)));
		return vocabulo;
	}

}
