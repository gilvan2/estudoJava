package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSemZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Gilvan", LocalDate.now(),new BigDecimal("25000")));
		
		assertEquals(new BigDecimal("0.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSer10PorCento() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Gilvan", LocalDate.now(),new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Gilvan", LocalDate.now(),new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}
	/*
	 No curso utilizaremos a versão 5 do JUnit, sendo que nesta nova versão da biblioteca algumas mudanças 
	 em seus pacotes de classes foram realizadas.No JUnit 4 as classes e anotações devem ser importadas de 
	 seu pacote org.junit. Por exemplo:
	 
	import org.junit.Test;
	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.After;
	import org.junit.AfterClass;
	
	Mas na versão 5 do JUnit houve uma reestruturação nos pacotes, sendo que agora os imports devem vir do pacote org.junit.jupiter.api. Exemplo:
	
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.BeforeAll;
	import org.junit.jupiter.api.AfterEach;
	import org.junit.jupiter.api.AfterAll;
	
	A única exceção foi a classe Assert, que permanece no pacote org.junit. 
	Entretanto, no JUnit 5 uma nova classe chamada Assertions, presente no pacote org.junit.jupiter.api, 
	foi criada e recomenda-se a sua utilização em substituição à antiga classe Assert.

	Redobre a atenção em seus projetos quando for realizar o import das classes e anotações do JUnit 5, 
	para que elas sejam importadas do pacote correto, pois, por questões de compatibilidade, 
	as classes antigas do JUnit 4 não foram removidas da bibliotecas e ainda podem ser utilizadas.
	*/
}