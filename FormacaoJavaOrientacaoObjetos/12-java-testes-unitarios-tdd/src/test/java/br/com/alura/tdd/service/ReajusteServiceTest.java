package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
	
	@Test
	public void reajusteDeveriaSerDe01TresPorcentoQuandoDesempenhoForADesejar() {
		
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Gilvan",LocalDate.now(), new BigDecimal("1000"));
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
		
	}
	
	@Test
	public void reajusteDeveriaSerDe02QuinzePorcentoQuandoDesempenhoForBom() {
		
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Gilvan",LocalDate.now(), new BigDecimal("1000"));
		service.concederReajuste(funcionario, Desempenho.BOM);
		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
		
	}
	
	@Test
	public void reajusteDeveriaSerDe03VintePorcentoQuandoDesempenhoForOtimo() {
		
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Gilvan",LocalDate.now(), new BigDecimal("1000"));
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
		
	}

}
/*
 Deve ser implementada uma classe caucule o reajuste anual do funcinário orientada testes para os seguintes cenários: 
 
 	Se o desempenho for classificado como "A desejar", o reajuste será de 3% do salário atual.
	Se o desempenho for "Bom,", o reajuste será de 15% do salário.
	Se o desempenho for "Ótimo", o reajuste será de 20% do salário.
	
	implementação:
	Criada uma classe ReajusteServiceTeste
	Implementado o método reajusteDeveriaSerDe01TresPorcentoQuandoDesempenhoForADesejar
	Criado um modelo de objeto ReajusteService 
	Instanciado um objeto Funcionario
	Criado um modelo de método concederReajuste do modelo ReajusteService
	criado uma acertiva com um valor conhecido 
	Criada a classe ReajusteService no pacote java 
	Criado o método concederReajuste
	Criado o ENUM Desempenho
	Criada a constante A_DESEJAR
	
	Implementação em ReajusteService
	Analise da condição A_DESEJAR
	criado um modelo de método reajustarSalario para a classe funcoinario
	
	Implementação em funcionario
	Criado o método reajustarSalario
	
 * */
