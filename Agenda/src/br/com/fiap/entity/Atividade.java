package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;

public class Atividade implements Serializable{
	private Date inicio;
	private Date fim;
	private String nome;
	private String local;
	
	

	public Atividade(Date inicio, Date fim, String nome, String local) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		this.nome = nome;
		this.local = local;
	}
	public Atividade() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
}
