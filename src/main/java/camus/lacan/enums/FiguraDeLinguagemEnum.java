package camus.lacan.enums;

public enum FiguraDeLinguagemEnum {
	ALITERACAO("aliteração"), ANAFORA("anáfora");

	private String descricao;

	private FiguraDeLinguagemEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
