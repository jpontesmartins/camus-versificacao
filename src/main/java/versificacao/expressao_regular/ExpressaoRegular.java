package versificacao.expressao_regular;

public class ExpressaoRegular {

	public static String REGEX_DATA = "\\d{2}-\\d{2}-\\d{4}";
	public static String REGEX_PERIODO = "\\w*\\[{1}\\d+,{0,1}\\d*\\]{1}";

	public static void main(String[] args) {

		System.out.println("11-01-2016".matches(REGEX_DATA));
		System.out.println("IMPERIO_RUSSO[1,1299]".matches(REGEX_PERIODO));
	}

}
