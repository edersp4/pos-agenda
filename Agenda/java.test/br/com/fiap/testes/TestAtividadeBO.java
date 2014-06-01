package br.com.fiap.testes;

import org.junit.Test;

import br.com.fiap.entity.Atividade;
import br.com.fiap.interfaces.AtividadeInterface;

public class TestAtividadeBO {
	
	Atividade atividade;
	
	@Test
	public void teste(){
		AtividadeInterface inteface = new AtividadeInterface();
		inteface.iniciar();
	}

}
