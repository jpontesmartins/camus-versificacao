package versificacao.separacao_silabica;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class FonemaTest {

	Fonema fonema;

	@Before
	public void setUp() {
		fonema = new Fonema();
	}
	@Test
	public void transcreverPalavraIndolencia() {
		Assert.assertEquals("/~i/ /d/ /o/ /l/ /~e/ /s/ /i/ /a/", fonema.transcreverPalavra("indolência"));
	}
	
	@Test
	public void transcreverPalavraFranqueza() {
		Assert.assertEquals("/f/ /r/ /ã/ /k/ /e/ /z/ /a/", fonema.transcreverPalavra("franqueza"));
	}
	
	@Test
	@Ignore
	public void transcreverPalavraAnarquia() {
		Assert.assertEquals("/a/ /n/ /a/ /r/ /k/ /i/ /a/", fonema.transcreverPalavra("anarquia"));
	}
	
	@Test
	public void transcreverPalavraAnistia() {
		Assert.assertEquals("/a/ /n/ /i/ /s/ /t/ /i/ /a/", fonema.transcreverPalavra("anistia"));
	}
	
	@Test
	public void transcreverPalavraAntigo() {
		Assert.assertEquals("/ã/ /t/ /i/ /g/ /u/", fonema.transcreverPalavra("antigo"));
	}

	@Test
	public void transcreverPalavraAnel() {
		Assert.assertEquals("/a/ /n/ /e/ /w/", fonema.transcreverPalavra("aneu"));
	}

	@Test
	public void transcreverPalavraAssim() {
		Assert.assertEquals("/a/ /s/ /~i/", fonema.transcreverPalavra("assim"));
	}

	@Test
	public void transcreverPalavraComo() {
		Assert.assertEquals("/k/ /o/ /m/ /u/", fonema.transcreverPalavra("como"));
	}

	@Test
	public void transcreverPalavraFoi() {
		Assert.assertEquals("/f/ /o/ /y/", fonema.transcreverPalavra("foi"));
	}

	@Test
	public void transcreverPalavraRoeu() {
		Assert.assertEquals("/R/ /o/ /e/ /w/", fonema.transcreverPalavra("roeu"));
	}

	@Test
	public void transcreverPalavraComeu() {
		Assert.assertEquals("/k/ /o/ /m/ /e/ /w/", fonema.transcreverPalavra("comeu"));
	}

	@Test
	public void transcreverPalavraViajei() {
		Assert.assertEquals("/v/ /i/ /a/ /j/ /e/ /y/", fonema.transcreverPalavra("viajei"));
	}

	@Test
	public void transcreverPalavraVou() {
		Assert.assertEquals("/v/ /o/ /w/", fonema.transcreverPalavra("vou"));
	}

	@Test
	public void transcreverPalavraFui() {
		Assert.assertEquals("/f/ /u/ /y/", fonema.transcreverPalavra("fui"));
	}

	@Test
	public void transcreverPalavraEnquanto() {
		Assert.assertEquals("/~e/ /k/ /w/ /ã/ /t/ /u/", fonema.transcreverPalavra("enquanto"));
	}

	@Test
	public void transcreverPalavraAtencao() {
		Assert.assertEquals("/a/ /t/ /~e/ /s/ /ã/ /w/", fonema.transcreverPalavra("atenção"));
	}

	@Test
	public void transcreverPalavraRamificacao() {
		Assert.assertEquals("/R/ /a/ /m/ /i/ /f/ /i/ /k/ /a/ /s/ /ã/ /w/", fonema.transcreverPalavra("ramificação"));
	}

	@Test
	public void transcreverPalavraDegrau() {
		Assert.assertEquals("/d/ /e/ /g/ /r/ /a/ /w/", fonema.transcreverPalavra("degrau"));
	}

	@Test
	public void reconhecerFonemaY() {
		// pai, cai, viajei, foi, fui
		Assert.assertEquals("/y/", fonema.descobrirFonemasDaPalavra("ai").get(1));
		Assert.assertEquals("/y/", fonema.descobrirFonemasDaPalavra("ei").get(1));
		Assert.assertEquals("/y/", fonema.descobrirFonemasDaPalavra("oi").get(1));
		Assert.assertEquals("/y/", fonema.descobrirFonemasDaPalavra("ui").get(1));
	}

	@Test
	public void reconhecerFonemaW() {
		// pau, mau, correu, fugiu, formou, tomou
		Assert.assertEquals("/w/", fonema.descobrirFonemasDaPalavra("au").get(1));
		Assert.assertEquals("/w/", fonema.descobrirFonemasDaPalavra("eu").get(1));
		Assert.assertEquals("/w/", fonema.descobrirFonemasDaPalavra("iu").get(1));
		Assert.assertEquals("/w/", fonema.descobrirFonemasDaPalavra("ou").get(1));
	}

	@Test
	public void transcreverPalavraHoje() {
		Assert.assertEquals("/o/ /j/ /e/", fonema.transcreverPalavra("hoje"));
	}

	@Test
	public void transcreverPalavraRolha() {
		Assert.assertEquals("/R/ /o/ /lh/ /a/", fonema.transcreverPalavra("rolha"));
	}

	@Test
	public void transcreverPalavraArara() {
		Assert.assertEquals("/a/ /r/ /a/ /r/ /a/", fonema.transcreverPalavra("arara"));
	}

	@Test
	public void transcreverPalavraHorror() {
		Assert.assertEquals("/o/ /R/ /o/ /r/", fonema.transcreverPalavra("horror"));
	}

	@Test
	public void transcreverPalavraAmor() {
		Assert.assertEquals("/a/ /m/ /o/ /r/", fonema.transcreverPalavra("amor"));
	}

	@Test
	public void transcreverPalavraCarro() {
		Assert.assertEquals("/k/ /a/ /R/ /u/", fonema.transcreverPalavra("carro"));
	}

	@Test
	public void transcreverPalavraCasamento() {
		Assert.assertEquals("/k/ /a/ /z/ /a/ /m/ /~e/ /t/ /u/", fonema.transcreverPalavra("casamento"));
	}

	@Test
	public void transcreverPalavraCasa() {
		Assert.assertEquals("/k/ /a/ /z/ /a/", fonema.transcreverPalavra("casa"));
	}

	@Test
	public void transcreverPalavraEmbargo() {
		Assert.assertEquals("/~e/ /b/ /a/ /R/ /g/ /u/", fonema.transcreverPalavra("embargo"));
	}

	@Test
	public void transcreverPalavraEncanto() {
		Assert.assertEquals("/~e/ /k/ /ã/ /t/ /u/", fonema.transcreverPalavra("encanto"));
	}

	@Test
	public void transcreverPalavraAmbito() {
		Assert.assertEquals("/ã/ /b/ /i/ /t/ /u/", fonema.transcreverPalavra("ambito"));
	}

	@Test
	public void transcreverPalavraQuanto() {
		Assert.assertEquals("/k/ /w/ /ã/ /t/ /u/", fonema.transcreverPalavra("quanto"));
	}

	@Test
	public void reconhecerFonemaM() {
		Assert.assertEquals("/m/", fonema.descobrirFonemasDaPalavra("ma").get(0));
	}

	@Test
	public void desconsiderarALetraH() {
		Assert.assertEquals("/a/", fonema.descobrirFonemasDaPalavra("ha").get(0));
		Assert.assertEquals("/o/", fonema.descobrirFonemasDaPalavra("ho").get(0));
		Assert.assertEquals("/e/", fonema.descobrirFonemasDaPalavra("he").get(0));
		Assert.assertEquals("/u/", fonema.descobrirFonemasDaPalavra("hu").get(0));
	}

	@Test
	public void naoReconhecerNComoFonemaN() {
		Assert.assertEquals("/ã/", fonema.descobrirFonemasDaPalavra("an").get(0));
		Assert.assertEquals("/~e/", fonema.descobrirFonemasDaPalavra("en").get(0));
		Assert.assertEquals("/~i/", fonema.descobrirFonemasDaPalavra("in").get(0));
		Assert.assertEquals("/õ/", fonema.descobrirFonemasDaPalavra("on").get(0));
		Assert.assertEquals("/~u/", fonema.descobrirFonemasDaPalavra("un").get(0));
	}

	@Test
	public void reconhecerFonemaP() {
		Assert.assertEquals("/p/", fonema.descobrirFonemasDaPalavra("pa").get(0));
		Assert.assertEquals("/p/", fonema.descobrirFonemasDaPalavra("pe").get(0));
		Assert.assertEquals("/p/", fonema.descobrirFonemasDaPalavra("pi").get(0));
		Assert.assertEquals("/p/", fonema.descobrirFonemasDaPalavra("po").get(0));
		Assert.assertEquals("/p/", fonema.descobrirFonemasDaPalavra("pu").get(0));
	}

	@Test
	public void reconhecerFonemaF() {
		Assert.assertEquals("/f/", fonema.descobrirFonemasDaPalavra("fa").get(0));
		Assert.assertEquals("/f/", fonema.descobrirFonemasDaPalavra("fe").get(0));
		Assert.assertEquals("/f/", fonema.descobrirFonemasDaPalavra("fi").get(0));
		Assert.assertEquals("/f/", fonema.descobrirFonemasDaPalavra("fo").get(0));
		Assert.assertEquals("/f/", fonema.descobrirFonemasDaPalavra("fu").get(0));
	}

	@Test
	public void reconhecerFonemaD() {
		Assert.assertEquals("/d/", fonema.descobrirFonemasDaPalavra("da").get(0));
		Assert.assertEquals("/d/", fonema.descobrirFonemasDaPalavra("de").get(0));
		Assert.assertEquals("/d/", fonema.descobrirFonemasDaPalavra("di").get(0));
		Assert.assertEquals("/d/", fonema.descobrirFonemasDaPalavra("do").get(0));
		Assert.assertEquals("/d/", fonema.descobrirFonemasDaPalavra("du").get(0));
	}

	@Test
	public void reconhecerFonemaB() {
		Assert.assertEquals("/b/", fonema.descobrirFonemasDaPalavra("ba").get(0));
		Assert.assertEquals("/b/", fonema.descobrirFonemasDaPalavra("be").get(0));
		Assert.assertEquals("/b/", fonema.descobrirFonemasDaPalavra("bi").get(0));
		Assert.assertEquals("/b/", fonema.descobrirFonemasDaPalavra("bo").get(0));
		Assert.assertEquals("/b/", fonema.descobrirFonemasDaPalavra("bu").get(0));
	}

	@Test
	@Ignore
	public void reconhecerFonemaXComX() {
		Assert.assertEquals("/x/", fonema.descobrirFonemasDaPalavra("xa").get(0)); // xarope
		Assert.assertEquals("/x/", fonema.descobrirFonemasDaPalavra("xe").get(0)); // xerox,
		Assert.assertEquals("/x/", fonema.descobrirFonemasDaPalavra("xi").get(0)); // xingar
		Assert.assertEquals("/x/", fonema.descobrirFonemasDaPalavra("xo").get(0));
		Assert.assertEquals("/x/", fonema.descobrirFonemasDaPalavra("xu").get(0));
		Assert.assertEquals("/x/", fonema.descobrirFonemasDaPalavra("aixa").get(0));
		Assert.assertEquals("/x/", fonema.descobrirFonemasDaPalavra("eixa").get(0));
	}

	@Test
	public void reconhecerFonemaZComS() {
		// casa, coisa, cesária
		Assert.assertEquals("/z/", fonema.descobrirFonemasDaPalavra("asa").get(1));
		Assert.assertEquals("/z/", fonema.descobrirFonemasDaPalavra("esa").get(1));
		Assert.assertEquals("/z/", fonema.descobrirFonemasDaPalavra("isa").get(1));
		Assert.assertEquals("/z/", fonema.descobrirFonemasDaPalavra("osa").get(1));
		Assert.assertEquals("/z/", fonema.descobrirFonemasDaPalavra("usa").get(1));
	}

	@Test
	public void reconhecerFonemaSNoFimDeUmaPalavra() {
		Assert.assertEquals("/s/", fonema.descobrirFonemasDaPalavra("as").get(1));
		Assert.assertEquals("/s/", fonema.descobrirFonemasDaPalavra("es").get(1));
		Assert.assertEquals("/s/", fonema.descobrirFonemasDaPalavra("is").get(1));
		Assert.assertEquals("/s/", fonema.descobrirFonemasDaPalavra("os").get(1));
		Assert.assertEquals("/s/", fonema.descobrirFonemasDaPalavra("us").get(1));
	}

	@Test
	@Ignore
	public void reconhecerFonemaZComX() {
		// exato, existir
		// casa, coisa, cesária
		// Assert.assertEquals("/z/", fonema.converterEmFonema("axa"));
		Assert.assertEquals("/z/", fonema.descobrirFonemasDaPalavra("exa")); // exame,
																				// exemplar,
																				// exigência
		Assert.assertEquals("/z/", fonema.descobrirFonemasDaPalavra("exe")); // exemplar,
																				// exemplar
		Assert.assertEquals("/z/", fonema.descobrirFonemasDaPalavra("exi")); // existente,
																				// exigência

		// Assert.assertEquals("/z/", fonema.converterEmFonema("oxa"));
		// Assert.assertEquals("/z/", fonema.converterEmFonema("uxa"));
	}

	@Test
	public void reconhecerFonemaZComZ() {
		// zinco, zebra
		Assert.assertEquals("/z/", fonema.descobrirFonemasDaPalavra("za").get(0));
		Assert.assertEquals("/z/", fonema.descobrirFonemasDaPalavra("ze").get(0));
		Assert.assertEquals("/z/", fonema.descobrirFonemasDaPalavra("zi").get(0));
		Assert.assertEquals("/z/", fonema.descobrirFonemasDaPalavra("zo").get(0));
		Assert.assertEquals("/z/", fonema.descobrirFonemasDaPalavra("zu").get(0));
	}

	@Test
	public void reconhecerFonemaNh() {
		Assert.assertEquals("/nh/", fonema.descobrirFonemasDaPalavra("nha").get(0));
		Assert.assertEquals("/nh/", fonema.descobrirFonemasDaPalavra("nhe").get(0));
		Assert.assertEquals("/nh/", fonema.descobrirFonemasDaPalavra("nhi").get(0));
		Assert.assertEquals("/nh/", fonema.descobrirFonemasDaPalavra("nho").get(0));
		Assert.assertEquals("/nh/", fonema.descobrirFonemasDaPalavra("nhu").get(0));
	}

	@Test
	public void reconhecerFonemaXComCh() {
		Assert.assertEquals("/x/", fonema.descobrirFonemasDaPalavra("cha").get(0)); // chalé
		Assert.assertEquals("/x/", fonema.descobrirFonemasDaPalavra("che").get(0)); // checagem
		Assert.assertEquals("/x/", fonema.descobrirFonemasDaPalavra("chi").get(0)); // chicote
		Assert.assertEquals("/x/", fonema.descobrirFonemasDaPalavra("cho").get(0)); // chocolate
		Assert.assertEquals("/x/", fonema.descobrirFonemasDaPalavra("chu").get(0)); // chuva
	}

	@Test
	public void reconhecerFonemaLh() {
		Assert.assertEquals("/lh/", fonema.descobrirFonemasDaPalavra("lha").get(0));
		Assert.assertEquals("/lh/", fonema.descobrirFonemasDaPalavra("lhe").get(0));
		Assert.assertEquals("/lh/", fonema.descobrirFonemasDaPalavra("lhi").get(0));
		Assert.assertEquals("/lh/", fonema.descobrirFonemasDaPalavra("lho").get(0));
		Assert.assertEquals("/lh/", fonema.descobrirFonemasDaPalavra("lhu").get(0));
	}

	@Test
	public void reconhecerFonemaL() {
		Assert.assertEquals("/l/", fonema.descobrirFonemasDaPalavra("la").get(0));
		Assert.assertEquals("/l/", fonema.descobrirFonemasDaPalavra("le").get(0));
		Assert.assertEquals("/l/", fonema.descobrirFonemasDaPalavra("li").get(0));
		Assert.assertEquals("/l/", fonema.descobrirFonemasDaPalavra("lo").get(0));
		Assert.assertEquals("/l/", fonema.descobrirFonemasDaPalavra("lu").get(0));
	}

	@Test
	@Ignore
	public void desconsiderarHComoFonema() {
		Assert.assertEquals("", fonema.descobrirFonemasDaPalavra("ha").get(0));
		Assert.assertEquals("", fonema.descobrirFonemasDaPalavra("he").get(0));
		Assert.assertEquals("", fonema.descobrirFonemasDaPalavra("hi").get(0));
		Assert.assertEquals("", fonema.descobrirFonemasDaPalavra("ho").get(0));
		Assert.assertEquals("", fonema.descobrirFonemasDaPalavra("hu").get(0));
	}

	@Test
	public void reconhecerFonemasRr() {
		// TODO: nao tem nenhum metodo validando se começa com vogal, por isso
		// não deu problema,
		// mas se pôr palavras com encontro consonantal como prato, braço e
		// grotesco ainda não passa
		Assert.assertEquals("/R/", fonema.descobrirFonemasDaPalavra("arra").get(1));
		Assert.assertEquals("/R/", fonema.descobrirFonemasDaPalavra("erre").get(1));
		Assert.assertEquals("/R/", fonema.descobrirFonemasDaPalavra("irri").get(1));
		Assert.assertEquals("/R/", fonema.descobrirFonemasDaPalavra("orro").get(1));
		Assert.assertEquals("/R/", fonema.descobrirFonemasDaPalavra("urru").get(1));
	}

	@Test
	public void reconhecerFonemasRMaiusculo() {
		Assert.assertEquals("/R/", fonema.descobrirFonemasDaPalavra("ra").get(0));
		Assert.assertEquals("/R/", fonema.descobrirFonemasDaPalavra("re").get(0));
		Assert.assertEquals("/R/", fonema.descobrirFonemasDaPalavra("ri").get(0));
		Assert.assertEquals("/R/", fonema.descobrirFonemasDaPalavra("ro").get(0));
		Assert.assertEquals("/R/", fonema.descobrirFonemasDaPalavra("ru").get(0));
	}

	@Test
	@Ignore
	public void reconhecerFonemasRMinusculo() {
		Assert.assertEquals("/r/", fonema.descobrirFonemasDaPalavra("ara"));
		Assert.assertEquals("/r/", fonema.descobrirFonemasDaPalavra("era"));
		Assert.assertEquals("/r/", fonema.descobrirFonemasDaPalavra("ira"));
		Assert.assertEquals("/r/", fonema.descobrirFonemasDaPalavra("ora"));
		Assert.assertEquals("/r/", fonema.descobrirFonemasDaPalavra("ura"));
	}

	@Test
	public void reconhecerFonemasGComG() {
		Assert.assertEquals("/g/", fonema.descobrirFonemasDaPalavra("ga").get(0));
		Assert.assertEquals("/g/", fonema.descobrirFonemasDaPalavra("gue").get(0));
		Assert.assertEquals("/g/", fonema.descobrirFonemasDaPalavra("gui").get(0));
		Assert.assertEquals("/g/", fonema.descobrirFonemasDaPalavra("go").get(0));
		Assert.assertEquals("/g/", fonema.descobrirFonemasDaPalavra("gu").get(0));
	}

	@Test
	public void reconhecerFonemasJComG() {
		Assert.assertEquals("/j/", fonema.descobrirFonemasDaPalavra("ge").get(0));
		Assert.assertEquals("/j/", fonema.descobrirFonemasDaPalavra("gi").get(0));
	}

	@Test
	public void reconhecerFonemasJComJ() {
		Assert.assertEquals("/j/", fonema.descobrirFonemasDaPalavra("ja").get(0));
		Assert.assertEquals("/j/", fonema.descobrirFonemasDaPalavra("je").get(0));
		Assert.assertEquals("/j/", fonema.descobrirFonemasDaPalavra("ji").get(0));
		Assert.assertEquals("/j/", fonema.descobrirFonemasDaPalavra("jo").get(0));
		Assert.assertEquals("/j/", fonema.descobrirFonemasDaPalavra("ju").get(0));
	}

	@Test
	public void reconhecerFonemasSComSs() {
		Assert.assertEquals("/s/", fonema.descobrirFonemasDaPalavra("ss").get(0));
	}

	@Test
	public void reconhecerFonemasSComXc() {
		Assert.assertEquals("/s/", fonema.descobrirFonemasDaPalavra("xc").get(0));
	}

	@Test
	public void reconhecerFonemasSComC() {
		Assert.assertEquals("/s/", fonema.descobrirFonemasDaPalavra("ce").get(0));
		Assert.assertEquals("/s/", fonema.descobrirFonemasDaPalavra("ci").get(0));
	}
	// @Test()
	// public void reconhecerFonemasSComX() {
	// //sexta, texto, têxtil, textural,
	// Assert.assertEquals("/s/", fonema.converterEmFonema("xi")); //auxílio,
	// aproximar, próximo
	// Assert.assertEquals("/s/", fonema.converterEmFonema("xe")); //sintaxe,
	// trouxe,
	// }

	@Test
	public void reconhecerFonemasKComC() {
		Assert.assertEquals("/k/", fonema.descobrirFonemasDaPalavra("ca").get(0));
		Assert.assertEquals("/k/", fonema.descobrirFonemasDaPalavra("co").get(0));
		Assert.assertEquals("/k/", fonema.descobrirFonemasDaPalavra("cu").get(0));
		Assert.assertEquals("/k/", fonema.descobrirFonemasDaPalavra("qui").get(0));
		Assert.assertEquals("/k/", fonema.descobrirFonemasDaPalavra("quo").get(0));
		Assert.assertEquals("/k/", fonema.descobrirFonemasDaPalavra("co").get(0));
		Assert.assertEquals("/k/", fonema.descobrirFonemasDaPalavra("cu").get(0));
	}

	@Test
	public void reconhecerFonemasKComQu() {
		Assert.assertEquals("/k/", fonema.descobrirFonemasDaPalavra("qui").get(0));
		Assert.assertEquals("/k/", fonema.descobrirFonemasDaPalavra("quo").get(0));
	}

	// @Test
	// public void reconhecerFonemasDeUmaPalavraInteira() {
	// Fonema fonema = new Fonema();
	// Assert.assertEquals("/k//a//z//a/", fonema.transcreverPalavra("casa"));
	// }

}
