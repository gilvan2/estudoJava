package br.com.JavaServelet.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		System.out.println("Cadastrando no empresa");
		
		PrintWriter saida = response.getWriter();
		saida.println("<html><body>Empresa " + nome + " cnpj " + cnpj + " cadastrada com sucesso!</body></html>");
	}

}
/*
 * Servelet criado pelo wizar do eclipse
 * 
 * Passagem de parametros pela url exemplo -> http://localhost:8080/gerenciador/novaEmpresa?nome=Alura&cnpj=1234n
 * 
 * */
