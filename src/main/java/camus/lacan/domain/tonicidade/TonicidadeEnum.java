package camus.lacan.domain.tonicidade;

public enum TonicidadeEnum {

	OXITONA("oxítona", 1), PAROXITONA("paroxítona", 2), PROPAROXITONA("proparoxítona",
			3), MONOSSILABO_TONICO("monossílabo tônico", 0), MONOSSILABO_ATONO("monossílabo átono", -1);

	private String tipo;
	private int posicao;

	public static String descricao(int posicao) {
		switch (posicao) {
		case -1:
			return MONOSSILABO_ATONO.tipo;
		case 0:
			return MONOSSILABO_TONICO.tipo;
		case 1:
			return OXITONA.tipo;
		case 2:
			return PAROXITONA.tipo;
		case 3:
			return PROPAROXITONA.tipo;

		}
		return "";
	}

	private TonicidadeEnum(String tipo, int posicao) {
		this.tipo = tipo;
		this.posicao = posicao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPosicao() {
		return posicao;
	}

}
