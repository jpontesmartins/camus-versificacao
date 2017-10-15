package camus.lacan.domain;

import org.junit.Assert;
import org.junit.Test;

import camus.lacan.domain.fonemas.FrequenciaDeFonemas;

public class AnaliseAliteracaoTest {
	
	@Test
	public void vozes_veladas_veludosas_vozes() {
		String frase = "vozes veladas velusosas vozes";
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}


	@Test
	public void tem_aliteracao_na_frase() {
		String frase = "o peito do pé do pedro é preto";
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void fonema_consonantal_p_mais_frequente() {
		String frase = "o peito do pé do pedro é preto";
		Assert.assertEquals("/p/", new FrequenciaDeFonemas().pegarFonemaConsonantalMaisFrequente(frase).getFonema());
	}

	@Test
	public void o_peito_do_pe_do_pedro_e_preto() {
		String frase = "o peito do pé de Pedro é preto";
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void quem_com_ferro_fere_com_ferro_sera_ferido() {
		String frase = "quem com ferro fere, com ferro será ferido";
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void quem_ja_viu_um_doce_tao_doce_como_o_doce_de_batata_doce() {
		String frase = "quem já viu um doce tão doce, como o doce de batata doce";
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void o_pato_pateta_pintou_o_caneco() {
		String frase = "O pato pateta pintou o caneco";
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void chegamos_de_uma_terra_feia_fria_fetida_futil() {
		AnaliseAliteracao figuras = new AnaliseAliteracao();
		String frase = "Chegamos de uma terra feia, fria, fétida, fútil";
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void toda_gente_homenageia_januaria_da_janela() {
		String frase = "Toda gente homenageia Januária na janela";
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void esperando_parada_pregada_na_pedra_do_porto() {
		AnaliseAliteracao figuras = new AnaliseAliteracao();
		String frase = "Esperando, parada, pregada na pedra do porto";
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void frase_com_R_mais_frequente() {
		String frase = "o rato roeu a roupa do rei de roma";
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

}
