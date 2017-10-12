package camus.lacan;

public class Alit extends Fig {

	private int frequencia;

	public Alit(String trecho, int frequencia) {
		super.setTrecho(trecho);
		this.frequencia = frequencia;
	}

	public int getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

	@Override
	public String getInfo() {
		return "" + getFrequencia();
	}
}
