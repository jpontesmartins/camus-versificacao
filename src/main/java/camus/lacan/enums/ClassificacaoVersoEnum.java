package camus.lacan.enums;

public enum ClassificacaoVersoEnum {

	MONOSSILABO(1, "monossílabo"), DISSILABO(2, "dissílabo"), 
	TRISSILABO(3, "trissílabo"), TETRASSILABO(4,"tetrassílabo"), 
	PENTASSILABO(5, "pentassílabo, redondilha-lno"), 
	HEXASSILABO(6,"hexassílabo"), HEPTASSILABO(7, "hexassílabo, redondilha-menor"), 
	OCTOSSILABO(8,"octossílabo"), ENEASSILABO(9, "eneassílabo"), 
	DECASSILABO(10,"decassílabo"), HENDECASSILABO(11, "hendecassílabo"),
	DODECASSILABO(12,"dodecassílabo, alexandrino"), 
	BARBARO(13,"bárbaro, mais de 12 sílabas poéticas"),
	LIVRE(-1,"livre");

	private int qtdeSilabas;
	private String descricao;

	private ClassificacaoVersoEnum(int qtdeSilabas, String descricao) {
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
