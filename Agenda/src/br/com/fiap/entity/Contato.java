package br.com.fiap.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Contato implements Serializable{
	
	private String nome;
	private String email;
	private List<String> telefones = new ArrayList<String>();
	private String endereco;
	
	
	public Contato() {
	}

	public Contato(String nome, String email, List<String> telefones,
			String endereco) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefones = telefones;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
