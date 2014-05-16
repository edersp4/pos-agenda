package br.com.fiap.bo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		FileReader read = null;
		BufferedReader leitor = null;
		String linha = "";
		List<String[]> componentesContatos = new ArrayList<String[]>();
		try {
			read = new FileReader("Contato.txt");
			leitor = new BufferedReader(read);
			
			if(new File("C:/Users/usuario/Documents/GitHub/pos-agenda/Agenda/Contato.txt").isFile()){
				System.out.println("Lendo arquivo ...");
				while ((linha = leitor.readLine()) != null) {
					String[]contato = linha.split("\\*");
					
					componentesContatos.add(contato);
					
					contato = null;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		transformarEmObjeto(componentesContatos);
		
	}
	
	public void transformarEmObjeto(List<String[]> contatos){
		
		List<Contato>lista = new ArrayList<Contato>();
		
		for (String[] cont : contatos) {
			Contato contato = new Contato();
			
			contato.setNome(cont[0]);
			contato.setEmail(cont[1]);
			contato.setEndereco(cont[2]);
			
//			TODO fazer a implementa��o para o telefone que � uma lista
			
			lista.add(contato);
		}
		for (Contato contato : lista) {
			System.out.println(contato);
		}
	}
	
}
