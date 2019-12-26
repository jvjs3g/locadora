package Dao;

import java.util.List;
import model.carro;
import Dao.ConnnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ConsulCarro {
    private ConnnectionFactory connnectionFactory;
    
    public ConsulCarro(ConnnectionFactory connnectionFactory){
        this.connnectionFactory = connnectionFactory;
    }
    public List<carro> read(){
        List<carro> car = new ArrayList<>();   
        
        try{
        PreparedStatement stmt  = null;
        ResultSet rs = null;
        stmt = connnectionFactory.getConnection().prepareStatement("select * from carro");
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
        
        }catch(SQLException ex){
            System.err.println("erro ao recuperar dados"+ex.getMessage());
        }catch(Exception ex){
            System.out.println("erro geral"+ex.getMessage());
        }finally{
            connnectionFactory.closeConnection();
        }
        
        return car;
    }
}
