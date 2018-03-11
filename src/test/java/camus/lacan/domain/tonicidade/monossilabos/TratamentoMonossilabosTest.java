package camus.lacan.domain.tonicidade.monossilabos;

import org.junit.Assert;
import org.junit.Test;

import camus.lacan.domain.tonicidade.monossilabos.TratamentoMonossilabos;

public class TratamentoMonossilabosTest {
	
	@Test
	public void deve_reconher_monossilabo_atono_nos() {
		Assert.assertEquals(-1, new TratamentoMonossilabos("nos").distinguirEntreTonicoEAtono());
	}

	@Test
	public void deve_reconher_monossilabo_atono_que() {
		Assert.assertEquals(-1, new TratamentoMonossilabos("que").distinguirEntreTonicoEAtono());
	}

	@Test
	public void deve_reconher_monossilabo_tonico_que_acento() {
		Assert.assertEquals(0, new TratamentoMonossilabos("quê").distinguirEntreTonicoEAtono());
	}

	@Test
	public void deve_reconher_monossilabo_tonico_nos_acento() {
		Assert.assertEquals(0, new TratamentoMonossilabos("nós").distinguirEntreTonicoEAtono());
	}
	
	@Test
	public void deve_reconher_monossilabo_atono_de() {
		Assert.assertEquals(-1, new TratamentoMonossilabos("de").distinguirEntreTonicoEAtono());
	}

	@Test
	public void deve_reconher_monossilabo_tonico_voz() {
		Assert.assertEquals(0, new TratamentoMonossilabos("voz").distinguirEntreTonicoEAtono());
	}
}
