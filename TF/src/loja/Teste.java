package loja;

import loja.Conexao;
import loja.Produto;
import java.sql.Statement;
import java.sql.SQLException;

/* Desenvolvedores: Bruno Moroni, Everardo Antonio, Jessica de Freitas e Luiz Fernando
 * Objetivo:  apresentar um projeto de código que atenda as necessidades de uma loja virtual 
 * de produtos diversos. O código se baseia nas demandas do dia-a-dia de um comércio que precisa
 * ter controle sobre o estoque dos seus produtos, o tipo de cada e seu preço, além disso é 
 * necessário acompanhar da melhor maneira possível as suas vendas, observando qual foi o vendedor 
 * que executou a venda e quem é o cliente, e também é preciso identificá-los. Ao final das operações
 * de compra e venda se torna fundamental retornar o saldo em caixa e de estoque, a fim de observar 
 * se há lucro ou não e a disponibilidade dos produtos.
*/

public class Teste {
	public static void main(String args[])throws Exception{
		
		Conexao conexao = new Conexao();
        conexao.abrirConexao();
        
        
        Produto crud = new Produto(conexao.getConnection());
        
        //crud.adicionarNovoProduto(5, "Lapis", "Escritorio", 7.99, 1, 741); 
		
		//crud.consultaEstoqueId(1);
        
        //crud.pesquisarProduto("Livro");
        
        //crud.atualizarEstoque(2, 1);
        //a
        
		
        
        Cliente crud1 = new Cliente(conexao.getConnection());
        
        //crud1.consultaClienteId(321);
		
        //crud1.DeletarClienteId(377);
		
        Vendedor crud2 = new Vendedor(conexao.getConnection());
       // crud2.DeletarVendedorId(744);
		//crud2.ConsultarEmaildoVendedor("LeeSolar@gmail.com");
		
		
		
		
		
		
	}
}