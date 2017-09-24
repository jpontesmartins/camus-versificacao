package camus.lacan.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camus.lacan.controllers.Escansao;

public class Verso {
	
	private static final String NOVA_ESTROFE = "NOVA_ESTROFE";
	
	private String verso;
	private int tamanho;
	private List<Palavra> palavras;
	
	public Verso(String verso) {
		this.verso = verso;
		
		this.palavras = new ArrayList<Palavra>();
		List<String> palavrasStr = new ArrayList<String>(Arrays.asList(this.verso.split(" ")));
		palavrasStr.forEach(p -> this.palavras.add(new Palavra(p)));
		
		this.tamanho = calcularSeparacaoPoetica();
		
		if ("".equals(verso)) this.verso = NOVA_ESTROFE;
	}

	public int calcularSeparacaoPoetica() {
		return new Escansao().contarSilabasPoeticas(this.verso);
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
}
