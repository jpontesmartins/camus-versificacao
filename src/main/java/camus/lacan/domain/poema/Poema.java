package camus.lacan.domain.poema;

import java.util.List;

import camus.lacan.domain.FiguraDeLinguagem;

public class Poema {

	private String poema;
	private List<Verso> versos;
	private List<Estrofe> estrofes;
	private List<FiguraDeLinguagem> figuras;
	
	public void substituirMarcadorDeVerso() {
		this.poema = this.poema.replaceAll("§", "\n");
	}
	
	
	public String getPoema() {
		return poema;
	}

	public void setPoema(String poema) {
		this.poema = poema;
		substituirMarcadorDeVerso();
	}

	public List<Verso> getVersos() {
		return versos;
	}


	public void setVersos(List<Verso> versos) {
		this.versos = versos;
	}


	public List<Estrofe> getEstrofes() {
		return estrofes;
	}


	public void setEstrofes(List<Estrofe> estrofes) {
		this.estrofes = estrofes;
	}


	public List<FiguraDeLinguagem> getFiguras() {
		return figuras;
	}


	public void setFiguras(List<FiguraDeLinguagem> figuras) {
		this.figuras = figuras;
	}

}
