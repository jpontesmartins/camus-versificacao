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

	// letra i - (como vogal e como semi-vogal)
	// letra u - (como vogal e semi-vogal)
	
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
		Assert.assertEquals("/o/ /R/ /o/ /R/", fonema.transcreverPalavra("horror"));
	}
	
	@Test
	public void transcreverPalavraAmor() {
		Assert.assertEquals("/a/ /m/ /o/ /R/", fonema.transcreverPalavra("amor"));
	}
	

	@Test
	public void transcreverPalavraCarro() {
		Assert.assertEquals("/k/ /a/ /R/ /o/", fonema.transcreverPalavra("carro"));
	}
	
	@Test
	public void transcreverPalavraCasamento() {
		Assert.assertEquals("/k/ /a/ /z/ /a/ /m/ /~e/ /t/ /o/", fonema.transcreverPalavra("casamento"));
	}
	
	@Test
	public void transcreverPalavraCasa() {
		Assert.assertEquals("/k/ /a/ /z/ /a/", fonema.transcreverPalavra("casa"));
	}
	
	@Test
	public void transcreverPalavraEmbargo() {
		Assert.assertEquals("/~e/ /b/ /a/ /R/ /g/ /o/", fonema.transcreverPalavra("embargo"));
	}
	
	@Test
	public void transcreverPalavraEncanto() {
		Assert.assertEquals("/~e/ /k/ /ã/ /t/ /o/", fonema.transcreverPalavra("encanto"));
	}
	
	@Test
	public void transcreverPalavraAmbito() {
		Assert.assertEquals("/ã/ /b/ /i/ /t/ /o/", fonema.transcreverPalavra("ambito"));
	}
	
	@Test
	public void transcreverPalavraQuanto() {
		Assert.assertEquals("/k/ /w/ /ã/ /t/ /o/", fonema.transcreverPalavra("quanto"));
	}
	
	
	@Test
	public void desconsiderarALetraH() {
		Assert.assertEquals("/a/", fonema.converterEmFonema("ha"));
		Assert.assertEquals("/o/", fonema.converterEmFonema("ho"));
		Assert.assertEquals("/e/", fonema.converterEmFonema("he"));
		Assert.assertEquals("/u/", fonema.converterEmFonema("hu"));
	}
	
	@Test
	public void naoReconhecerNComoFonemaN() {
		Assert.assertEquals("/ã/", fonema.converterEmFonema("an"));
		Assert.assertEquals("/~e/", fonema.converterEmFonema("en"));
		Assert.assertEquals("/~i/", fonema.converterEmFonema("in"));
		Assert.assertEquals("/õ/", fonema.converterEmFonema("on"));
		Assert.assertEquals("/~u/", fonema.converterEmFonema("un"));
	}
	
	
	@Test
	public void reconhecerFonemaP() {
		Assert.assertEquals("/p/", fonema.converterEmFonema("pa"));
		Assert.assertEquals("/p/", fonema.converterEmFonema("pe"));
		Assert.assertEquals("/p/", fonema.converterEmFonema("pi"));
		Assert.assertEquals("/p/", fonema.converterEmFonema("po"));
		Assert.assertEquals("/p/", fonema.converterEmFonema("pu"));
	}
	
	@Test
	public void reconhecerFonemaF() {
		Assert.assertEquals("/f/", fonema.converterEmFonema("fa"));
		Assert.assertEquals("/f/", fonema.converterEmFonema("fe"));
		Assert.assertEquals("/f/", fonema.converterEmFonema("fi"));
		Assert.assertEquals("/f/", fonema.converterEmFonema("fo"));
		Assert.assertEquals("/f/", fonema.converterEmFonema("fu"));
	}
	
	
	@Test
	public void reconhecerFonemaD() {
		Assert.assertEquals("/d/", fonema.converterEmFonema("da"));
		Assert.assertEquals("/d/", fonema.converterEmFonema("de"));
		Assert.assertEquals("/d/", fonema.converterEmFonema("di"));
		Assert.assertEquals("/d/", fonema.converterEmFonema("do"));
		Assert.assertEquals("/d/", fonema.converterEmFonema("du"));
	}
	
	@Test
	public void reconhecerFonemaB() {
		Assert.assertEquals("/b/", fonema.converterEmFonema("ba"));
		Assert.assertEquals("/b/", fonema.converterEmFonema("be"));
		Assert.assertEquals("/b/", fonema.converterEmFonema("bi"));
		Assert.assertEquals("/b/", fonema.converterEmFonema("bo"));
		Assert.assertEquals("/b/", fonema.converterEmFonema("bu"));
	}
	
	
	@Test
	@Ignore
	public void reconhecerFonemaXComX() {
		Assert.assertEquals("/x/", fonema.converterEmFonema("xa")); //xarope
		Assert.assertEquals("/x/", fonema.converterEmFonema("xe")); //xerox, 
		Assert.assertEquals("/x/", fonema.converterEmFonema("xi")); //xingar
		Assert.assertEquals("/x/", fonema.converterEmFonema("xo"));
		Assert.assertEquals("/x/", fonema.converterEmFonema("xu"));
		Assert.assertEquals("/x/", fonema.converterEmFonema("aixa"));
		Assert.assertEquals("/x/", fonema.converterEmFonema("eixa"));
	}

	@Test
	public void reconhecerFonemaZComS() {
		//casa, coisa, cesária
		Assert.assertEquals("/z/", fonema.converterEmFonema2("asa"));
		Assert.assertEquals("/z/", fonema.converterEmFonema2("esa"));
		Assert.assertEquals("/z/", fonema.converterEmFonema2("isa"));
		Assert.assertEquals("/z/", fonema.converterEmFonema2("osa"));
		Assert.assertEquals("/z/", fonema.converterEmFonema2("usa"));
	}
	
	@Test
	public void reconhecerFonemaSNoFimDeUmaPalavra() {
		Assert.assertEquals("/s/", fonema.converterEmFonema2("as"));
		Assert.assertEquals("/s/", fonema.converterEmFonema2("es"));
		Assert.assertEquals("/s/", fonema.converterEmFonema2("is"));
		Assert.assertEquals("/s/", fonema.converterEmFonema2("os"));
		Assert.assertEquals("/s/", fonema.converterEmFonema2("us"));
	}
	
	@Test
	@Ignore
	public void reconhecerFonemaZComX() {
		//exato, existir
		//casa, coisa, cesária
//		Assert.assertEquals("/z/", fonema.converterEmFonema("axa"));
		Assert.assertEquals("/z/", fonema.converterEmFonema("exa")); //exame, exemplar, exigência
		Assert.assertEquals("/z/", fonema.converterEmFonema("exe")); //exemplar, exemplar
		Assert.assertEquals("/z/", fonema.converterEmFonema("exi")); //existente, exigência
		
		
//		Assert.assertEquals("/z/", fonema.converterEmFonema("oxa"));
//		Assert.assertEquals("/z/", fonema.converterEmFonema("uxa"));
	}

	@Test
	public void reconhecerFonemaZComZ() {
		//zinco, zebra
		Assert.assertEquals("/z/", fonema.converterEmFonema("za"));
		Assert.assertEquals("/z/", fonema.converterEmFonema("ze"));
		Assert.assertEquals("/z/", fonema.converterEmFonema("zi"));
		Assert.assertEquals("/z/", fonema.converterEmFonema("zo"));
		Assert.assertEquals("/z/", fonema.converterEmFonema("zu"));
	}

	@Test
	public void reconhecerFonemaNh() {
		Assert.assertEquals("/nh/", fonema.converterEmFonema("nha"));
		Assert.assertEquals("/nh/", fonema.converterEmFonema("nhe"));
		Assert.assertEquals("/nh/", fonema.converterEmFonema("nhi"));
		Assert.assertEquals("/nh/", fonema.converterEmFonema("nho"));
		Assert.assertEquals("/nh/", fonema.converterEmFonema("nhu"));
	}

	@Test
	public void reconhecerFonemaXComCh() {
		Assert.assertEquals("/x/", fonema.converterEmFonema("cha")); // chalé
		Assert.assertEquals("/x/", fonema.converterEmFonema("che")); // checagem
		Assert.assertEquals("/x/", fonema.converterEmFonema("chi")); // chicote
		Assert.assertEquals("/x/", fonema.converterEmFonema("cho")); // chocolate
		Assert.assertEquals("/x/", fonema.converterEmFonema("chu")); // chuva
	}

	@Test
	public void reconhecerFonemaLh() {
		Assert.assertEquals("/lh/", fonema.converterEmFonema("lha"));
		Assert.assertEquals("/lh/", fonema.converterEmFonema("lhe"));
		Assert.assertEquals("/lh/", fonema.converterEmFonema("lhi"));
		Assert.assertEquals("/lh/", fonema.converterEmFonema("lho"));
		Assert.assertEquals("/lh/", fonema.converterEmFonema("lhu"));
	}
	
	@Test
	public void reconhecerFonemaL() {
		Assert.assertEquals("/l/", fonema.converterEmFonema("la"));
		Assert.assertEquals("/l/", fonema.converterEmFonema("le"));
		Assert.assertEquals("/l/", fonema.converterEmFonema("li"));
		Assert.assertEquals("/l/", fonema.converterEmFonema("lo"));
		Assert.assertEquals("/l/", fonema.converterEmFonema("lu"));
	}

	@Test
	@Ignore
	public void desconsiderarHComoFonema() {
		Assert.assertEquals("", fonema.converterEmFonema("ha"));
		Assert.assertEquals("", fonema.converterEmFonema("he"));
		Assert.assertEquals("", fonema.converterEmFonema("hi"));
		Assert.assertEquals("", fonema.converterEmFonema("ho"));
		Assert.assertEquals("", fonema.converterEmFonema("hu"));
	}

	@Test
	@Ignore
	public void reconhecerFonemasRr() {
		// TODO: nao tem nenhum metodo validando se começa com vogal, por isso
		// não deu problema,
		// mas se pôr palavras com encontro consonantal como prato, braço e
		// grotesco ainda não passa
		Assert.assertEquals("/R/", fonema.converterEmFonema("arra"));
		Assert.assertEquals("/R/", fonema.converterEmFonema("erre"));
		Assert.assertEquals("/R/", fonema.converterEmFonema("irri"));
		Assert.assertEquals("/R/", fonema.converterEmFonema("orro"));
		Assert.assertEquals("/R/", fonema.converterEmFonema("urru"));
	}

	@Test
	public void reconhecerFonemasRMaiusculo() {
		Assert.assertEquals("/R/", fonema.converterEmFonema("ra"));
		Assert.assertEquals("/R/", fonema.converterEmFonema("re"));
		Assert.assertEquals("/R/", fonema.converterEmFonema("ri"));
		Assert.assertEquals("/R/", fonema.converterEmFonema("ro"));
		Assert.assertEquals("/R/", fonema.converterEmFonema("ru"));
	}

	@Test
	@Ignore
	public void reconhecerFonemasRMinusculo() {
		Assert.assertEquals("/r/", fonema.converterEmFonema("ara"));
		Assert.assertEquals("/r/", fonema.converterEmFonema("era"));
		Assert.assertEquals("/r/", fonema.converterEmFonema("ira"));
		Assert.assertEquals("/r/", fonema.converterEmFonema("ora"));
		Assert.assertEquals("/r/", fonema.converterEmFonema("ura"));
		// Assert.assertEquals("/r/", fonema.converterEmFonema("bra"));
		// Assert.assertEquals("/r/", fonema.converterEmFonema("cra"));
		// Assert.assertEquals("/r/", fonema.converterEmFonema("tro"));
		// Assert.assertEquals("/r/", fonema.converterEmFonema("per"));
	}

	@Test
	public void reconhecerFonemasGComG() {
		Assert.assertEquals("/g/", fonema.converterEmFonema("ga"));
		Assert.assertEquals("/g/", fonema.converterEmFonema("gue"));
		Assert.assertEquals("/g/", fonema.converterEmFonema("gui"));
		Assert.assertEquals("/g/", fonema.converterEmFonema("go"));
		Assert.assertEquals("/g/", fonema.converterEmFonema("gu"));
	}

	@Test
	public void reconhecerFonemasJComG() {
		Assert.assertEquals("/j/", fonema.converterEmFonema("ge"));
		Assert.assertEquals("/j/", fonema.converterEmFonema("gi"));
	}

	@Test
	public void reconhecerFonemasJComJ() {
		Assert.assertEquals("/j/", fonema.converterEmFonema("ja"));
		Assert.assertEquals("/j/", fonema.converterEmFonema("je"));
		Assert.assertEquals("/j/", fonema.converterEmFonema("ji"));
		Assert.assertEquals("/j/", fonema.converterEmFonema("jo"));
		Assert.assertEquals("/j/", fonema.converterEmFonema("ju"));
	}

	@Test
	public void reconhecerFonemasSComSs() {
		Assert.assertEquals("/s/", fonema.converterEmFonema("ss"));
	}

	@Test
	public void reconhecerFonemasSComXc() {
		Assert.assertEquals("/s/", fonema.converterEmFonema("xc"));
	}

	@Test
	public void reconhecerFonemasSComC() {
		Assert.assertEquals("/s/", fonema.converterEmFonema("ce"));
		Assert.assertEquals("/s/", fonema.converterEmFonema("ci"));
	}
