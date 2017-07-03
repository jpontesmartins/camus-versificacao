package versificacao.entidades;

import java.util.List;

import versificacao.separacao_silabica.ClassificacaoVersoEnum;
import versificacao.separacao_silabica.Escansao;

public class Poema {

	private String poema;
	private String poemaVersificado;
	private List<Palavra> palavras;
	
	private int qtdeSilabasPoeticas;
	private int qtdeSilabasGramaticais;
	
	private ClassificacaoVersoEnum classificacaoVerso;
	private String classificacaoVerso2;
	
	private List<Estrofe> estrofes;
	
	public void carregarInformacoes() {
		this.qtdeSilabasGramaticais = new Escansao().contarSilabasGramaticais(this.poema);
		this.qtdeSilabasPoeticas = new Escansao().contarSilabasPoeticas(this.poema);
		this.classificacaoVerso = new Escansao().classificarVerso(this.poema);
		this.classificacaoVerso2 = this.getClassificacaoVerso().getNome();
	}
	
	
	public String getPoema() {
		return poema;
	}

	public void setPoema(String poema) {
		this.poema = poema;
		carregarInformacoes();
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

	public int getQtdeSilabasPoeticas() {
		return qtdeSilabasPoeticas;
	}

	public void setQtdeSilabasPoeticas(int qtdeSilabas) {
		this.qtdeSilabasPoeticas = qtdeSilabas;
	}

	public List<Palavra> getPalavras() {
		return palavras;
	}

	public void setPalavras(List<Palavra> palavras) {
		this.palavras = palavras;
	}

	public int getQtdeSilabasGramaticais() {
		return qtdeSilabasGramaticais;
	}

	public void setQtdeSilabasGramaticais(int qtdeSilabasGramaticais) {
		this.qtdeSilabasGramaticais = qtdeSilabasGramaticais;
	}

	public ClassificacaoVersoEnum getClassificacaoVerso() {
		return classificacaoVerso;
	}

	public void setClassificacaoVerso(ClassificacaoVersoEnum classificacaoVerso) {
		this.classificacaoVerso = classificacaoVerso;
	}

	public String getClassificacaoVerso2() {
		return classificacaoVerso2;
	}

	public void setClassificacaoVerso2(String classificacaoVerso2) {
		this.classificacaoVerso2 = classificacaoVerso2;
	}

}
