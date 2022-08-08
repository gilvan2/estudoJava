package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
		
		BigDecimal reajuste = null;
		
		if(desempenho == Desempenho.A_DESEJAR) {
			reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
		}else if(desempenho == Desempenho.BOM){
			reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
		}else if(desempenho == Desempenho.OTIMO){
			reajuste = funcionario.getSalario().multiply(new BigDecimal("0.20"));
		}
		funcionario.reajustarSalario(reajuste);
	}
}
