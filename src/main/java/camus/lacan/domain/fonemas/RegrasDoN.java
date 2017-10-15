package camus.lacan.domain.fonemas;

import camus.lacan.utils.Fonemas;
import camus.lacan.utils.Letras;

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
