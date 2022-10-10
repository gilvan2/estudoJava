package br.com.JavaServelet.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JavaServelet.gerenciador.modelo.BancoDados;
import br.com.JavaServelet.gerenciador.modelo.Empresa;

public class MostraEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
		
		System.out.println("Mostrando dados da empresa pela classe MostraEmpresa");
		
		String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        
        BancoDados banco = new BancoDados();

        Empresa empresa = banco.buscaEmpresaPelaId(id);
        
        System.out.println(empresa.getNome());
		
        request.setAttribute("empresa", empresa);
        
        System.out.println("Antes do RequestDispatcher");

        RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
        rd.forward(request, response);
		
	}

}
