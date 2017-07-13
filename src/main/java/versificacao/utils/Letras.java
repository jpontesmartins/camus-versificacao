package versificacao.utils;

import java.util.Arrays;

public class Letras {

	private static final String AI = "ai";
	private static final String EI = "ei";
	private static final String OI = "ou";
	private static final String UI = "ui";
	private static final String AU = "au";
	private static final String EU = "eu";
	private static final String IU = "iu";
	private static final String OU = "ou";

	public static final String B = "b";
	public static final String C = "c";
	public static final String D = "d";
	public static final String F = "f";
	public static final String G = "g";
	public static final String H = "h";
	public static final String  J = "j";
	public static final String  K = "k";
	public static final String  L = "l";
	public static final String  N = "n";
	public static final String  P = "p";
	public static final String  Q = "q";
	public static final String  S = "s";
	public static final String  T = "t";
	public static final String  V = "v";
	public static final String  W = "w";
	public static final String  X = "x";
	public static final String  Y = "y";
	public static final String  Z = "z";
	public static final String  R = "r";
	public static final String M = "m";
	public static final String RR = "rr";
	public static final String  SS = "ss";
	public static final String  SC = "sc";
	public static final String SCC = "sç";
	public static final String XC = "xc";
	public static final String  XS = "xs";
	public static final String CH = "ch";
	public static final String LH = "lh";
	public static final String NH = "nh";
	public static final String PT = "pt";
	public static final String FT = "ft";
	public static final String TR = "tr";
	public static final String CL = "cl";
	public static final String DR = "dr";
	public static final String CR = "cr";
	public static final String GU = "gu";
	public static final String QU = "qu";
	public static final String AM = "am";
	public static final String EM = "em";
	public static final String IM = "im";
	public static final String OM = "om";
	public static final String UM = "um";
	public static final String AN = "an";
	public static final String EN = "en";
	public static final String IN = "in";
	public static final String ON = "on";
	public static final String UN = "un";
	public static final String PR = "pr";

	public static final String AA = "aa";
	public static final String EE = "ee";
	public static final String II = "ii";
	public static final String OO = "oo";
	public static final String UU = "uu";

	public static final String EA = "ea";
	public static final String IA = "ia";
	public static final String IO = "io";
	public static final String OA = "oa";
	public static final String OE = "oe";
	public static final String UA = "ua";

	public static final String A = "a";
	public static final String E = "e";
	public static final String I = "i";
	public static final String O = "o";
	public static final String U = "u";

	public static final String VOGAIS_2[] = { A, E, O };
	public static final String SEMI_VOGAIS[] = { I, U };

	public static final String A_ACENTO = "á";
	public static final String E_ACENTO = "é";
	public static final String I_ACENTO = "í";
	public static final String O_ACENTO = "ó";
	public static final String U_ACENTO = "ú";

	public static final String AU_ACENTO = "aú";
	public static final String AE_ACENTO = "aé";
	public static final String AI_ACENTO = "aí";
	public static final String OI_ACENTO = "oí";
	public static final String OE_ACENTO = "oé";
	public static final String UI_ACENTO = "uí";

	public static final String A_TIL = "ã";
	public static final String O_TIL = "õ";
	public static final String E_CIRC = "ê";
	public static final String A_CIRC = "â";
	public static final String O_CIRC = "ô";

	public static final String OUA = "oua";
	public static final String IUA = "iua";

	public static final String A_TIMBRE_ABERTO = "a";
	public static final String E_TIMBRE_ABERTO = "é";
	public static final String O_TIMBRE_ABERTO = "ó";

	public static final String E_TIMBRE_FECHADO = "ê";
	public static final String O_TIMBRE_FECHADO = "ô";
	public static final String I_TIMBRE_FECHADO = "i";
	public static final String U_TIMBRE_FECHADO = "u";

	public static final String VOGAIS_TIMBRES_FECHADOS[] = { E_TIMBRE_FECHADO, O_TIMBRE_FECHADO, I_TIMBRE_FECHADO,
			U_TIMBRE_FECHADO };

	public static final String DITONGOS_[] = { OUA, IUA };
	public static final String DITONGOS[] = { AI, EI, OI, UI, AU, A_TIL + O, EU, IU, OU, UA, U + A_ACENTO, U + E };

	public static final String DIGRAFOS_SEPARAVEIS[] = { RR, SS, SC, SCC, XC };
	public static final String DIGRAFOS_INSEPARAVEIS[] = { GU, QU, LH, NH, CH };
	public static final String DIGRAFOS_VOGAIS_NASAIS[] = { AM, AN, EM, EN, IM, IN, OM, ON, UM, UN };
	public static final String DIGRAFOS[] = { RR, SS, SC, SCC, XC, XS, GU, QU, LH, NH, CH, AM, EM, IM, OM, UM, AN, EN, IN, ON,
			UN };

	public static final String HIATOS[] = { AA, EE, II, OO, UU, EA, IA, IO, OA, UA, OE, OE_ACENTO, AU_ACENTO, AE_ACENTO,
			AI_ACENTO, OI_ACENTO, UI_ACENTO };

	public static final String VOGAIS[] = { A, E, I, O, U, A_ACENTO, E_ACENTO, I_ACENTO, O_ACENTO, U_ACENTO, A_TIL, O_TIL,
			A_CIRC, E_CIRC, O_CIRC };

	public static final String CONSOANTES[] = { B, C, D, F, G, H, J, K, L, M, N, P, Q, R, S, T, V, W, X, Y, Z };

	public static boolean isConsoante(String letra) {
		return Arrays.asList(CONSOANTES).contains(letra);
	}

	public static boolean isVogal(String letra) {
		return Arrays.asList(VOGAIS).contains(letra);
	}

	public static boolean isDitongo(String possivelDitongo) {
		return false;
	}

}
