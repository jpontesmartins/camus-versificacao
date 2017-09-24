package camus.lacan.domain;

import java.util.List;

import camus.lacan.controllers.Escansao;
import camus.lacan.enums.ClassificacaoVersoEnum;
import camus.lacan.services.EscansaoService;

public class Poema {

	private String poema;
	private ClassificacaoVersoEnum classificacaoPorVerso; 
	private String classificacaoVerso2;
	private List<Verso> versos;
	
	public void carregarInformacoes() {
		this.poema = this.poema.replaceAll("§", "\n");
//		this.classificacaoPorVerso = new Escansao().classificarVerso(this.poema);
//		this.classificacaoVerso2 = this.getClassificacaoVerso().getNome();
	}
	
	
	public String getPoema() {
		return poema;
	}

	public void setPoema(String poema) {
		this.poema = poema;
		carregarInformacoes();
	}

	public ClassificacaoVersoEnum getClassificacaoVerso() {
		return classificacaoPorVerso;
	}

	public void setClassificacaoVerso(ClassificacaoVersoEnum classificacaoVerso) {
		this.classificacaoPorVerso = classificacaoVerso;
	}

	public String getClassificacaoVerso2() {
		return classificacaoVerso2;
	}

	public void setClassificacaoVerso2(String classificacaoVerso2) {
		this.classificacaoVerso2 = classificacaoVerso2;
	}


	public List<Verso> getVersos() {
		return versos;
	}


	public void setVersos(List<Verso> versos) {
		this.versos = versos;
	}

}
