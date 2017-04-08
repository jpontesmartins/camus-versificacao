package versificacao.entidades;

import java.util.List;

public class Poema {

	private String poema;
	private String poemaVersificado;
	
	private List<Estrofe> estrofes;
	
	public Poema() {
		
	}

	public Poema(String string, String string2) {
		this.poema = string;
		this.poemaVersificado = string2;
	}

	public String getPoema() {
		return poema;
	}

	public void setPoema(String poema) {
		this.poema = poema;
	}

	public String getPoemaVersificado() {
		return poemaVersificado;
	}

	public void setPoemaVersificado(String poemaVersificado) {
		this.poemaVersificado = poemaVersificado;
	}

	public List<Estrofe> getEstrofes() {
		return estrofes;
	}

	public void setEstrofes(List<Estrofe> estrofes) {
		this.estrofes = estrofes;
	}

}
