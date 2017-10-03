package camus.lacan.domain;

import java.util.List;

public class Poema {

	private String poema;
	private List<Verso> versos;
	
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

}
