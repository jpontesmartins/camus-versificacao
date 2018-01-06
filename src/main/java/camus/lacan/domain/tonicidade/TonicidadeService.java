package camus.lacan.domain.tonicidade;

import org.springframework.stereotype.Service;

import camus.lacan.domain.Palavra;

@Service
public class TonicidadeService {

	public Palavra encontrarSilabaTonica(String palavra) {
		Palavra vocabulo = new Palavra();
		Tonicidade tonicidade = new Tonicidade();
		vocabulo.setGrafia(palavra);
		vocabulo.setSilabaTonica(tonicidade.encontrarSilabaTonica(palavra));
		vocabulo.setTonicidade(TonicidadeEnum.descricao(tonicidade.encontrarTonicidadeDaPalavra(palavra)));
		return vocabulo;
	}

}
