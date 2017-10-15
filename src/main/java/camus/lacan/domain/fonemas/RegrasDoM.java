package camus.lacan.domain.fonemas;

import camus.lacan.utils.Fonemas;
import camus.lacan.utils.Letras;

public class RegrasDoM  implements Regras {

	@Override
	public String aplicarRegras(String palavra, int posicao, String letraSeguinte) {
		if (posicao == 0)
			return Fonemas.M;
		String letraAnterior = palavra.charAt(posicao - 1) + "";
		if (Letras.isVogal(letraAnterior) && Letras.isVogal(letraSeguinte)) {
			return Fonemas.M;
		}
		if (posicao == palavra.length() - 1) {
			if (Letras.isVogal(letraAnterior)) {
				return "/~" + letraAnterior + "/";
			}

			return "/~i/";
		}
		return "";
	}

}
