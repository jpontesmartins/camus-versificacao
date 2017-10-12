package camus.lacan;

import java.util.ArrayList;
import java.util.List;

public class teste {
	
	
	public static void main(String[] args) {
		Fig figAlit = new Alit("aa",4);
		Fig figAnaf = new Anaf("bb","b");
		Fig figAntit = new Antit("cc","dd");
		
		List<Fig> figuras = new ArrayList<>();
		figuras.add(figAlit);
		figuras.add(figAnaf);
		figuras.add(figAntit);
		
		figuras.forEach(figura -> {
			System.out.println(figura.getTrecho());
			System.out.println(figura.getInfo());
			System.out.println("---");
			//figura.getInfo() ?
			//ai dentro de Fig, o método info é sobreescrito em cada um e mostra as informaçoes de cada um
			
//			System.out.println(figura.getTrecho());
//			if (figura.getInfo) {
//				System.out.println(((Alit) figura).getFrequencia());
//			}
//			if (figura.getClass().isInstance(Anaf.class)) {
//				System.out.println(((Anaf) figura).getTrechoRepetitivo());
//			}
//			if (figura.getClass().isInstance(Antit.class)) {
//				System.out.println(((Antit) figura).getAntonimo());
//			}
		});
		
		
		
		
	}

}
