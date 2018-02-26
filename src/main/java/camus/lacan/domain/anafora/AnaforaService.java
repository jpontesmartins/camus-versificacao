package camus.lacan.domain.anafora;

import java.util.ArrayList;
import java.util.List;

import camus.lacan.domain.anafora.analise.AnaliseAnafora;
import camus.lacan.domain.poema.Estrofe;

public class AnaforaService implements IAnaforaService {

	AnaliseAnafora analiseAnafora;

	public AnaforaService() {
		this.analiseAnafora = new AnaliseAnafora();
	}

	public Estrofe analisarEstrofe(Estrofe estrofe) {
		List<String> versos = new ArrayList<>();
		estrofe.getVersos().forEach(versoSimples -> {
			versos.add(versoSimples.getVerso());
		});
		
		List<Anafora> anaforas = analiseAnafora.encontrarAnaforas(versos);
		
		System.out.println("Estrofe:");
		estrofe.getVersos().forEach(v -> System.out.println(v.getVerso()));
		anaforas.forEach(anafora -> {
			estrofe.getFiguras().add(anafora);
		});
		return estrofe;
	}

}
