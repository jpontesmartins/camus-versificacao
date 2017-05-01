package versificacao.separacao_silabica;

public enum TonicidadeEnum {

	OXITONA("oxítona", 1), PAROXITONA("paroxítona", 2), 
	PROPAROXITONA("proparoxítona", 3), MONOSSILABO("monossílabo", 0);

	private String tipo;
	private int posicao;

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
