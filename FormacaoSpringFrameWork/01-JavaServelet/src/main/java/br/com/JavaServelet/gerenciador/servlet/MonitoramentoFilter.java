package br.com.JavaServelet.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/entrada") //Mapeado para chegar entes de entrada
public class MonitoramentoFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("MonitoramentoFilter");
		
		long inicio = System.currentTimeMillis();
		String acaoAtual = request.getParameter("acao");
		
		chain.doFilter(request, response); //Continua com a requisição
		
		long fim = System.currentTimeMillis();
		
		System.out.println("Tempo de execução da acao: " + acaoAtual + " -> " + ( fim - inicio ));
		
	}

}
