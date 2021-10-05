/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import connection.ConnectionFactory;
import static connection.ConnectionFactory.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class OperacaoDAO {
    public static ArrayList selectIdProduto(){
        
         try{
        Connection con = getConnection(); 
        PreparedStatement stmt = con.prepareStatement("SELECT codigoProduto FROM produto");
        
        
        ResultSet resultSet = stmt.executeQuery();
        
        ArrayList produto = new ArrayList();
        while(resultSet.next()){
            produto.add(resultSet.getString(1));
        }
        return produto;
        
        } catch (SQLException ex) {
        Logger.getLogger(CorDAO.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
        
        
    }
    
    public static void create(Operacao e){
        
        try{
        Connection con = ConnectionFactory.getConnection(); 
        PreparedStatement stmt = null;
        
        stmt = con.prepareStatement("INSERT INTO operacao (codigoProduto,descOperacao,quantProduto,dataOperacao) VALUES (?,?,?,?)");
        
        stmt.setString(1,e.getCodigoProduto());
        stmt.setString(2,e.getDescOperacao());
        stmt.setInt(3,e.getQuantProduto());
        stmt.setString(4,e.getDataOperacao());
        
        stmt.execute();
        
    
        }
        catch(SQLException ex){
        Logger.getLogger(OperacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    
}
   public static void create(Operation s){
        
        try{
        Connection con = ConnectionFactory.getConnection(); 
        PreparedStatement stmt = null;
        
        stmt = con.prepareStatement("INSERT INTO operacao (codigoProduto,descOperacao,quantProduto,dataOperacao) VALUES (?,?,?,?)");
        
        stmt.setString(1,s.getCodigoProduto());
        stmt.setString(2,s.getDescOperacao());
        stmt.setInt(3,s.getQuantProduto());
        stmt.setString(4,s.getDataOperacao());
        
        stmt.execute();
        
    
        }
        catch(SQLException ex){
        Logger.getLogger(OperacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    
} 
    
}



