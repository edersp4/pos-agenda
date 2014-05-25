package br.com.fiap.comparador;

import java.util.Comparator;

import br.com.fiap.entity.Contato;

/**
 * 
 * @author Ederson da Silva
 *
 */
public class ClassificaNome implements Comparator<Contato>{

	/**
	 * Classifica o contato pelo nome
	 */
	@Override
	public int compare(Contato contato1, Contato contato2) {
		return contato1.getNome().compareToIgnoreCase(contato2.getNome());
	}

}
