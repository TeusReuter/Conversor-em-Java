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
public class ListarDAO {
    
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
    
    // trabalhar aqui
  public static ArrayList<Operacao> Op(){
        
        try {
        Connection con = ConnectionFactory.getConnection(); 
        PreparedStatement stmt = null;
        
        stmt = con.prepareStatement("SELECT descOperacao FROM operacao WHERE");
        
        
        
       ResultSet result =  stmt.executeQuery();
       
       ArrayList op = new ArrayList();
       
       while(result.next()){
           Produto p = new Produto(); 
           p.setCodigoProduto(result.getString("codigoProduto"));
           p.setDescProduto(result.getString("descProduto"));
           op.add(p);
       }
       return op;
       
       
    } catch (SQLException ex) {
        Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        
    }finally{
        // ConnectionFactory.closeConnection(con, stmt);
    }
    }
    
}
