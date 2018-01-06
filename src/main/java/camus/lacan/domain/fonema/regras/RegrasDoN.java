package camus.lacan.domain.fonema.regras;

import camus.lacan.comum.Fonemas;
import camus.lacan.comum.Letras;

public class RegrasDoN implements Regras {

	@Override
	public String aplicarRegras(String palavra, int posicao, String letraSeguinte) {
		if (posicao > 0) {
			String letraAnterior = palavra.charAt(posicao - 1) + "";
			if (Letras.isVogal(letraAnterior)
					&& (Letras.isConsoante(letraSeguinte) || posicao == palavra.length() - 1)) {
				if (Letras.A.equals(letraAnterior)) {
					return Fonemas.AN;
				} else if (Letras.isLetraE(letraAnterior)) {
					return Fonemas.EN;
				} else if (Letras.I.equals(letraAnterior)) {
					return Fonemas.IN;
				} else if (Letras.O.equals(letraAnterior)) {
					return Fonemas.ON;
				} else if (Letras.U.equals(letraAnterior)) {
					return Fonemas.UN;
				}
			}
			return Fonemas.N;
		}
		return Fonemas.N;
	}

}
