package versificacao;

import com.google.gson.Gson;

public class EscansaoController2 {

    public String versificar(String exemplo1) {
<<<<<<< HEAD
    	String caracteresA = "����������������������������������������������";
		String caracteresB = "aaaaaeeeeiiiiooooouuuucAAAAAEEEEIIIIOOOOOUUUUC";
    	String versificado = "de/ re/ pen/ te/ n�o/ mais/ que/ de/ re/ pen/ te";
    	Poema poema = new Poema("de repente nao mais que de repente", versificado);
    	Gson gson = new Gson();
    	return gson.toJson(poema);
    }

}
=======
    	String caracteresA = "áàãâäéèêëíìîïóòõôöúùûüçÁÀÃÂÄÉÈÊËÍÌÎÏÓÒÕÖÔÚÙÛÜÇ";
		String caracteresB = "aaaaaeeeeiiiiooooouuuucAAAAAEEEEIIIIOOOOOUUUUC";
    	String versificado = "de/ re/ pen/ te/ não/ mais/ que/ de/ re/ pen/ te";
    	Poema poema = new Poema("de repente nao mais que de repente", versificado);
    	Gson gson = new Gson();
    	return gson.toJson(poema);
    }

}
>>>>>>> branch 'emprogresso' of https://github.com/jpontesmartins/camus-versificacao.git
