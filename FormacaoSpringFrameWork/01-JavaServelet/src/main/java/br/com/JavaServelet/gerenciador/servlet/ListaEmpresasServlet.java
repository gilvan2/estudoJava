package br.com.JavaServelet.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JavaServelet.gerenciador.modelo.BancoDados;
import br.com.JavaServelet.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class ListaEmpresasServlet
 */
@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BancoDados banco = new BancoDados();
		List<Empresa> lista = banco.getEmpresas();
		
		//Atribuir um atributo a requisição
		request.setAttribute("empresas", lista);
		//Preparar a request para o endereço do JSP
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		//Despachar a requisição
		rd.forward(request,response);
		
	}
//http://localhost:8080/gerenciador/listaEmpresas

}
