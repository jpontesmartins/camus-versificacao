package camus.lacan.domain.tonicidade.monossilabos;

import java.util.Arrays;

import camus.lacan.domain.tonicidade.Vogais;

public class TratamentoMonossilabos {

	private String monossilabo;

	public TratamentoMonossilabos(String monossilabo) {
		this.monossilabo = monossilabo;
	}

	public TratamentoMonossilabos() {
	}

	public int distinguirEntreTonicoEAtono() {
		System.out.println();
		String letras[] = monossilabo.split("");
		
		for (String letra : letras) {
			if (Arrays.asList(Vogais.VOGAIS_ACENTUADAS).contains(letra)) {
				return 0;
			}
		}
		
		if (MonossilabosAtonos.getMonossilabosAtonos().contains(monossilabo)) {
			return -1;
		}
		
		return 0;
	}
	
}
