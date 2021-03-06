package camus.lacan.domain.poema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camus.lacan.domain.FiguraDeLinguagem;
import camus.lacan.domain.Palavra;
import camus.lacan.domain.escansao.Escansao;
import camus.lacan.enums.ClassificacaoVersoEnum;

public class Verso {
	
	private static final String NOVA_ESTROFE = "NOVA_ESTROFE";
	
	private String verso;
	private int tamanho;
	private String classificacao;
	private List<Palavra> palavras;
	private List<FiguraDeLinguagem> figuras;
	
	public Verso(String verso) {
		this.verso = verso;
		removerEspacosDesnessarios();
		
		this.palavras = new ArrayList<Palavra>();
		List<String> palavras = new ArrayList<String>(Arrays.asList(this.verso.split(" ")));
		palavras.forEach(p -> this.palavras.add(new Palavra(p)));
		
		ClassificacaoVersoEnum classificacao = new Escansao().classificarVerso(this.verso);
		this.tamanho = classificacao.getQtdeSilabas();
		this.classificacao = classificacao.getDescricao();
		
		if ("".equals(verso)) this.verso = NOVA_ESTROFE;
		
		this.figuras = new ArrayList<>();
	}

	private void removerEspacosDesnessarios() {
		if (this.verso.charAt(0) == ' ') {
			this.verso = this.verso.substring(1);
		}
	}

	public String getVerso() {
		return verso;
	}

	public void setVerso(String verso) {
		this.verso = verso;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public List<Palavra> getPalavras() {
		return palavras;
	}

	public void setPalavras(List<Palavra> palavras) {
		this.palavras = palavras;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public List<FiguraDeLinguagem> getFiguras() {
		return figuras;
	}

	public void setFiguras(List<FiguraDeLinguagem> figuras) {
		this.figuras = figuras;
	}
}
