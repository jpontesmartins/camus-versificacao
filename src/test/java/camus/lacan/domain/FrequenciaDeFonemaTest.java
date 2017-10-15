package camus.lacan.domain;

import org.junit.Assert;
import org.junit.Test;

import camus.lacan.domain.fonemas.FrequenciaDeFonemas;

public class FrequenciaDeFonemaTest {
	
	@Test
	public void o_pato_pateta_pintou_o_caneco() {
		String frase = "o pato pateta pintou o caneco";
		double frequencia = new FrequenciaDeFonemas().pegarFrequenciaDoFonemaMaisFrequenteEmPercentual(frase);
		Assert.assertEquals(50.0,frequencia,0.0);
	}
	
	@Test
	public void tem_samba_de_sobra_quem_sabe_sambar_tem_57_por_cento_de_s() {
		String frase = "tem samba de sobra quem sabe sambar";
		double frequencia = new FrequenciaDeFonemas().pegarFrequenciaDoFonemaMaisFrequenteEmPercentual(frase);
		Assert.assertEquals(57.0,frequencia,0.0);
	}
	
	@Test
	public void frequencia_do_fonema_b_100_por_cento() {
		String frase = "bbbb";
		double frequencia = new FrequenciaDeFonemas().pegarFrequenciaDoFonemaMaisFrequenteEmPercentual(frase);
		Assert.assertEquals(100.0,frequencia,0.0);
	}

	@Test
	public void o_peito_do_pe_do_pedro_e_preto_com_letras_maiusculas() {
		String frase = "O PEITO DO PÉ DE PEDRO É PRETO";
//		String frase = "o peito do pé de pedro é preto";
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

}
