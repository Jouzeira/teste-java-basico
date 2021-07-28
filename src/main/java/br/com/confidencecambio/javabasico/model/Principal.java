package br.com.confidencecambio.javabasico.model;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

		List<Nome> dados = new ArrayList<Nome>();
		dados.add(new Cliente("João Soares Silva"));
		dados.add(new Gerente("Joseph Antonio Isbir Filho"));
		dados.add(new Robo("Robo"));
		
		for (Nome nome : dados) {
			System.out.println(nome.getPrimeiroNome());
			System.out.println(nome.getUltimoNome());
			System.out.println(nome.getNomeAbreviado());
			System.out.println(nome.getNomeMaiusculo());
		}
	}

}
