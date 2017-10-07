package camus.lacan.enums;

public enum ClassificacaoEstrofeEnum {

	MONOSTICO(1, "monóstico"), DISTICO(2, "distico"), 
	TERCETO(3, "terceto"), QUARTETO(4,"quarteto"), 
	QUINTETO(5, "quinteto"),SEXTETO(6,"sexteto"), 
	HEPTETO(7, "hepteto"), OITAVA(8,"oitava"), 
	NONA(9, "nona"), DECASSILABO(10,"décima"), LIVRE(-1,"livre");

	private int qtdeVersos;
	private String descricao;

	private ClassificacaoEstrofeEnum(int qtdeVersos, String descricao) {
		this.qtdeVersos = qtdeVersos;
		this.descricao = descricao;
	}
	
	public ClassificacaoEstrofeEnum getClassificacao(int qtdeVerso) {
		
		return null;
	}
	
	

	public String getDescricao() {
		return descricao;
	}

	public int getQtdeVersos() {
		return qtdeVersos;
	}

}
