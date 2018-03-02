package camus.lacan.domain.anafora.analise;

public class ExpressaoRepetida {

	private String expressao;
	private String verso;

	public ExpressaoRepetida(String expressao, String verso) {
		this.setExpressao(expressao.trim());
		this.setVerso(verso);
	}

	public String getExpressao() {
		return expressao;
	}

	public void setExpressao(String expressao) {
		this.expressao = expressao.trim();
	}

	public String getVerso() {
		return verso;
	}

	public void setVerso(String verso) {
		this.verso = verso;
	}

}
