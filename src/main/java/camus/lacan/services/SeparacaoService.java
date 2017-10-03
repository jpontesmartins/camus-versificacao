package camus.lacan.services;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import camus.lacan.domain.Palavra;

@Service
public class SeparacaoService {

	public Palavra separarPalavra(String palavra) {
		Palavra vocabulo = new Palavra();
		vocabulo.setGrafia(palavra);
		vocabulo.setSilabas(Arrays.asList(new SepararPalavra().separar(palavra).split(" ")));
		return vocabulo;
	}
}
