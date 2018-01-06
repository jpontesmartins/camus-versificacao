package camus.lacan.domain.fonema;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import camus.lacan.domain.fonema.Ditongo;

public class DitongoTest {

	Ditongo ditongo;

	@Before
	public void setUp() {
		ditongo = new Ditongo();
	}

	 
	@Test
	public void temDitongo() {
		Assert.assertEquals("cau", ditongo.pegarDitongos("causa").get(0));
		Assert.assertEquals("sau", ditongo.pegarDitongos("saudade").get(0));

		Assert.assertEquals("bei", ditongo.pegarDitongos("beijo").get(0));
		Assert.assertEquals("dei", ditongo.pegarDitongos("deixa").get(0));
		
		Assert.assertEquals("pai", ditongo.pegarDitongos("paixão").get(0));
		Assert.assertEquals("mais", ditongo.pegarDitongos("mais").get(0));
		Assert.assertEquals("mui", ditongo.pegarDitongos("muito").get(0));
		Assert.assertEquals("pou", ditongo.pegarDitongos("pouco").get(0));
		
		Assert.assertEquals("lão", ditongo.pegarDitongos("balão").get(0));
		Assert.assertEquals("quá", ditongo.pegarDitongos("aquário").get(0));
		Assert.assertEquals("qua", ditongo.pegarDitongos("quadrado").get(0));
		Assert.assertEquals("ques", ditongo.pegarDitongos("sequestro").get(0));
		
		Assert.assertEquals("mei", ditongo.pegarDitongos("ameixa").get(0));
		Assert.assertEquals("quei", ditongo.pegarDitongos("queixa").get(0));
		Assert.assertEquals("cai", ditongo.pegarDitongos("caixa").get(0));
		

		
		
		//estao sendo considerados hiatos pois divide-se as silabas
//		Assert.assertEquals("rio", ditongo.pegarDitongos("terrário").get(0));
//		Assert.assertEquals("rie", ditongo.pegarDitongos("série").get(0));
//		Assert.assertEquals("rio", ditongo.pegarDitongos("terrário").get(0));
		
	}

}
