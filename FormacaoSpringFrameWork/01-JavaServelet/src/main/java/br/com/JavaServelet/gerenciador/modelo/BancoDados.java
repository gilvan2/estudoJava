package br.com.JavaServelet.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.List;

public class BancoDados { 

    private static List<Empresa> lista = new ArrayList<>();
    private static List<Usuario> listaUsuarios = new ArrayList<>();
    //Atributo q serve como um auto incremento para o modelo
    private static Integer chaveSequencial = 1;
    
    static{
    	
    	Empresa alura = new Empresa();
    	alura.setId(chaveSequencial++);
    	alura.setNome("Alura");
    	Empresa caelum = new Empresa();
    	caelum.setId(chaveSequencial++);
    	caelum.setNome("Caelum");
    	//Na hora de instanciar um valor estático da classe banco, o auto incremento foi adicionado na criação das empresas do modelo
    	
    	lista.add(caelum);
    	lista.add(alura);
    	
    	
    	Usuario u1 = new Usuario();
    	u1.setLogin("gilvan");
    	u1.setSenha("12345");
    	
    	Usuario u2 = new Usuario();
    	u2.setLogin("lindi");
    	u2.setSenha("12345");
    	
    	listaUsuarios.add(u1);
    	listaUsuarios.add(u2);
    			
    	/*
    	 * Trecho estatico para simular que o banco de dados já possui essas duas empresas cadastradas
    	 * 
    	 * */
    	
    }

    public void adiciona(Empresa empresa) {
    	//Método foi atualizado para realizar o auto incremento do ID
    	empresa.setId(BancoDados.chaveSequencial++);
    	BancoDados.lista.add(empresa);

    }
    
    public List<Empresa> getEmpresas(){
    	return BancoDados.lista;
    }
    
    public void removeEmpresa(Integer id) {
    	
    	
    	//Nessa forma, irá gerar um erro 500 no servidor por não podermos fazer um laço e modificar o mesmo laço enquanto
    	/*for (Empresa empresa: lista) {
    		if(empresa.getId() == id) {
    			lista.remove(empresa);
    		}
    	}*/
    	
    	Iterator<Empresa> it = lista.iterator();
    	
        while(it.hasNext()) { 
            Empresa emp = it.next();

            if(emp.getId() == id ) {
                it.remove();
            }
        }
    }
    
    public Empresa buscaEmpresaPelaId(Integer id) { 
        for (Empresa empresa: lista) { 
            if(empresa.getId() == id)  {
                return empresa;
            }

        }
        return null;
    }

	public Usuario existeUsuario(String login, String senha) {
		for(Usuario usuario : listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario; 
			}
		}
		return null;
	}
}
/*
 * Classe que simula um banco de dados, com atributos estáticos da classe
 * 
 * Com isso, não será criada uma lista de empresas toda vez que acontecer uma instancia de banco de dados, pelo fato de ser um atributa 
 * estático, existirá somente uma listagem de empresas pertencente a classe.
 * 
 * */
