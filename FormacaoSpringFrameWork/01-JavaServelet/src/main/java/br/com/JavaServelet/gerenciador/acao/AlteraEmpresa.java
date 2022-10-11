package br.com.JavaServelet.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JavaServelet.gerenciador.modelo.BancoDados;
import br.com.JavaServelet.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
		
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        
        System.out.println("Alterando empresas pela classe AlteraEmpresa com ID " + id);
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		BancoDados banco = new BancoDados();
        Empresa empresa = banco.buscaEmpresaPelaId(id);
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);
        
        return "redirect:entrada?acao=ListaEmpresas";
		
	}

}
