package camus.lacan.domain.fonemas;

import camus.lacan.domain.ConversaoEmFonema;
import camus.lacan.utils.Fonemas;
import camus.lacan.utils.Letras;

public class RegrasDoU  implements Regras {

	@Override
	public String aplicarRegras(String palavra, int posicao, String letra) {
		if (posicao > 0) {
			String letraAnterior = palavra.charAt(posicao - 1) + "";
			if (ConversaoEmFonema.isDigrafo(letraAnterior, letra) && posicao < palavra.length()) {
				String letraSeguinte = palavra.charAt(posicao + 1) + "";
				if (Letras.A.equals(letraSeguinte) || Letras.O.equals(letraSeguinte)) {
					return Fonemas.W;
				}
			}
			if (posicao == palavra.length() - 1 && Letras.isVogal(letraAnterior)) {
				return Fonemas.W;
			}

			if (posicao < palavra.length() - 1) {
				String letraSeguinte = palavra.charAt(posicao + 1) + "";
				if (Letras.isLetraE(letraSeguinte)) {
					return "";
				}
			}

		}

		return Fonemas.U;
	}

}
