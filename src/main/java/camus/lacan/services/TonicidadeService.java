package camus.lacan.services;

import org.springframework.stereotype.Service;

import camus.lacan.domain.Palavra;
import camus.lacan.enums.TonicidadeEnum;

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
