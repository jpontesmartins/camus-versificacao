package camus.lacan.domain.anafora.analise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import camus.lacan.domain.anafora.Anafora;

public class AnaliseAnafora {

	private List<String> versos;
	private List<Anafora> anaforas;

	private FrequenciaDeRepeticoes frequenciaDeRepeticoes;

	public List<Anafora> encontrarAnaforas(List<String> versos) {
		this.versos = versos;
		frequenciaDeRepeticoes = new FrequenciaDeRepeticoes(this.versos);
		this.anaforas = listarAnaforas();
		return anaforas;
	}

	private List<Anafora> listarAnaforas() {
		List<Anafora> anaforas = new ArrayList<>();
		Iterator iteracaoNasAnaforas = frequenciaDeRepeticoes.contarFrequenciaDeExpressoesRepetidas().entrySet().iterator();
		while (iteracaoNasAnaforas.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iteracaoNasAnaforas.next();

			String expressao = mapEntry.getKey().toString();
			Integer frequencia = Integer.parseInt(mapEntry.getValue().toString());

			Anafora anafora = new Anafora();
			List<String> versos = pegarVersosComAsExpressoesRepetidas(expressao);
			anafora.setExpressao(expressao);
			anafora.setFrequecia(frequencia);
			anafora.setVersos(versos);

			anaforas.add(anafora);
			iteracaoNasAnaforas.remove();
		}
		anaforas.removeIf(anafora -> anafora.getFrequecia() == 1);
		return anaforas;
	}

	private List<String> pegarVersosComAsExpressoesRepetidas(String expressao) {
		List<String> versosComAExpressao = new ArrayList<>();
		for (ExpressaoRepetida expressaoRepetida : frequenciaDeRepeticoes.getExpressoesRepetidas()) {
			if (expressao.equals(expressaoRepetida.getExpressao())) {
				versosComAExpressao.add(expressaoRepetida.getVerso());
			}
		}
		return versosComAExpressao;
	}

}