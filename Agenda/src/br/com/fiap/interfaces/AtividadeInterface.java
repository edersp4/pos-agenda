package br.com.fiap.interfaces;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import br.com.fiap.bo.AtividadeBO;
import br.com.fiap.bo.GenericsBO;
import br.com.fiap.entity.Atividade;
import br.com.fiap.enun.AcaoEnum;

public class AtividadeInterface extends Thread {
	
	GenericsBO<Atividade> atividadeBO = new AtividadeBO();
	Logger logger = Logger.getLogger(AtividadeInterface.class.getName());

	/**
	 * Inicia a interface de gerenciamento de atividades
	 */
	public void iniciar(){
		
		int acao = 0;
		AcaoEnum acaoEnum = null;
		do {
			try {
				acao = Integer.parseInt(JOptionPane.showInputDialog("Por favor digite:\n 0- para Sair;\n 1-Para gravar Atividade\n 2 Para listar Atividade; "));
			} catch (NumberFormatException e) {
				acao = 0;
			}
			
			acaoEnum = AcaoEnum.getEnumPeloCodigo(acao);
			switch (acaoEnum) {
			case GRAVAR:
				cadastrar();
				break;
			case LISTAR:
				listarAtividade();
				break;
			default:
				break;
			}
		} while (acaoEnum != AcaoEnum.SAIR);
		logger.info("Aplica��o encerrada");
	}

	@Override
	public void run() {
		iniciar();
	}

	/**
	 * Lista as atividades existentes no arquivo .txt
	 */
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
			logger.warning(mensagem.toString());
		}
		JOptionPane.showMessageDialog(null, mensagem);
		
		
	}

	/**
	 * captura as informacoes inseridas pelo usu�rio e adiciona ao arquivo .txt
	 */
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
