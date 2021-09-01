package loja;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Vendedor {
	private Connection conexao;
    public Vendedor (Connection conexao){
        this.conexao = conexao;
}
    public boolean adicionarVendedor( int id, String nome, String email){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Vendedor VALUES("+id+", '"+nome+"', '"+email+"')");
            
            System.out.println("O vendedor "+nome+" - id  "+id+ " foi adicionado(a)");
            return true;
            
        }catch(SQLException e){
            return false;
        }
    }
    public boolean deletarVendedorId(int id){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("DELETE FROM Vendedor WHERE idvendedor ="+id+"");

            System.out.println("O vendedor de id "+id+" foi demitido devido a isso está sendo deletado do sistema.");
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    public boolean consultarEmaildoVendedor(String email){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Vendedor WHERE email = '"+email+"'");

            while (rs.next()) {
                Integer codigo = rs.getInt("idvendedor");
                String nome = rs.getString("nmvendedor");
                String mail = rs.getString("email");

                System.out.println("O email pertence ao vendedor "+nome+"| Id: "+codigo+" email: "+mail);
            }

            return true;
        }catch(SQLException e){
            return false;
        }
    }
    public boolean consultarFaturamento(){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT idvendedor as Id, nmvendedor as Nome, categoria as Categoria,  \n" + 
            		"count(*) as ProdutosCadastrados, total (pcproduto*qntestoque) as Faturamento\n" + 
            		"FROM Produto, Vendedor\n" + 
            		"WHERE idvendedor = codVendedor\n" + 
            		"GROUP by idvendedor;");
            
            System.out.println("O Faturamento de todos vendedores distribuido por ID e categoria são: \n ");
           
            while (rs.next()) {
                Integer codigo = rs.getInt("Id");
                String nome = rs.getString("Nome");
                String categoria = rs.getString("Categoria");
                Integer cadastrados = rs.getInt("ProdutosCadastrados");
                Double preco = rs.getDouble("Faturamento");
                
                //System.out.println("O Faturamento de todos vendedores distribuido por ID e categoria são:");
                System.out.println("|Id: "+codigo+"| Nome do Vendedor: "+nome+" | Categoria: "+categoria+" | Produtos Cadastrados: "+cadastrados+" | R$ Faturamento Total: "+preco+" | \n");
                
                	
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    }
    
	
	
	

	
	

