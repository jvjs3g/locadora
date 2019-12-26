package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.carro;

public class ConsultaCarroFiltro {
ConnnectionFactory connnectionFactory;

    public ConsultaCarroFiltro(ConnnectionFactory connnectionFactory) {
        this.connnectionFactory = connnectionFactory;
    }
    
    public List<carro> filtro(String marca){
        List<carro> car = new ArrayList<>();
        
        try{
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String sql = "select * from carro where marca like ?";
            stmt = connnectionFactory.getConnection().prepareStatement(sql);
            stmt.setString(1,"%"+marca+"%");
            rs = stmt.executeQuery();
            
           while(rs.next()){
            carro c = new carro();
            
            c.setId(rs.getInt("id"));
            c.setCor(rs.getString("cor"));
            c.setPlaca(rs.getString("placa"));
            c.setMarca(rs.getString("marca"));
            c.setPreco(rs.getFloat("preco"));
            c.setQuantidade(rs.getInt("quantidade"));
            c.setCompleto(rs.getString("completo"));
            car.add(c);
        }
        
        }
        catch(SQLException ex){
            System.out.println("erro ao consultar"+ex.getMessage());
        }
        catch(Exception ex){
            System.out.println("erro geral"+ex.getMessage());
        }
        
       return car;
    }


}
