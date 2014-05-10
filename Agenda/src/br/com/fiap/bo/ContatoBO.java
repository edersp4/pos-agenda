package br.com.fiap.bo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import br.com.fiap.entity.Contato;

public class ContatoBO {
	
	public void criar(Contato contato){
		Contato novoContato = new Contato(contato.getNome(), contato.getEmail(), contato.getTelefones(), contato.getEndereco());
		gravarEmArquivo(novoContato , "Contatos.txt");
	}
	
	public void gravarEmArquivo(Contato contato , String nomeArquivo){
		
		FileOutputStream output = null;
		ObjectOutputStream contatoStream = null;
		
		try {
			output = new FileOutputStream(nomeArquivo);
			contatoStream = new ObjectOutputStream(output);
			contatoStream.writeObject(contato);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (output != null){
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (contatoStream != null) {
				try {
					contatoStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
