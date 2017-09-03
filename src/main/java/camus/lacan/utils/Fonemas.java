package camus.lacan.utils;

import java.util.Arrays;

public class Fonemas {

	public static final String U = "/u/";
	public static final String I = "/i/";
	public static final String O = "/o/";
	public static final String E = "/e/";
	public static final String A = "/a/";

	public static final String AN = "/ã/";
	public static final String EN = "/~e/";
	public static final String IN = "/~i/";
	public static final String ON = "/õ/";
	public static final String UN = "/~u/";
	public static final String Y = "/y/";
	public static final String W = "/w/";

	public static final String Z = "/z/";
	public static final String S = "/s/";
	public static final String T = "/t/";
	public static final String P = "/p/";
	public static final String F = "/f/";
	public static final String D = "/d/";
	public static final String B = "/b/";
	public static final String R = "/r/";
	public static final String R_MAISCULO = "/R/";
	public static final String J = "/j/";
	public static final String G = "/g/";
	public static final String K = "/k/";
	public static final String V = "/v/";
	public static final String N = "/n/";
	public static final String X = "/x/";
	public static final String L = "/l/";
	public static final String M = "/m/";
	public static final String LH = "/lh/";
	public static final String NH = "/nh/";

	public static final String FONEMAS_CONSONANTAIS[] = { B, D, F, G, J, K, L, LH, M, N, NH, P, R, S, T, V, X, Z,
			R_MAISCULO };

	public static boolean isFonemaConsonantal(String chave) {
		return Arrays.asList(FONEMAS_CONSONANTAIS).contains(chave);
	}

}
