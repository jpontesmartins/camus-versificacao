package camus.lacan.domain;

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
