package Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Pessoa;

public class createPessoa {
private ConnnectionFactory connection;

public createPessoa(ConnnectionFactory connection){
    this.connection = connection;
}

public void createP(Pessoa p){
    try{
        String sql = "insert into pessoa (cpf,nome,rg,nascimento,nome_pai,noma_mae,telefone,celular,email,endereco,numero)"
                + "values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
        stmt.setString(1,p.getCpf());
        stmt.setString(2,p.getNome());
        stmt.setString(3,p.getRg());
        stmt.setString(4,p.getNascimento());
        stmt.setString(5,p.getNome_pai());
        stmt.setString(6,p.getNome_mae());
        stmt.setString(7,p.getTelefone());
        stmt.setString(8,p.getCelular());
        stmt.setString(9,p.getEmail());
        stmt.setString(10,p.getEndereco());
        stmt.setString(11,p.getNumero());
        stmt.execute();
        System.out.println("Pessoa cadastrada com sucesso !!");
    }catch(SQLException ex){
        System.err.println("erro ao cadastrar"+ex.getMessage());
    }catch(Exception ex){
        System.err.println("erro geral"+ex.getMessage());
    }
}
}
