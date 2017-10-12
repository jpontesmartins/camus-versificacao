package camus.lacan.domain;

import camus.lacan.enums.FiguraDeLinguagemEnum;

public class FiguraDeLinguagem {

	private String trecho;
	private FiguraDeLinguagemEnum figura;

	public String getTrecho() {
		return trecho;
	}

	public void setTrecho(String trecho) {
		this.trecho = trecho;
	}

	public FiguraDeLinguagemEnum getFigura() {
		return figura;
	}

	public void setFigura(FiguraDeLinguagemEnum figura) {
		this.figura = figura;
	}

}
