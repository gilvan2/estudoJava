package br.com.JavaServelet.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JavaServelet.gerenciador.modelo.BancoDados;

public class RemoveEmpresa {
	
	public String executa(HttpServletRequest request, HttpServletResponse response ) throws IOException {
		
		System.out.println("Removendo empresas pela classe RemoveEmpresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println(id);
		
		BancoDados banco = new BancoDados();
		banco.removeEmpresa(id);
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}

}
