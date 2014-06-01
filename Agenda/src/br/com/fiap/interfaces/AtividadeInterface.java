package br.com.fiap.interfaces;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.bo.AtividadeBO;
import br.com.fiap.bo.GenericsBO;
import br.com.fiap.entity.Atividade;

public class AtividadeInterface extends Thread {
	
	GenericsBO<Atividade> atividadeBO = new AtividadeBO();
	
	public void iniciar(){
		
		int acao = 0;
		
		do {
			try {
				acao = Integer.parseInt(JOptionPane.showInputDialog("Por favor digite:\n 0- para Sair;\n 1-Para gravar Atividade\n 2 Para listar Atividade; "));
			} catch (NumberFormatException e) {
				acao = 0;
			}
			
			switch (acao) {
			case 1:
				cadastrar();
				break;
			case 2:
				listarAtividade();
				break;
			default:
				break;
			}
		} while (acao != 0);
		
	}

	@Override
	public void run() {
		iniciar();
	}

	private void listarAtividade() {
		StringBuilder mensagem = new StringBuilder();
		
		List<Atividade> atividades = atividadeBO.listar();
		
		if (atividades != null && atividades.size() != 0) {
			for(Atividade lista : atividades){
				mensagem.append("Atividade: "+ lista.getNome()+"\n");
				mensagem.append("Local: "+ lista.getLocal()+"\n");
				mensagem.append("Inicio: "+ lista.getNome()+"\n");
				mensagem.append("Final: "+ lista.getNome()+"\n\n");
			}
		}else{
			mensagem.append("N�o existem atividades programadas!");
		}
		JOptionPane.showMessageDialog(null, mensagem);
		
	}

	private void cadastrar() {
		
		Atividade atv = new Atividade();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		atv.setNome(JOptionPane.showInputDialog("Digite o Nome da Atividade:"));
		atv.setLocal(JOptionPane.showInputDialog("Digite o Local:"));
		try {
			atv.setInicio(sdf.parse(JOptionPane.showInputDialog("Digite uma data para inicio da atividade no formato dd/MM/aaaa:")));
			atv.setFim(sdf.parse(JOptionPane.showInputDialog("Digite uma data para final da atividade no formato dd/MM/aaaa:")));
			
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		atividadeBO.gerarArquivo(atv, "Atividades.txt");
		
	}

}
