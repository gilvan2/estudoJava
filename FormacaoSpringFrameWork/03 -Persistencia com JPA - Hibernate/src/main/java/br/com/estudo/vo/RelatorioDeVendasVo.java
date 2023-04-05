package br.com.estudo.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVo {
	
	private String nomeProduto;
	private Long quantidadeProduto;
	private LocalDate dataUltimaVenda;
	
	public RelatorioDeVendasVo(String nomeProduto, Long quantidadeProduto, LocalDate dataUltimaVenda) {
		
		this.nomeProduto = nomeProduto;
		this.quantidadeProduto = quantidadeProduto;
		this.dataUltimaVenda = dataUltimaVenda;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Long getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public LocalDate getDataUltimaVenda() {
		return dataUltimaVenda;
	}

	@Override
	public String toString() {
		return "RelatorioDeVendasVo [nomeProduto=" + nomeProduto + ", quantidadeProduto=" + quantidadeProduto
				+ ", dataUltimaVenda=" + dataUltimaVenda + "]";
	}
	
}
