package camus.lacan.enums;

public enum FiguraDeLinguagemEnum {
	ALITERACAO(1, "aliteração"), ANAFORA(2, "anáfora");

	private int qtdeSilabas;
	private String descricao;

	private FiguraDeLinguagemEnum(int qtdeSilabas, String descricao) {
		this.qtdeSilabas = qtdeSilabas;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getQtdeSilabas() {
		return qtdeSilabas;
	}
}
