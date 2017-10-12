package camus.lacan;

public class Antit extends Fig {
	
	private String antonimo;
	
	public Antit(String trecho, String antonimo) {
		super.setTrecho(trecho);
		this.antonimo = antonimo;
	}
	

	public String getAntonimo() {
		return antonimo;
	}

	public void setAntonimo(String antonimo) {
		this.antonimo = antonimo;
	}


	@Override
	public String getInfo() {
		return getAntonimo();
	}

}
