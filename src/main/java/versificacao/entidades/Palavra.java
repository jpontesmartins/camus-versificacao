package versificacao.entidades;

import versificacao.separacao_silabica.Fonema;
import versificacao.separacao_silabica.SepararPalavra;
import versificacao.separacao_silabica.Tonicidade;
import versificacao.separacao_silabica.TonicidadeEnum;

public class Palavra {

	private String palavra;
	private String silabaTonica;
	private String separacaoSilabica;
	private TonicidadeEnum tonicidade;
	private String tonicidade2;
	private String formaFonetica;

	public Palavra(String palavra) {
		this.palavra = palavra;
		carregarInformacoes(palavra);
	}

	private void carregarInformacoes(String palavra) {
		this.separacaoSilabica = new SepararPalavra().separar(palavra).replaceAll(" ",".");
		this.silabaTonica = new Tonicidade().encontrarSilabaTonica(palavra);
		int posicaoDaSilabaTonica = new Tonicidade().encontrarTonicidadeDaPalavra(palavra);
		this.formaFonetica = new Fonema().transcreverPalavra(palavra);

		switch (posicaoDaSilabaTonica) {
		case 0:
			this.tonicidade = TonicidadeEnum.MONOSSILABO;
			break;
		case 1:
			this.tonicidade = TonicidadeEnum.OXITONA;
			break;
		case 2:
			this.tonicidade = TonicidadeEnum.PAROXITONA;
			break;
		case 3:
			this.tonicidade = TonicidadeEnum.PROPAROXITONA;
			break;
		
		default:
			break;
		}
		this.setTonicidade2(this.tonicidade.getTipo());
	}

	public String getSilabaTonica() {
		return this.silabaTonica;
	}

	public void setSilabaTonica(String silabaTonica) {
		this.silabaTonica = silabaTonica;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public String getTonicidade() {
		return this.tonicidade.getTipo();
	}
	
	public String getSeparacaoSilabica() {
		return separacaoSilabica;
	}

	public void setSeparacaoSilabica(String separacaoSilabica) {
		this.separacaoSilabica = separacaoSilabica;
	}

	public String getTonicidade2() {
		return tonicidade2;
	}

	public void setTonicidade2(String tonicidade2) {
		this.tonicidade2 = tonicidade2;
	}

	public String getFormaFonetica() {
		return formaFonetica;
	}

}
