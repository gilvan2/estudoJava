package br.com.JavaServelet.gerenciador.acao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JavaServelet.gerenciador.modelo.BancoDados;
import br.com.JavaServelet.gerenciador.modelo.Empresa;

public class NovaEmpresaForm implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Chamando o form para inserir uma nova empresa");
		
		return "forward:formNovaEmpresa.jsp";
	}

}
