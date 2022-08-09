package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
		
		BigDecimal percentual = desempenho.percentualReajuste();
		BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
		funcionario.reajustarSalario(reajuste);
	}
}
/*
 * Os antigos 		
 * 		if(desempenho == Desempenho.A_DESEJAR) {
			reajuste = funcionario.getSalario().multiply();
		}else if(desempenho == Desempenho.BOM){
			reajuste = funcionario.getSalario().multiply();
		}else if(desempenho == Desempenho.OTIMO){
			reajuste = funcionario.getSalario().multiply();
		}
 * 
 * Foram substituídos pela metodo percentualReajuste no ENUM, assim cada novo tipo de desenpenho será implementado no ENUM
 * 
 * */
