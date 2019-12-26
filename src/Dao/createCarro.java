package Dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.carro;
public class createCarro {

    private ConnnectionFactory connnectionFactory;
    
    public createCarro(ConnnectionFactory connectionFactory){
        this.connnectionFactory = connectionFactory;
    }
   
    public void create(carro c){
        try{
            String sql = "insert into carro(cor,placa,marca,preco,quantidade,completo) values(?,?,?,?,?,?)";
            PreparedStatement stmt = connnectionFactory.getConnection().prepareStatement(sql);            
            stmt.setString(1,c.getCor());
            stmt.setString(2,c.getPlaca());
            stmt.setString(3,c.getMarca());
            stmt.setFloat(4,c.getPreco());
            stmt.setInt(5,c.getQuantidade());
            stmt.setString(6,c.getCompleto());
            stmt.execute();
            
            System.out.println("dados salvos com sucesso !!");
        }catch(SQLException ex){
            System.err.println("erro ao cadastar"+ex.getMessage());
        }catch(Exception ex){
            System.out.println("erro geral"+ex.getMessage());
        }
    }
}
