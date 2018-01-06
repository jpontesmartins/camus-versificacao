package camus.lacan.domain.aliteracao;

import camus.lacan.domain.FiguraDeLinguagem;
import camus.lacan.domain.fonema.Fonema;
import camus.lacan.enums.FiguraDeLinguagemEnum;

public class Aliteracao extends FiguraDeLinguagem {

	private Fonema fonemaMaisFrequente;
	
	public Aliteracao() {
		super.setFigura(FiguraDeLinguagemEnum.ALITERACAO);
	}

	public Fonema getFonemaMaisFrequente() {
		return fonemaMaisFrequente;
	}

	public void setFonemaMaisFrequente(Fonema fonemaMaisFrequente) {
		this.fonemaMaisFrequente = fonemaMaisFrequente;
	}
	
}
