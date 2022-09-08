package br.com.JavaServelet.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

public class BancoDados { 

    private static List<Empresa> lista = new ArrayList<>();
    
    static{
    	
    	Empresa alura = new Empresa();
    	alura.setNome("Alura");
    	Empresa caelum = new Empresa();
    	caelum.setNome("Caelum");
    	
    	lista.add(caelum);
    	lista.add(alura);
    	
    	/*
    	 * Trecho estatico para simular que o banco de dados já possui essas duas empresas cadastradas
    	 * 
    	 * */
    	
    }

    public void adiciona(Empresa empresa) {
    	BancoDados.lista.add(empresa);

    }
    
    public List<Empresa> getEmpresas(){
    	return BancoDados.lista;
    }
}
/*
 * Classe que simula um banco de dados, com atributos estáticos da classe
 * 
 * Com isso, não será criada uma lista de empresas toda vez que acontecer uma instancia de banco de dados, pelo fato de ser um atributa 
 * estático, existirá somente uma listagem de empresas pertencente a classe.
 * 
 * */
