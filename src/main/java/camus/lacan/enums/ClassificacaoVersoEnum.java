package camus.lacan.enums;

public enum ClassificacaoVersoEnum {

	MONOSSILABO(1, "monossílabo"), DISSILABO(2, "dissílabo"), 
	TRISSILABO(3, "trissílabo"), TETRASSILABO(4,"tetrassílabo"), 
	PENTASSILABO(5, "pentassílabo, redondilha-lno"), 
	HEXASSILABO(6,"hexassílabo"), HEPTASSILABO(7, "hexassílabo, redondilha-menor"), 
	OCTOSSILABO(8,"octossílabo"), ENEASSILABO(9, "eneassílabo"), 
	DECASSILABO(10,"decassílabo"), HENDECASSILABO(11, "hendecassílabo"),
	DODECASSILABO(12,"dodecassílabo, alexandrino"), 
	BARBARO(13,"bárbaro, mais de 12 sílabas poéticas");

	private int qtdeSilabas;
	private String nome;

	private ClassificacaoVersoEnum(int qtdeSilabas, String nome) {
		this.qtdeSilabas = qtdeSilabas;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public int getQtdeSilabas() {
		return qtdeSilabas;
	}

}
