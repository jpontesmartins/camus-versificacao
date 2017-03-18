package versificacao;

import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class EscansaoController {

    @RequestMapping("/versificar")
    public String versificar(@RequestParam String poemaTexto) {
    	System.out.println(poemaTexto);
    	String versificado = "de/ re/ pen/ te/ não/ mais/ que/ de/ re/ pen/ te";
    	Poema poema = new Poema("de repente não mais que de repente", versificado);
    	Gson gson = new Gson();
    	return gson.toJson(poema);
    }

}