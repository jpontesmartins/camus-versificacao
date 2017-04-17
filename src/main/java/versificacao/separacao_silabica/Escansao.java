package versificacao.separacao_silabica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Escansao {

	public static void main(String[] args) {
		Escansao escansao = new Escansao();
		String verso = "silencioso estava aqui";
		escansao.quantidadeSilabasPoeticas(verso);

		String verso1 = "Silencioso e branco como a bruma";
		escansao.quantidadeSilabasPoeticas(verso1);

		String verso2 = "E das bocas unidas fez-se a espuma";
		escansao.quantidadeSilabasPoeticas(verso2);

	}

	public int quantidadeSilabasGramaticais(String verso) {
		SepararPalavra separarPalavra = new SepararPalavra();
		String versoSeparado = separarPalavra.separarFrase(verso);
		String versos[] = versoSeparado.split(" ");
		return versos.length;
	}

	public int quantidadeSilabasPoeticas(String verso) {
		SepararPalavra separarPalavra = new SepararPalavra();
		List<String> silabasPoeticas = new ArrayList<String>();
		List<String> palavras = Arrays.asList(verso.split(" "));
		boolean uniaoDeVogais = false;
		List<String> silabasSemAPrimeira = new ArrayList<>();
		boolean continuar = true;

		for (int i = 0; i < palavras.size(); i++) {
			continuar = true;
			String palavraSeparada = separarPalavra.separar(palavras.get(i));
			if (!uniaoDeVogais) {
				silabasPoeticas.addAll(Arrays.asList(palavraSeparada.split(" ")));
			} else {
				List<String> silabas = Arrays.asList(palavraSeparada.split(" "));
				silabasSemAPrimeira = silabas.subList(1, silabas.size());
				if (silabasSemAPrimeira.size() == 0) {
					continuar = false;
				}
				silabasPoeticas.addAll(silabasSemAPrimeira);
				uniaoDeVogais = false;
			}

			if (continuar) {
				String palavraSeguinte = "";
				if (i < palavras.size() - 1) {
					palavraSeguinte = palavras.get(i + 1);
				}
				if (i != palavras.size() - 1) {
					uniaoDeVogais = juntarVogais(separarPalavra, silabasPoeticas, palavraSeguinte);
				}
			}
		}

		Tonicidade tonica = new Tonicidade();
		int tonicidade = tonica.encontrarTonicidadeDaPalavra(palavras.get(palavras.size() - 1));

		return silabasPoeticas.size() - (tonicidade - 1);
	}

	private boolean juntarVogais(SepararPalavra separarPalavra, List<String> silabasPoeticas, String palavraSeguinte) {
		String palavraSeguinteSeparada = separarPalavra.separar(palavraSeguinte);
		String primeiraSilaba = palavraSeguinteSeparada.split(" ")[0];
		char primeiraLetra = primeiraSilaba.charAt(0);
		String ultimaSilabaDaLista = silabasPoeticas.get(silabasPoeticas.size() - 1);
		char ultimaLetra = ultimaSilabaDaLista.charAt(ultimaSilabaDaLista.length() - 1);
		
		if (separarPalavra.isVogal(primeiraLetra) && separarPalavra.isVogal(ultimaLetra)) {
			String ultima = silabasPoeticas.get(silabasPoeticas.size() - 1);
			String seguinte = primeiraSilaba;
			String silabaSubstituta = ultima + seguinte;
			silabasPoeticas.set(silabasPoeticas.size() - 1, silabaSubstituta);
			return true;
		}
		
		return false;
	}

}
