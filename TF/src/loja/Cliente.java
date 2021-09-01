package loja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cliente
{
    private int id;
    private String nome;
    private int cpf;
    private String Endereco;
    private String Tp;
    private Connection conexao;
    
    public Cliente(Connection conexao){
        this.conexao = conexao;

    }

public boolean adicionarNovoCliente(int id, String nome, String cpf, String endereco, String tipopagamento){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Cliente VALUES("+id+", '"+nome+"', '"+cpf+"' , '"+endereco+"', '"+tipopagamento+"')");
            
            System.out.println("O cliente  "+nome+" - cpf: "+cpf+ " foi adicionado(a)!");
            return true;
            
        }catch(SQLException e){
            return false;
        }
    }

public boolean consultaClienteId(int id){
    try{
        Statement statement = this.conexao.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Cliente WHERE idcliente = "+id);

        while (rs.next()) {
            Integer codigo = rs.getInt("idcliente");
            String nome = rs.getString("nmcliente");
            Integer cpf = rs.getInt("cpf");
            String endereco = rs.getString("endereco");
            
            System.out.println("O id "+codigo +" pertence ao cliente "+nome+"| "+cpf+"| Endereco: "+endereco);
        }
        
        return true;
    }catch(SQLException e){
        return false;
    }
}
 
        public boolean Efetuarcompra(int IDcliente,int IDproduto){
        	try{
                Statement statement = this.conexao.createStatement();
                statement.executeUpdate("INSERT INTO ClienteProduto VALUES("+IDcliente+" , "+IDproduto+")");
                
                ResultSet rs = statement.executeQuery("SELECT cliente.idcliente , cliente.nmcliente , produto.idproduto, produto.nmproduto, produto.pcproduto \n" + 
                		"FROM Cliente, Produto, ClienteProduto\n" + 
                		"WHERE cliente.idcliente = ClienteProduto.codcliente AND Produto.idproduto = ClienteProduto.codproduto AND cliente.idcliente = "+IDcliente+" AND "+IDproduto+" = produto.idproduto");                                   
                
                while (rs.next()) {
                    Integer codigocliente = rs.getInt("idcliente");
                    String nomecliente = rs.getString("nmcliente");
                    Integer codigoproduto = rs.getInt("idproduto");
                    String nomeproduto = rs.getString("nmproduto");
                    Double preco = rs.getDouble("pcproduto");
                    
                    System.out.println("Compra realizada com sucesso!");
                    System.out.println("IdCliente: "+codigocliente+" | NomeCliente: "+nomecliente+" |IdProduto: "+codigoproduto+" |NomeProduto: "+nomeproduto+" | Preço: R$ "+preco);
                }
                
                
                return true;
               
            }catch(SQLException e){
                return false;
            }
        }

        public boolean DeletarClienteId(int id){
            try{
            	Statement statement = this.conexao.createStatement();
                statement.executeUpdate("DELETE FROM Cliente WHERE idcliente ="+id+"");

                System.out.println("O cliente de id "+id+" foi deletado");
                return true;
            }catch(SQLException e){
                return false;
            }
        }
              	
}

