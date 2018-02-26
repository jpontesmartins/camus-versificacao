package camus.lacan.domain.anafora;

import java.util.ArrayList;
import java.util.List;

import camus.lacan.domain.FiguraDeLinguagem;
import camus.lacan.enums.FiguraDeLinguagemEnum;

public class Anafora extends FiguraDeLinguagem {

	private String expressao;
	private List<String> versos;
	private Integer frequecia;
	
	public Anafora() {
		super.setFigura(FiguraDeLinguagemEnum.ANAFORA);
		this.versos = new ArrayList<>();
	}
	public Anafora(String expressao, Integer frequencia, List<String> versos) {
		this.expressao = expressao;
		this.frequecia = frequencia;
		this.versos = new ArrayList<>();
		super.setFigura(FiguraDeLinguagemEnum.ANAFORA);
	}

	public List<String> getVersos() {
		return versos;
	}

	public void setVersos(List<String> versos) {
		this.versos = versos;
	}

	public Integer getFrequecia() {
		return frequecia;
	}

	public void setFrequecia(Integer frequecia) {
		this.frequecia = frequecia;
	}

	public String getExpressao() {
		return expressao;
	}

	public void setExpressao(String expressao) {
		this.expressao = expressao;
	}

}
