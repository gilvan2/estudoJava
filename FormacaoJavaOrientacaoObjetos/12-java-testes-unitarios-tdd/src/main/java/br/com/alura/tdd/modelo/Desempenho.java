package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
	A_DESEJAR {
		@Override
		public BigDecimal percentualReajuste() {
			return new BigDecimal("0.03");
		}
	}, 
	BOM {
		@Override
		public BigDecimal percentualReajuste() {
			return new BigDecimal("0.15");
		}
	}, 
	OTIMO {
		@Override
		public BigDecimal percentualReajuste() {
			return new BigDecimal("0.20");
			
		}
	};
	
	public abstract BigDecimal percentualReajuste();
	//Por que usar um método abstract? Porque, com um método abstrato, cada constante é obrigada a fornecer uma implementação.

}
/*
 * Foi criado um metodo abstract que obriga a implementar o retorno de cada novo ENUM 
 * */
