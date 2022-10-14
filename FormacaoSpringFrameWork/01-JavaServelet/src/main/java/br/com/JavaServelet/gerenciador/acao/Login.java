package br.com.JavaServelet.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.JavaServelet.gerenciador.modelo.BancoDados;
import br.com.JavaServelet.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println("Logando " + login);
		
		BancoDados banco = new BancoDados();
		Usuario usuario = banco.existeUsuario(login, senha);
		
		if(usuario != null) {
			System.out.println("Usuario existe");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		}else {
			return "redirect:entrada?acao=LoginForm";
		}
		
		
	}

}
