package camus.lacan.domain.fonema.regras;

import camus.lacan.comum.Fonemas;
import camus.lacan.comum.Letras;

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
