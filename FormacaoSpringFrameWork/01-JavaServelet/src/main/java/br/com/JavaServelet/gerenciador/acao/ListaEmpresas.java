package br.com.JavaServelet.gerenciador.acao;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JavaServelet.gerenciador.modelo.BancoDados;
import br.com.JavaServelet.gerenciador.modelo.Empresa;

public class ListaEmpresas {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Listando empresas pela classe ListaEmpresas");
		
		BancoDados banco = new BancoDados();
		List<Empresa> lista = banco.getEmpresas();
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
        rd.forward(request, response);	
	}
}
