package camus.lacan.domain;

import java.util.List;

public class Palavra {

	private String grafia;
	private List<String> silabas;
	private String silabaTonica;
	private String tonicidade;

	public Palavra(String palavraStr) {
		this.grafia = palavraStr;
	}

	public Palavra() {
	}
	
	public String getGrafia() {
		return grafia;
	}

	public void setGrafia(String grafia) {
		this.grafia = grafia;
	}

	public List<String> getSilabas() {
		return silabas;
	}

	public void setSilabas(List<String> silabas) {
		this.silabas = silabas;
	}

	public String getSilabaTonica() {
		return silabaTonica;
	}

	public void setSilabaTonica(String silabaTonica) {
		this.silabaTonica = silabaTonica;
	}

	public String getTonicidade() {
		return tonicidade;
	}

	public void setTonicidade(String tonicidade) {
		this.tonicidade = tonicidade;
	}

}
