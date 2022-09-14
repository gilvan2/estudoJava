package br.com.JavaServelet.gerenciador.servlet;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JavaServelet.gerenciador.acao.ListaEmpresas;


@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		if(paramAcao.equals("ListaEmpresa")) {
			
			ListaEmpresas le = new ListaEmpresas();
			le.executa(request, response);
			
		}else if(paramAcao.equals("RemoveEmpresa")) {
			System.out.println("Removendo empresas");
		}else if(paramAcao.equals("MostraEmpresa")) {
			System.out.println("Mostrando dados da empresa");
		}

	}

}
