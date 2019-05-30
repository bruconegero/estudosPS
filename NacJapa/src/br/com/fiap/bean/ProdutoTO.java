package br.com.fiap.bean;

import javax.xml.bind.annotation.XmlRootElement;

//classe para ser consumida como uma api restfull -- usar esta anotação
@XmlRootElement
public class ProdutoTO {

	private int codigo;
	private String nome;
	private double valor;
	private String dataValidade;
	private Unidade unidade;
	
	
	
	public ProdutoTO(String nome, double valor, String dataValidade, Unidade unidade) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.dataValidade = dataValidade;
		this.unidade = unidade;
	}
	public ProdutoTO() {
		super();
	}
	
	public ProdutoTO(int codigo, String nome, double valor, String dataValidade, Unidade unidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.dataValidade = dataValidade;
		this.unidade = unidade;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	
	
	
}
