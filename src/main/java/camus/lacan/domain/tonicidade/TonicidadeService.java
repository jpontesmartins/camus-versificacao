package camus.lacan.domain.tonicidade;

import camus.lacan.domain.Palavra;
import camus.lacan.domain.tonicidade.monossilabos.AnaliseTonicidade;

public class TonicidadeService implements ITonicidadeService {
	

	public Palavra encontrarSilabaTonica(String palavra) {
		Palavra vocabulo = new Palavra();
		AnaliseTonicidade tonicidade = new AnaliseTonicidade();
		vocabulo.setGrafia(palavra);
		vocabulo.setSilabaTonica(tonicidade.encontrarSilabaTonica(palavra));
		vocabulo.setTonicidade(TonicidadeEnum.descricao(tonicidade.encontrarTonicidadeDaPalavra(palavra)));
		return vocabulo;
	}

}
