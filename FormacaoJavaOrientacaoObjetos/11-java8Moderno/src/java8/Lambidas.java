package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Lambidas {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();

		palavras.add("alura online");
		palavras.add("editora casa do código");
		palavras.add("caelum");

		/*
		 * Exemplo de classe anonima - Faz o mesmo que a classe ImprimeNaLinha no
		 * arquivo de OrdenarStrings
		 */
		/*
		 * Quando usar classes anonima? Quando é implementado interfaces muito curtas
		 * com 1 ou poucos métodos e quando não fomos reaproveitar esse código
		 */
		Consumer<String> consumidor = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}

		};
		palavras.forEach(consumidor);

		/*
		 * Ao invpes de definir uma variável temporária, podemos instanciar esse
		 * Consumer dentro de palavras.forEach(consumidor) como no exemplo a seguir
		 */

		palavras.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}

		});

		/*
		 * Nesses casos que só tem uma iunterface com um método que esta sendo
		 * implementado, a partir do java 8 podemos usar lambidas
		 */
		
		//----------------------------------------------------------------------------------------------------------------
		
		/*A mesma ideia com o comparator da do método sort*/
		palavras.sort((s1, s2) -> {

			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;
		});

		/*Podemos então usar o método compare de integer para fazer a mesma coisa da linha 58 a 65 de forma mais clara*/
		
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		palavras.sort(Comparator.comparing(String::length));//Method reference, uma forma de vc escrever lãmbida de forma enxuta e clara. Não é reflection
		
		Function<String, Integer> funcao = new Function<String, Integer>() {

			@Override
			public Integer apply(String s) {
				// TODO Auto-generated method stub
				return s.length();
			}
		};
		//s -> s.length();
		
		Comparator<String> comparador = Comparator.comparing(funcao);
		palavras.sort(comparador);
		
		//As ultimas 4 instruções fazem exatamente a mesma coisa. Repare que a variavél função pode receber tanto uma classe anonima, quanto um lâmbida s -> s.length()
		
		palavras.forEach(s -> System.out.println(s));
		
		//Com consumer
		Consumer<String> impressor = s-> System.out.println(s);
		palavras.forEach(impressor);
		
		Consumer<String> impressor2 = System.out::println;
		palavras.forEach(impressor2);
		
		//Os blocos anteriores fazem exatamente a mesma coisa, uma com lâmbida e outro com Method Reference
		
		
		
		
		
		
		
		/*As evoluções dessa classe vieram da classe OrdenarStrings*/
		
	}
}