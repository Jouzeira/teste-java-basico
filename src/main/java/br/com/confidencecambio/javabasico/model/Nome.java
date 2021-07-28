package br.com.confidencecambio.javabasico.model;

import org.springframework.util.Assert;

public class Nome {
	
public Nome(String nome) {
		super();
		Assert.notNull(nome, "Nome não pode ser nulo");
		Assert.hasText(nome, "Nome não pode ser vazio");
		
		if (nome.endsWith(" ") || nome.startsWith(" ")) {
			throw new IllegalArgumentException("Nome não pode conter espaços extras no início e no fim");
		}
		
		this.nome = nome.trim();
	}

private String nome;
	
	public String getNome() {
		return nome;
	}

	public String getPrimeiroNome() {
		return nome.split(" ")[0];
	}

	public String getUltimoNome() {
		return nome.replace(getPrimeiroNome() , "").trim();
	}

	public String getNomeMaiusculo() {
		return nome.toUpperCase();
	}

	public String getNomeAbreviado() {
		String[] nomes = nome.split(" ");
		if (nomes.length > 1) {
			String abreviado = "";
			boolean ignorarPrimeiro = true;
			for (String meio : nomes) {
				if (ignorarPrimeiro) {
					ignorarPrimeiro = false;
					continue;
				}
				abreviado = abreviado.concat(meio.substring(0,1).toUpperCase().concat(". "));
			}
			
			return nomes[0].concat(" ".concat(abreviado.substring(0,abreviado.length()-3).concat(nomes[nomes.length-1])));
		}else {
			return nome;
		}
		
	}

}
