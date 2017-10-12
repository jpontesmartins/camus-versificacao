package camus.lacan;

public class Anaf extends Fig {
	
	private String trechoRepetitivo;
	
	public Anaf(String trecho, String trechoRepetitivo) {
		super.setTrecho(trecho);
		this.trechoRepetitivo = trechoRepetitivo;
	}

	public String getTrechoRepetitivo() {
		return trechoRepetitivo;
	}

	public void setTrechoRepetitivo(String trechoRepetitivo) {
		this.trechoRepetitivo = trechoRepetitivo;
	}

	@Override
	public String getInfo() {
		return getTrechoRepetitivo();
	}

}
