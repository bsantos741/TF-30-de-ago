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
    public boolean adicionarVendedor( int id, String nome, double faturamento, String email){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Produto VALUES("+id+", '"+nome+"', "+faturamento+", '"+email+"')");
            
            System.out.println("Vendedor"+nome+" - id  "+id+ "adicionado(a)");
            return true;
            
        }catch(SQLException e){
            return false;
        }
    }
    public boolean DeletarVendedorId(int id){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("DELETE FROM Vendedor WHERE idvendedor ="+id+"");

            System.out.println("O vendedor de id "+id+" foi demitido devido a isso está sendo deletado do sistema.");
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    public boolean ConsultarEmaildoVendedor(String email){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT FROM Vendedor WHERE email = "+email);

            while (rs.next()) {
                Integer codigo = rs.getInt("idvendedor");
                String nome = rs.getString("nmvendedor");
                String email2 = rs.getString("email");

                System.out.println("O email "+codigo +" pertence ao vendedor "+nome+"| email: "+email2);
            }

            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    }
    
	
	
	

	
	

