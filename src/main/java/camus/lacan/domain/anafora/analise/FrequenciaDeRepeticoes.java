package camus.lacan.domain.anafora.analise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequenciaDeRepeticoes {
	
	private List<String> versos;
	private ComparacaoDeVersos comparacaoDeVersos;
	private List<ExpressaoRepetida> expressoesRepetidas;
	
	public FrequenciaDeRepeticoes(List<String> versos) {
		this.versos = versos;
		this.comparacaoDeVersos = new ComparacaoDeVersos(this.versos);
		this.expressoesRepetidas = new ArrayList<>();
		listarExpressoesRepetidas();
	}
	
	public Map<String, Integer> contarFrequenciaDeExpressoesRepetidas() {
		Map<String, Integer> frequenciaDasExpressoes = new HashMap<>();
		getExpressoesRepetidas().forEach(expressao -> {
			Integer frequencia = frequenciaDasExpressoes.get(expressao.getExpressao());
			if (frequencia == null) {
				frequenciaDasExpressoes.put(expressao.getExpressao(), 1);
			} else {
				frequenciaDasExpressoes.put(expressao.getExpressao(), frequencia + 1);
			}
		});
		return frequenciaDasExpressoes;
	}
	
	public void listarExpressoesRepetidas() {
		for (int posicaoVersoAtual = 0; posicaoVersoAtual < this.versos.size(); posicaoVersoAtual++) {
			String versoAtual = this.versos.get(posicaoVersoAtual);
			String versoAnterior = comparacaoDeVersos.pegarVersoAnterior(posicaoVersoAtual);
			String versoPosterior = comparacaoDeVersos.pegarVersoPosterior(posicaoVersoAtual);

			ExpressaoRepetida expressaoRepetidaAnterior = comparacaoDeVersos.compararComOutroVerso(versoAtual,
					versoAnterior);
			if (expressaoRepetidaAnterior == null) {
				ExpressaoRepetida expressaoRepetidaPosterior = comparacaoDeVersos.compararComOutroVerso(versoAtual,
						versoPosterior);
				if (expressaoRepetidaPosterior != null) {
					getExpressoesRepetidas().add(expressaoRepetidaPosterior);
				}
			} else {
				getExpressoesRepetidas().add(expressaoRepetidaAnterior);
			}
		}

	}

	public List<ExpressaoRepetida> getExpressoesRepetidas() {
		return expressoesRepetidas;
	}

	public Map<String, Integer> getFrequenciaDasExpressoes() {
		return contarFrequenciaDeExpressoesRepetidas();
	}

}
