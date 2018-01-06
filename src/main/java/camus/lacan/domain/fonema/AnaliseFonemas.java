package camus.lacan.domain.fonema;

import java.util.ArrayList;
import java.util.List;

import camus.lacan.comum.Fonemas;

public class AnaliseFonemas {
	
	public List<Fonema> pegarApenasFonemasConsonantais(List<Fonema> fonemas) {
		List<Fonema> fonemasConsonantais = new ArrayList<>();
		fonemas.forEach(fonema -> {
			if (Fonemas.isFonemaConsonantal(fonema.getFonema())) {
				fonemasConsonantais.add(fonema);
			}
		});
		return fonemasConsonantais;
	}

}
