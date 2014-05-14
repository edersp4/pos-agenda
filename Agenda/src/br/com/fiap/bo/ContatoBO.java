package br.com.fiap.bo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import br.com.fiap.entity.Contato;

public class ContatoBO {
	
	public void criar(Contato contato){
		Contato novoContato = new Contato(contato.getNome(), contato.getEmail(), contato.getTelefones(), contato.getEndereco());
		gravarEmArquivo(novoContato , "Contatos.txt");
	}
	
	public static void gravarEmArquivo(Contato contato , String nomeArquivo){
		FileOutputStream output = null;
		PrintWriter print = null;

		try {
			output = new FileOutputStream(nomeArquivo , true);
			print = new PrintWriter(output);
			
			print.write(contato.getNome() + "*");
			print.write(contato.getEmail() + "*");
			print.write(contato.getEndereco() + "*");
			
			for (String tel : contato.getTelefones()) {
				print.write(tel + ">");
			}
			print.write("\r\n");
			print.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(output != null){
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if(print != null){
				print.close();
			}
		}
	}
	
	public void listarContato(){
		FileInputStream input = null;
		try {
			input = new FileInputStream("Contatos.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
