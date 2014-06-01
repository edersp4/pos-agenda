package br.com.fiap.bo;

import java.util.List;
/**
 * 
 * @author Ederson da Silva
 *
 * @param <T> a classe que será utilizada para fazer as operações
 */
public interface GenericsBO <T>{
	
	/**
	 * Gera o arquivo txt
	 * @param objeto - o objeto que será gravado no txt
	 * @param nome - o nome do arquivo
	 */
	public abstract void gerarArquivo(T objeto , String nome);
	
	
	/**
	 * É utilizado para listar o objeto selecionado
	 * @return uma lista do objeto a ser listado
	 */
	public abstract List<T> listar();
	
	
	/**
	 * Pega os registros do txt e transforma em objeto
	 * @param linhas - São as linhas do txt
	 * @return o objeto
	 */
	public abstract List<T> transformarEmObjeto(List<String[]> linhas);
	
	
}
