package camus.lacan.domain;

import org.junit.Assert;
import org.junit.Test;

public class AnaliseAliteracaoTest {

	@Test
	public void o_peito_do_pe_do_pedro_e_preto_com_letras_maiusculas() {
		String frase = "O PEITO DO PÉ DE PEDRO É PRETO";
		Assert.assertEquals(8, new AnaliseAliteracao().descobrirFonemasMaisFrequentes(frase).get(0).getFrequencia());
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void tem_aliteracao_na_frase() {
		String frase = "o peito do pé do pedro é preto";
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void fonema_consonantal_p_mais_frequente_() {
		String frase = "o peito do pé do pedro é preto";
		Assert.assertEquals("/p/", new AnaliseAliteracao().pegarFonemaConsonantalMaisFrequente(frase).getFonema());
	}

	@Test
	public void o_peito_do_pe_do_pedro_e_preto() {
		String frase = "o peito do pé de Pedro é preto";
		Assert.assertEquals(8, new AnaliseAliteracao().pegarFonemaMaisFrequente(frase).getFrequencia());
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void quem_com_ferro_fere_com_ferro_sera_ferido() {
		AnaliseAliteracao figuras = new AnaliseAliteracao();
		String frase = "quem com ferro fere, com ferro será ferido";
		Assert.assertEquals(8, figuras.pegarFonemaMaisFrequente(frase).getFrequencia());
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void quem_ja_viu_um_doce_tao_doce_como_o_doce_de_batata_doce_Test() {
		AnaliseAliteracao figuras = new AnaliseAliteracao();
		String frase = "quem já viu um doce tão doce, como o doce de batata doce";
		Assert.assertEquals(10, figuras.pegarFonemaMaisFrequente(frase).getFrequencia());
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void o_pato_pateta_pintou_o_caneco() {
		AnaliseAliteracao figuras = new AnaliseAliteracao();
		String frase = "O pato pateta pintou o caneco";
		Assert.assertEquals(6, figuras.pegarFonemaMaisFrequente(frase).getFrequencia());
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void chegamos_de_uma_terra_feia_fria_fetida_futil() {
		AnaliseAliteracao figuras = new AnaliseAliteracao();
		String frase = "Chegamos de uma terra feia, fria, fétida, fútil";
		Assert.assertEquals(8, figuras.pegarFonemaMaisFrequente(frase).getFrequencia());
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void toda_gente_homenageia_januaria_da_janela() {
		AnaliseAliteracao figuras = new AnaliseAliteracao();
		String frase = "Toda gente homenageia Januária na janela";
		Assert.assertEquals(7, figuras.pegarFonemaConsonantalMaisFrequente(frase).getFrequencia());
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void esperando_parada_pregada_na_pedra_do_portoTest() {
		AnaliseAliteracao figuras = new AnaliseAliteracao();
		String frase = "Esperando, parada, pregada na pedra do porto";
		Assert.assertEquals(9, figuras.pegarFonemaMaisFrequente(frase).getFrequencia());
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

	@Test
	public void frase_com_R_mais_frequente() {
		String frase = "o rato roeu a roupa do rei de roma";
		Assert.assertEquals(10, new AnaliseAliteracao().pegarFonemaMaisFrequente(frase).getFrequencia());
		Assert.assertTrue(new AnaliseAliteracao().temAliteracao(frase));
	}

}
