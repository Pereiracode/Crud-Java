
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public Connection getConexao(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/escoladb?useTimezone=true&serverTimezone=UTC", "root", "123456");
        } catch(Exception e){
            throw new RuntimeException("Erro 1: " + e);
        }
    }
}
