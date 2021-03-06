package camus.lacan.domain.fonema.regras;

import java.util.List;

import camus.lacan.comum.Fonemas;
import camus.lacan.comum.Letras;
import camus.lacan.domain.fonema.Ditongo;
import camus.lacan.domain.separacao.SepararPalavra;

public class RegrasDoX  implements Regras {

	@Override
	public String aplicarRegras(String palavra, int posicao, String letraSeguinte) {
		if (posicao == 0)
			return Fonemas.X;

		if (posicao > 1) {
			SepararPalavra separarPalavra = new SepararPalavra();
			separarPalavra.separar(palavra);
			Ditongo ditongo = new Ditongo();
			List<String> ditongos = ditongo.pegarDitongos(palavra);

			if (!ditongos.isEmpty()) {
				return Fonemas.X;
			}
		}

		// exato, existir, executar
		if (Letras.A.equals(letraSeguinte) || Letras.isLetraE(letraSeguinte) || Letras.I.equals(letraSeguinte)) {
			return Fonemas.Z;
		}
		// TODO: som do X como S....
		// auxílio, próximo, sintaxe, trouxe
		if (Letras.isLetraE(letraSeguinte) || Letras.I.equals(letraSeguinte)) {
			return Fonemas.Z;
		}

		return "retorno";
	}

}
