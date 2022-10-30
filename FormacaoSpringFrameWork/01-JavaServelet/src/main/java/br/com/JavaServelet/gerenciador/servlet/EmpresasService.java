package br.com.JavaServelet.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.JavaServelet.gerenciador.modelo.BancoDados;
import br.com.JavaServelet.gerenciador.modelo.Empresa;


@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Empresa> empresas = new BancoDados().getEmpresas();
		
		String tipoRetorno = request.getHeader("Accept");
	/*Através do Heard/accept da requisição, sabemos que tipo de documento retorna xml, json ou uma mensagem de sem conteúdo*/	
		if(tipoRetorno.contains("xml")) {//Fazendo a busca com contains
			System.out.println("XML");
			XStream xstream = new XStream();
			xstream.alias("Empresa", Empresa.class);
			String xml = xstream.toXML(empresas);
			
			response.setContentType("application/xml");
			response.getWriter().print(xml);
		}else if (tipoRetorno.endsWith("json")) {//Fazendo a busca com endsWith
			System.out.println("JSON");
			
			  Gson gson = new Gson(); String json = gson.toJson(empresas);
			  
			  response.setContentType("application/json");
			  response.getWriter().print(json);
			 
		}else {
			response.setContentType("application/json");
			  response.getWriter().print("{'message':'no content'}");
		}
	}
}
