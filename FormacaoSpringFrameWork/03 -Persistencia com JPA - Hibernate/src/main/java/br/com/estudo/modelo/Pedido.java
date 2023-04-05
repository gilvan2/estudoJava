package br.com.estudo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "valor_total")//Transformando o nome da coluna no memso nome da coluna que esta no banco de dados
	private BigDecimal valorTotal = BigDecimal.ZERO;
	private LocalDate data = LocalDate.now();
	
	//Para relacionamentos xxxToOne, a JPA sempre ira criar os joins para carregar os registros também desse relacionamento default eaguer
	@ManyToOne(fetch = FetchType.LAZY) //Boa pratica, em carregamento toOne, mudar para carrgeamento LAZY
	private Cliente cliente;
	//Mapeamento biderecioanl, flag para evitar criação de tabela desnecessaria
	//Relacionamento xxxToMany é lazzy 
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) // cascade informa pra JPA que desejamos realizar a persistencia desse relacionamento estrangeiro junto com a entidade pedido
	private List<ItemPedido> itens = new ArrayList<>();

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void adicionarItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
		this.valorTotal = this.valorTotal.add(item.getValor());
		
		
	}

	public Pedido() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor_total() {
		return valorTotal;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valorTotal = valor_total;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

}
