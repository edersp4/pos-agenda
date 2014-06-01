package br.com.fiap.enun;

/**
 * 
 * @author Ederson da Silva
 * Foi usado para listar as operações e seus códigos
 */
public enum AcaoEnum {
		SAIR(0),GRAVAR(1),LISTAR(2),PESQUISAR(3),CLASSIFICAR(4);
	
		private int codigo;
		
		private AcaoEnum(int codigo) {
			this.codigo = codigo;
		}
		
		public static AcaoEnum getEnumPeloCodigo(int codigo){
			for (AcaoEnum acao : values()) {
				if(acao.codigo == codigo )
					return acao;
			}
			return null;
		}
}
