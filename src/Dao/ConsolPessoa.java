package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pessoa;
import model.carro;

public class ConsolPessoa {
private ConnnectionFactory connnectionFactory;


public ConsolPessoa(ConnnectionFactory connnectionFactory){
    this.connnectionFactory = connnectionFactory;
}

 public List<Pessoa> read(){
        List<Pessoa> pessoa = new ArrayList<>();   
        
        try{
        PreparedStatement stmt  = null;
        ResultSet rs = null;
        stmt = connnectionFactory.getConnection().prepareStatement("select * from pessoa");
        rs = stmt.executeQuery();
     
        while(rs.next()){
            Pessoa p = new Pessoa();
            
            p.setId(rs.getInt("id"));
            p.setCpf(rs.getString("cpf"));
            p.setNome(rs.getString("nome"));
            p.setRg(rs.getString("rg"));
            p.setNascimento(rs.getString("nascimento"));
            p.setNome_pai(rs.getString("nome_pai"));
            p.setNome_mae(rs.getString("noma_mae"));
            p.setTelefone(rs.getString("telefone"));
            p.setCelular(rs.getString("celular"));
            p.setEmail(rs.getString("email"));
            p.setEndereco(rs.getString("endereco"));
            p.setNumero(rs.getString("numero"));
            pessoa.add(p);
        }
        
        }catch(SQLException ex){
            System.err.println("erro ao recuperar dados"+ex.getMessage());
        }catch(Exception ex){
            System.out.println("erro geral"+ex.getMessage());
        }finally{
            connnectionFactory.closeConnection();
        }
        
        return pessoa;
    }
}