//	@Test()
//	public void reconhecerFonemasSComX() {
//		//sexta, texto, têxtil, textural, 
//		Assert.assertEquals("/s/", fonema.converterEmFonema("xi")); //auxílio, aproximar, próximo
//		Assert.assertEquals("/s/", fonema.converterEmFonema("xe")); //sintaxe, trouxe, 
//	}

	@Test
	public void reconhecerFonemasKComC() {
		Assert.assertEquals("/k/", fonema.converterEmFonema("ca"));
		Assert.assertEquals("/k/", fonema.converterEmFonema("co"));
		Assert.assertEquals("/k/", fonema.converterEmFonema("cu"));
		Assert.assertEquals("/k/", fonema.converterEmFonema("qui"));
		Assert.assertEquals("/k/", fonema.converterEmFonema("quo"));
		Assert.assertEquals("/k/", fonema.converterEmFonema("co"));
		Assert.assertEquals("/k/", fonema.converterEmFonema("cu"));
	}

	@Test
	public void reconhecerFonemasKComQu() {
		Assert.assertEquals("/k/", fonema.converterEmFonema("qui"));
		Assert.assertEquals("/k/", fonema.converterEmFonema("quo"));
	}

	// @Test
	// public void reconhecerFonemasDeUmaPalavraInteira() {
	// Fonema fonema = new Fonema();
	// Assert.assertEquals("/k//a//z//a/", fonema.transcreverPalavra("casa"));
	// }

}
