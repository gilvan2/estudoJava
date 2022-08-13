package br.com.JavaServelet.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//oi
@WebServlet(urlPatterns = "/oi")
public class OiMundoServelet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
        PrintWriter saida = resp.getWriter();
        saida.println("<html>");
        saida.println("<body>");
        saida.println("oi mundo servlet.");
        saida.println("</body>");
        saida.println("</html>");
        
        System.out.println("o servlet OiMundoServlet foi chamado");
		
	}
}

/*
 * Essa primeira classe é o modelo padrão de um servlet (O nome Servlet no nome da classe ( OiMundoServelet ) não é obrigatório)
 * Essa classe foi extendida da classe HttpServlet, o método service foi sobreescreito e as ServletException, IOException foram removidas
 * Foi adicionada a anotação @WebServlet(urlPatterns = "/oi"), para fornecer uma alias na hora de chamar a classe pelo navegador  
 * Foi criado um objeto saida do tipo PrintWriter que recebe a resposta HttpServletResponse
 * Desse objeto saída, utilizamos o método println que irá interagir com o navegador 
 * 
 * */
 