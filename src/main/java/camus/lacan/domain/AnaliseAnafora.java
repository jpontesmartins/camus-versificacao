package camus.lacan.domain;

public class AnaliseAnafora {

	public boolean temAnaforaNosVersos(String... versos) {

		String primeiroVerso = versos[0];
		String segundoVerso = versos[1];

		String[] palavrasDoPrimeiroVerso = primeiroVerso.split(" ");
		String[] palavrasDoSegundoVerso = segundoVerso.split(" ");

		if (palavrasDoPrimeiroVerso.length > 0 && palavrasDoSegundoVerso.length > 0) {
			if (palavrasDoPrimeiroVerso[0].equalsIgnoreCase(palavrasDoSegundoVerso[0])) {
				return true;
			}
		}

		return false;
	}

}
