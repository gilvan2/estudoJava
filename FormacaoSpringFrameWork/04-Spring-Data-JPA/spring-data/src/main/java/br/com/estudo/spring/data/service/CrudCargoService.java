package br.com.estudo.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.estudo.spring.data.orm.Cargo;
import br.com.estudo.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	private final CargoRepository cargoRepository;
	
	public CrudCargoService(CargoRepository cargoRepository){
		this.cargoRepository = cargoRepository;
		
	}
	
	public void inicial(Scanner scanner){
		
		salvar(scanner);
		
	}
	
	private void salvar(Scanner scanner) {
		
		System.out.println("Descricao do Cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo");
	}

}