package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.ProdutoTO;
import br.com.fiap.bean.Unidade;

public class ProdutoBO {
	//PROVA - MONTE OS MÉTODOS DO BO 
	
	
	//VAI FICAR O CRUD
	
	//ARRAY DE PRODUTOS
	private static final ArrayList<ProdutoTO> PRODUTOS = new ArrayList<ProdutoTO>();
	
	static {
		PRODUTOS.add(new ProdutoTO(1, "CLUBSOCIAL", 2.50, "05/2020", Unidade.GR));		
		PRODUTOS.add(new ProdutoTO(2, "TRAKINAS", 3.50, "05/2021", Unidade.KG));
		PRODUTOS.add(new ProdutoTO(-1, "Produto Inválido", 0, null, null));
		
	}
	
	//método para buscar o produto por código
	public ProdutoTO consultarProdutoPorCodigo(int codigo) {
		for (ProdutoTO produtoTO : PRODUTOS) {
			if(produtoTO.getCodigo()== codigo) {
				return produtoTO;
			}
		}
		return this.consultarProdutoPorCodigo(-1);
	}
	
	
	//método pra buscar e retornar todos os produtos 
	
	public List<ProdutoTO> buscar(){
		return PRODUTOS;
	}
	
	//método de cadastrar produto
	public void cadastrar(ProdutoTO produto) {
		PRODUTOS.add(produto);
	}
	
	//Método para atualizar produto
	public void atualizarProduto(ProdutoTO produto) {
		for (ProdutoTO produtoTO : PRODUTOS) {
			if(produtoTO.getCodigo() == produto.getCodigo()) {
				produtoTO.setNome(produto.getNome());
				produtoTO.setUnidade(produto.getUnidade());
				produtoTO.setDataValidade(produto.getDataValidade());
				produtoTO.setValor(produto.getValor());
			}
			
		}
	}
	
	//Método para excluir
	public void deletarProduto(int codigo) {
		for (int i = 0; i < PRODUTOS.size(); i++) {
			if(codigo == PRODUTOS.get(i).getCodigo()) {
				PRODUTOS.remove(i);
			}
			
		}
	}

}
