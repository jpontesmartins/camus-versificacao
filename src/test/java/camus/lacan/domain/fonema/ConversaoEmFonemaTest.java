package camus.lacan.domain.fonema;

import org.junit.Assert;
import org.junit.Test;

import camus.lacan.domain.fonema.ConversaoEmFonema;


public class ConversaoEmFonemaTest {

	@Test
	public void vogalA() {
		ConversaoEmFonema conversaoEmFonema = new ConversaoEmFonema();
		Assert.assertEquals("/a/", conversaoEmFonema.transcreverPalavra("/á/"));
		Assert.assertEquals("/a/", conversaoEmFonema.transcreverPalavra("/â/"));
		Assert.assertEquals("/a/", conversaoEmFonema.transcreverPalavra("/à/"));
		Assert.assertEquals("/ã/", conversaoEmFonema.transcreverPalavra("/ã/"));
	}
	
	
	@Test
	public void vogalE() {
		ConversaoEmFonema conversaoEmFonema = new ConversaoEmFonema();
		Assert.assertEquals("/e/", conversaoEmFonema.transcreverPalavra("/é/"));
		Assert.assertEquals("/e/", conversaoEmFonema.transcreverPalavra("/ê/"));
	}
	
	
	@Test
	public void pe() {
		ConversaoEmFonema conversaoEmFonema = new ConversaoEmFonema();
		Assert.assertEquals("/p/ /e/", conversaoEmFonema.transcreverPalavra("pé"));
	}
	
	@Test
	public void futil() {
		ConversaoEmFonema conversaoEmFonema = new ConversaoEmFonema();
		Assert.assertEquals("/f/ /u/ /t/ /i/ /l/", conversaoEmFonema.transcreverPalavra("fútil"));
	}
	
	@Test
	public void quem() {
		ConversaoEmFonema conversaoEmFonema = new ConversaoEmFonema();
		Assert.assertEquals("/k/ /~e/", conversaoEmFonema.transcreverPalavra("quem"));
	}
	@Test
	public void tambem() {
		ConversaoEmFonema conversaoEmFonema = new ConversaoEmFonema();
		Assert.assertEquals("/t/ /ã/ /b/ /~é/", conversaoEmFonema.transcreverPalavra("também"));
	}
	
	@Test
	public void grafia_m_em_fim_de_palavra() {
		ConversaoEmFonema conversaoEmFonema = new ConversaoEmFonema();
		Assert.assertEquals("/t/ /ã/ /b/ /~é/", conversaoEmFonema.transcreverPalavra("também"));
		Assert.assertEquals("/a/ /m/ /~é/", conversaoEmFonema.transcreverPalavra("amém"));
		
	}
	@Test
	public void grafia_m_no_inicio_da_palavra() {
		ConversaoEmFonema conversaoEmFonema = new ConversaoEmFonema();
		Assert.assertEquals("/m/ /u/ /z/ /i/ /k/ /a/", conversaoEmFonema.transcreverPalavra("música"));
		Assert.assertEquals("/m/ /i/ /t/ /u/", conversaoEmFonema.transcreverPalavra("mito"));
	}
	
	@Test
	public void grafia_n_no_inicio_da_palavra() {
		ConversaoEmFonema conversaoEmFonema = new ConversaoEmFonema();
		Assert.assertEquals("/n/ /a/ /t/ /u/", conversaoEmFonema.transcreverPalavra("nato"));
		Assert.assertEquals("/n/ /o/ /t/ /u/ /R/ /n/ /u/", conversaoEmFonema.transcreverPalavra("noturno"));
	}
	
	@Test
	public void grafia_n_no_meio_da_palavra() {
		ConversaoEmFonema conversaoEmFonema = new ConversaoEmFonema();
		Assert.assertEquals("/a/ /n/ /e/ /l/", conversaoEmFonema.transcreverPalavra("anél"));
		Assert.assertEquals("/g/ /r/ /a/ /n/ /i/ /t/ /u/", conversaoEmFonema.transcreverPalavra("granito"));
//		Assert.assertEquals("/ã/ /t/ /a/", conversaoEmFonema.transcreverPalavra("anta"));
	}
	

}
