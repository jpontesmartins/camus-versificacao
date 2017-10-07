package camus.lacan.domain;

import org.junit.Assert;
import org.junit.Test;


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
	
//	@Test
	public void quem() {
		ConversaoEmFonema conversaoEmFonema = new ConversaoEmFonema();
		Assert.assertEquals("/k/ /~e/", conversaoEmFonema.transcreverPalavra("quem"));
	}

}
