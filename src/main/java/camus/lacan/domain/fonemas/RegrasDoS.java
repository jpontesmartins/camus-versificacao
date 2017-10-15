package camus.lacan.domain.fonemas;

import camus.lacan.utils.Fonemas;
import camus.lacan.utils.Letras;

public class RegrasDoS implements Regras {

	@Override
	public String aplicarRegras(String palavra, int posicao, String letraSeguinte) {
		if (posicao == 0 || posicao == palavra.length() - 1)
			return Fonemas.S;
		String letraAnterior = palavra.charAt(posicao - 1) + "";
		if (Letras.isVogal(letraSeguinte) && Letras.isVogal(letraAnterior)) {
			return Fonemas.Z;
		}
		return Fonemas.S;
	}

}
