package br.com.JavaServelet.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		//sessao.removeAttribute("usuarioLogado"); //Remove um atributo mas o cookie ainda existe
		sessao.invalidate();//Invalida a sessão e mata o cookie
		
		return "redirect:entrada?acao=LoginForm";
	}

}
