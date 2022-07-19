package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Cursos{
	
	private String nome;
	private int alunos;
	
	public Cursos(String nome, int alunos) {
		
		this.nome = nome;
		this.alunos = alunos;
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getAlunos() {
		return alunos;
	}
}

public class ExemploCursos {
	public static void main(String[] args) {
		List<Cursos> cursos = new ArrayList<Cursos>();
		cursos.add(new Cursos("Pyton",45));
		cursos.add(new Cursos("JavaScript",150));
		cursos.add(new Cursos("Java",113));
		cursos.add(new Cursos("C",55));
		
		//As duas instruções fazem exatamente a mesma coisa
		cursos.sort(Comparator.comparing(Cursos::getAlunos));
		cursos.forEach(c -> System.out.println(c.getAlunos()));
		
		//Por ser um stream, a coleção original não sofre alteração
		cursos.stream().filter(c -> c.getAlunos() >= 100)
						.map(Cursos::getAlunos)
						.forEach(System.out::println);
		
		//Podemos usar o maps especifico para a tipagem do dado. 
		//A vantagem de trabalhar assim, é que o map tem métodos especificos para trabalhar com aquele tipo de dado.
		
		int sum = cursos.stream().filter(c -> c.getAlunos() >= 100)
		.mapToInt(Cursos::getAlunos)
		.sum();
		
		System.out.println(sum);
		
		/*Continuando trabalahndo com streams*/
		/*Lendo antes da variavel optional, esta acontecendo o seguinte:
		 * Atravez dessa lista de cursos, pegamos um fluxo de bites por meio da interface stream. cCom esse stream, é possível fazer um filtro que 
		 * usa ul lambda. Para cada curso c, procurar todos os cursos que satisfaça a condição para em seguida, encontrar algum
		 * 
		 *  Note, que esse estream pode ter resultado ou não e por essa razão, usamos essa variavél do tipo Optional. Ele serve para trabalhar com 
		 *  resultados nulos, além de apresentar uma série de métodos para tratar esse tipo de dado*/
		Optional<Cursos> optional = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.findAny();
		
		//Aqui podemos por exemplo pegar o elemento, mas caso o elemento não exista, sera lançada uma exceção
		Cursos optionalCursos = optional.get();
		
		//Aqui podempos indicar uma ação para caso o elemento seja nulo
		optionalCursos = optional.orElse(null);
		
		//Aqui uma ação. Caso o (s) elemtnto (s) seja encontrado, faça alguma ação
		optional.ifPresent(c -> System.out.println(c.getNome()));
		
		
		//Aqui já temos uma forma mais comum de ser encontrada no dia a dia. Com esse stream, faça um filtro, encontre algum elemento e se esse elemto existor, faça tal ação
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.findAny()
			.ifPresent(c -> System.out.println(c.getNome()));
		
		//É possível gerar uma coleção através de uma stream?
		/*Como já foi demonstrado, uma stream não altera a coleção original, então, o resultado de uma stream é outra stream a não se...
		 * Utilizarmos o método Collect */
		
		List<Cursos> resultados = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .collect(Collectors.toList());
		
		//Assim como...
		
		cursos = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.collect(Collectors.toList());
		
		//Nesse ponto, o atualizamos a lista inicial com um filtro. Alteramos a referência antiga para apontar para essa nova coleção, depois de filtrada
		
		//Conseguimos gerar mapas também?
		/*
		 * Um exemplo mais complicado? Podemos gerar mapas! Queremos um mapa que, dado o nome do curso, o valor atrelado é a quantidade alunos. Um Map<String, Integer>. 
		 * Utilizamos o Collectors.toMap. Ele recebe duas Functions. A primeira indica o que vai ser a chave, e a segunda o que será o valor:
		 * */
		
		Map map = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.collect(Collectors.toMap(c -> c.getNome(), c-> c.getAlunos()));
		
		//Calculando a média de alunos de todos os cursos utilizando a API de stream
		cursos.stream().mapToInt(c -> c.getAlunos())
		.average();
		
		
		List<Cursos> lista = cursos.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toList());
		
		
	}
}
