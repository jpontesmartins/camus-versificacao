package camus.lacan.domain;

import java.util.ArrayList;
import java.util.List;

import camus.lacan.utils.Fonemas;

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
