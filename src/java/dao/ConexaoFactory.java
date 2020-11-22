/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// Essa Classe usa o padrão de projeto Factory (Fabrica)
public class ConexaoFactory {

    //  Database credentials
    
    public static Connection getConexao() throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        
        String drive = "com.mysql.jdbc.Driver";
        String banco = "jdbc:mysql://localhost:3306/testeimagem";
        String usuarioBD = "root";
        String senha = "";
        
        try { 
            Class.forName(drive);
            conn = DriverManager.getConnection(banco, usuarioBD, senha);
        } catch (SQLException | ClassNotFoundException e) { 
    		throw e; 
        } 
        return conn;
    }
    
}
