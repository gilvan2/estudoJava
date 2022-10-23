package br.com.JavaServelet.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
@WebFilter("/entrada")
public class AutorizacaoFilter extends HttpFilter implements Filter {
       

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("AutorizacaoFilter");
		
		//HttpServletRequest é um objeto mais especifico de uma interface ServletRequest ou seja HttpServletRequest é um ServletRequest e posso fazer casr entre eles   
		
		HttpServletRequest request = ( HttpServletRequest ) servletRequest; //Cast de um objet generico para mais um mais complexo do mesmo tipo
		HttpServletResponse response = ( HttpServletResponse ) servletResponse;
		
		String paramAcao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
		
		if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}


}


/*
 * Quando se usa anotaçãoes, não temos controle sobre a ordem de chamada o conteiner que decide isso, 
 * para ajustar essa ordem, o aquivo web.xml precisa ser ajustado
 * 
 * */
