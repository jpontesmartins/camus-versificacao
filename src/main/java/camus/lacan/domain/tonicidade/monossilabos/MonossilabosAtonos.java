package camus.lacan.domain.tonicidade.monossilabos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonossilabosAtonos {

	private static String[] PRONOMES_OBLIQUOS = { "me", "te", "se", "nos", "vos", "lhe" };
	private static String[] PRONOMES_RELATIVOS = { "QUE" };
	private static String[] conjuncoes = { "e", "nem", "mas", "que", "se", "ou" };
	private static String[] proposicoes = { "de", "em", "a", "com", "sob", "sem" };
	private static String[] artigos = { "o", "a", "os", "as", "um", "uns" };

	public static List<String> getMonossilabosAtonos() {
		List<String> todos = new ArrayList<>();
		todos.addAll(Arrays.asList(PRONOMES_OBLIQUOS));
		todos.addAll(Arrays.asList(PRONOMES_RELATIVOS));
		todos.addAll(Arrays.asList(conjuncoes));
		todos.addAll(Arrays.asList(proposicoes));
		todos.addAll(Arrays.asList(artigos));
		return todos;
	}

}
