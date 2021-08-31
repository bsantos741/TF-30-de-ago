package loja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Produto{
    private Connection conexao;
    public Produto(Connection conexao){
        this.conexao = conexao;

    }
    //Criar produto
    public boolean adicionarNovoProduto(int id , String nome, String categoria, double preco, int quantidade, int CodVendedor ){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Produto VALUES("+id+", '"+nome+"', '"+categoria+"', "+preco+", "+quantidade+" , "+CodVendedor+")");
            
            System.out.println("O produto "+nome+" - de ID: "+id+" adicionado(a)");
            return true;
           
        }catch(SQLException e){
            return false;
        }
    }
    public boolean consultaEstoqueId(int id){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Produto WHERE idproduto = "+id);

            while (rs.next()) {
                Integer codigo = rs.getInt("idproduto");
                String nome = rs.getString("nmproduto");
                Integer estoque = rs.getInt("qntestoque");
                Integer preco = rs.getInt("pcproduto");
                
                System.out.println( "O id "+codigo +" pertence ao produto "+nome+"| R$ "+preco+"| Estoque: "+estoque);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    public boolean pesquisarProduto(String produto){
        try {
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Produto WHERE nmproduto LIKE '%"+produto+"%'");

            while (rs.next()) {
                String nome = rs.getString("nmproduto");
                String preco = rs.getString("pcproduto");

                
                System.out.println("Encontrado o(s) produto(s): "+nome+"| R$"+preco);
                
                    
            }
            return true;
            
        }catch (SQLException e) {
            //throw new RuntimeException(e);
            return false;
        }
    }
    
    public boolean atualizarEstoque(int novaQuantidade, int id){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("UPDATE Produto SET QntEstoque ="+novaQuantidade+" WHERE idproduto ="+id+"");
            ResultSet rs = statement.executeQuery("SELECT * FROM Produto WHERE idproduto ="+id);
            
            while (rs.next()) {
                String nome = rs.getString("nmproduto");
                
            
            System.out.println("A quantidade do produto "+nome+ "| cod " +id+" foi alterada para "+novaQuantidade+" unidades");
            }
            return true;
            
        }catch(SQLException e){
            return false;
        }
    } 
    }