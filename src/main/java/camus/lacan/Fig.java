package camus.lacan;

public abstract class Fig {
	
	private String trecho;
	private int tipoFiguraEnum;
	
	public abstract String getInfo();

	public String getTrecho() {
		return trecho;
	}

	public void setTrecho(String trecho) {
		this.trecho = trecho;
	}

	public int getTipoFiguraEnum() {
		return tipoFiguraEnum;
	}

	public void setTipoFiguraEnum(int tipoFiguraEnum) {
		this.tipoFiguraEnum = tipoFiguraEnum;
	}

}
