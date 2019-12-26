package Dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnnectionFactory {
private String hostname;
private int port;
private String username;
private String password;
private String database;
private Connection connection;


public ConnnectionFactory(){
    try{
        hostname = "localhost";
        username = "root";
        password = "";
        database = "locadora";
        port = 3306;
        String url = "jdbc:mysql://"+hostname+":"+port+"/"+database;
        DriverManager.deregisterDriver(new com.mysql.cj.jdbc.Driver());
        connection = DriverManager.getConnection(url,username,password);
        
        System.out.println("Deu certo !!");
        
    }
    catch(SQLException ex){
        System.err.println("erro nao conexao"+ex.getMessage());
    }
    catch(Exception ex){
        System.out.println("erro geral"+ex.getMessage());
     }
    
    }

    public Connection getConnection(){
        return this.connection;
    }
    
    public void closeConnection(){
        try{
            connection.close();
        }catch(SQLException ex){
            System.err.println("erro ao fechar");
        }
    }
}
