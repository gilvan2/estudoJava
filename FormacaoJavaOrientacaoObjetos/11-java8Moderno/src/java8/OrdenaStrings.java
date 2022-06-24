package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {
		
		
		List<String> palavras = new ArrayList<String>();
		
		palavras.add("alura online");
		palavras.add("editora casa do código");
		palavras.add("caelum");
		
		//Collections.sort(palavras); //Forma anterior ao java 8 para ordenar listas, 
		//aqui ele faz a ordenação pelo comparação natural definida dentro da classe String
		
		//Definindo um comparador, visto na classe CompatadorPorTamanho onde será feito pelo tamanho da string
		Comparator<String> comparador = new CompatadorPorTamanho();
		palavras.sort(comparador); //Esse método sort é um default method, um método que tem corpo dentro de uma interface
		
		System.out.println(palavras);
		
		//Formas de iterar dentro de uma lista
		
		//for (String p : palavras) {
		//	System.out.println(p);
		//}
		
		//Agora no java 8 podemos definir o comportamento de um consumidor
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);

	}

}

class CompatadorPorTamanho implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length())
			return -1;
		if(s1.length() > s2.length())
			return 1;
		return 0;
	}
}

class ImprimeNaLinha implements Consumer<String>{

	@Override
	public void accept(String s) {
		System.out.println(s);	
	}
}
