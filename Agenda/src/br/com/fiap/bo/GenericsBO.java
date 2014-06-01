package br.com.fiap.bo;

import java.util.List;
/**
 * 
 * @author Ederson da Silva
 *
 * @param <T> a classe que ser� utilizada para fazer as opera��es
 */
public interface GenericsBO <T>{
	
	/**
	 * Gera o arquivo txt
	 * @param objeto - o objeto que ser� gravado no txt
	 * @param nome - o nome do arquivo
	 */
	public abstract void gerarArquivo(T objeto , String nome);
	
	
	/**
	 * � utilizado para listar o objeto selecionado
	 * @return uma lista do objeto a ser listado
	 */
	public abstract List<T> listar();
	
	
	/**
	 * Pega os registros do txt e transforma em objeto
	 * @param linhas - S�o as linhas do txt
	 * @return o objeto
	 */
	public abstract List<T> transformarEmObjeto(List<String[]> linhas);
	
	
}
