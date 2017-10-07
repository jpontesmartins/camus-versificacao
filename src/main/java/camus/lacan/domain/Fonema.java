package camus.lacan.domain;

public class Fonema {
	
	private String grafia;
	private String fonema;
	private int frequencia;
	
	public Fonema(String grafia, String fonema) {
		this.grafia = grafia;
		this.fonema = fonema;
	}
	public Fonema(String grafia, String fonema, int frequencia) {
		this.grafia = grafia;
		this.fonema = fonema;
		this.frequencia = frequencia;
	}
	
	public String getGrafia() {
		return grafia;
	}
	public void setGrafia(String grafia) {
		this.grafia = grafia;
	}
	public String getFonema() {
		return fonema;
	}
	public void setFonema(String fonema) {
		this.fonema = fonema;
	}
	public int getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}
	

}
