package br.com.fiap.app;
import javax.swing.JOptionPane;

import br.com.fiap.bo.ContatoBO;
import br.com.fiap.entity.Contato;


public class CadastroContato {
	
	public static void main(String[] args) {
		
		Contato contato = new Contato();
		
		
		contato.setNome(JOptionPane.showInputDialog("Favor digite o nome do Contato"));
		contato.setEmail(JOptionPane.showInputDialog("Favor digite o email do Contato"));
		
		int yes = 0;
		do{
		 
			String telefone = JOptionPane.showInputDialog("Favor digitar o telefone");
			
			contato.getTelefones().add(telefone);
			
			yes = JOptionPane.showConfirmDialog(null, "Gostaria de inserir mais algum telefone");
			System.out.println(yes);
		 
		}while(yes == 0);
		
		
		contato.setEndereco(JOptionPane.showInputDialog("Favor Digitar o endere�o"));
		
		ContatoBO.gravarEmArquivo(contato, "Contato.txt");
		
	}
	
	
}
