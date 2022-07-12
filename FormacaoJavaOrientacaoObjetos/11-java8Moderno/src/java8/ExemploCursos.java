package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
		
	}
}
