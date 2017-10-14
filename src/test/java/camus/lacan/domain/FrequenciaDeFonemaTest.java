package camus.lacan.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import camus.lacan.domain.fonemas.FrequenciaDeFonemas;

public class FrequenciaDeFonemaTest {
	
	
	@Test
	public void o_peito_do_pe_do_pedro_e_preto_com_letras_maiusculas() {
		String frase = "O PEITO DO PÉ DE PEDRO É PRETO";
		List<Fonema> fonemas = new ArrayList<>();
		fonemas.add(new Fonema("p","/p/",1));
		fonemas.add(new Fonema("b","/b/",2));
		fonemas.add(new Fonema("a","/a/",3));
		fonemas.add(new Fonema("c","/k/",2));
		Assert.assertEquals(3.0,new FrequenciaDeFonemas().listarFonemasUnicosComFrequencia(fonemas).get(0).getFrequencia(),0);
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	
	
	

}
