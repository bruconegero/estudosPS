package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bean.ProdutoTO;
import br.com.fiap.bo.ProdutoBO;

//anotacao serve para mapear classe para api
@Path("/produto")
public class ProdutoResource {
	
	private ProdutoBO bo = new ProdutoBO();
	
	//MÉTODO PARAR RETORNAR TODOS OS PRODUTOS(ProdutoTO)
	/**retorna todo os @link{ProdutoTO} */
	
	//anotação Produces(buscar) ou Consumes(cadastrar, atualizar) 
	//- o excluir nao vai anotação
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoTO> buscar(){
		return bo.buscar();
	}
	
	//anotação path em cima do metodo serve para passar parametro
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public ProdutoTO buscarProCodigo(@PathParam("id")int codigo) {
		return bo.consultarProdutoPorCodigo(codigo);
	}
	
	@DELETE
	@Path("/{id}")
	public void deletar(@PathParam("id") int codigo) {
		bo.deletarProduto(codigo);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	//URI informação e indentificador do produto
	public Response cadastrar(ProdutoTO produto, @Context UriInfo uriInfo) {
		bo.cadastrar(produto);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(produto.getCodigo()));
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(ProdutoTO produto, @PathParam("id") int codigo) {
		produto.setCodigo(codigo);
		//chamando o bo
		bo.atualizarProduto(produto);
		return Response.ok().build();
	}
	
}
