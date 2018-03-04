package camus.lacan.domain.separacao;

import java.util.Arrays;

import camus.lacan.domain.Palavra;

public class SeparacaoService implements ISeparacaoService {

	public Palavra separarPalavra(String palavra) {
		Palavra vocabulo = new Palavra();
		vocabulo.setGrafia(palavra);
		vocabulo.setSilabas(Arrays.asList(new SepararPalavra().separar(palavra).split(" ")));
		return vocabulo;
	}
}
