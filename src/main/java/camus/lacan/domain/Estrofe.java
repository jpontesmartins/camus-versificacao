package camus.lacan.domain;

import java.util.ArrayList;
import java.util.List;

public class Estrofe {

	private String classificacao;
	private List<Verso> versos;
	private List<FiguraDeLinguagem> figuras;
	
	public Estrofe() {
		this.versos = new ArrayList<>();
		this.figuras = new ArrayList<>();
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public List<Verso> getVersos() {
		return versos;
	}

	public void setVersos(List<Verso> versos) {
		this.versos = versos;
	}

	public List<FiguraDeLinguagem> getFiguras() {
		return figuras;
	}

	public void setFiguras(List<FiguraDeLinguagem> figuras) {
		this.figuras = figuras;
	}


}
