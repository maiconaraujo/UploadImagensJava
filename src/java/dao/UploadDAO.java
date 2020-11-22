/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import model.Imagem;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author MAICON
 */
public class UploadDAO {
    public static void inserir(FileItem item) throws SQLException, ClassNotFoundException, IOException{
        
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        
        // Obtem conexao com BD
        conn = ConexaoFactory.getConexao();
        
        // Comando SQL 
        SQL = "INSERT INTO imagens (imagem) " +
                                     "VALUES (?)";

        preparedStatement = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setBinaryStream(1, item.getInputStream(),(int) item.getSize() );
        
        // Executa no BD        
        preparedStatement.executeUpdate();  
        
        // Fechar conexao
        conn.close();
        
    }    
    
    public ImageIcon  buscar(int codigo) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        ImageIcon imagem = null;       
        // Obtem conexao com BD
        conn = ConexaoFactory.getConexao();
        
        // Comando SQL 
        SQL = "SELECT * from imagens where codigo = ?";

        preparedStatement = conn.prepareStatement(SQL);

        preparedStatement.setInt(1, codigo);                
                
        // Para buscar informações
        rs = preparedStatement.executeQuery();   

        // Verifica se possui dados
         if (rs.next()) {

                Blob blob = (Blob) rs.getBlob("imagem");

                if (blob!=null){

                    imagem = new ImageIcon(blob.getBytes(1,(int) blob.length()));

                }

            }
        
        // Fechar conexao
        conn.close();
        
        return imagem;
    }     
    
public ArrayList<Imagem> listaImagens()throws Exception{
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        //ImageIcon imagem = null;       
        // Obtem conexao com BD
        ArrayList<Imagem>  lista = new ArrayList<>();
        Imagem img = null;
        
        conn = ConexaoFactory.getConexao();
        
        // Comando SQL 
        SQL = "SELECT * from imagens";

        preparedStatement = conn.prepareStatement(SQL);
          
          try {          
        // Para buscar informações
        rs = preparedStatement.executeQuery();   
      
            
            while (rs.next()) {
                img = new Imagem();
                img.setCodigo(rs.getInt("codigo"));
                img.setImagem(rs.getBytes("imagem"));
                lista.add(img);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }    
    
    
public Imagem getImagem(int codigo)throws Exception{
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        //ImageIcon imagem = null;       
        // Obtem conexao com BD
     
        Imagem img = null;
        
        conn = ConexaoFactory.getConexao();
        
        // Comando SQL 
        SQL = "SELECT * from imagens where codigo = ?";

        preparedStatement = conn.prepareStatement(SQL);
        preparedStatement.setInt(1, codigo);
        
        try{
        // Para buscar informações
        rs = preparedStatement.executeQuery();   
      
            
            if (rs.next()) {
                img = new Imagem();
                img.setCodigo(rs.getInt("codigo"));
                img.setImagem(rs.getBytes("imagem"));
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return img;
    }
    
}
