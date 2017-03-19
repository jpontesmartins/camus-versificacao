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
		Assert.assertEquals("atencao", escansao.removerAcentuacao("aten��o!"));
		Assert.assertEquals("axe", escansao.removerAcentuacao("ax�!"));
		Assert.assertEquals("sera", escansao.removerAcentuacao("ser�?"));
		Assert.assertEquals("assim", escansao.removerAcentuacao("assim,"));
	}

}
