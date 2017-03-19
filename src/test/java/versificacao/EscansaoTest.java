package versificacao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EscansaoTest {

	private Escansao escansao;

	@Before
	public void setUp() {
		escansao = new Escansao();
	}

	@Test
	public void palavraTemQueVirSemAcentuacaoEPontuacaoTest() {
		Assert.assertEquals("atencao", escansao.removerAcentuacao("atenção!"));
		Assert.assertEquals("axe", escansao.removerAcentuacao("axé!"));
		Assert.assertEquals("sera", escansao.removerAcentuacao("será?"));
		Assert.assertEquals("assim", escansao.removerAcentuacao("assim,"));
	}

}
