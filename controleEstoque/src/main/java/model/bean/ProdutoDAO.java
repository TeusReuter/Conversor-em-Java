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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class ProdutoDAO {
    
    public static void create(Produto p){
        
        try {
        Connection con = ConnectionFactory.getConnection(); 
        PreparedStatement stmt = null;
        
        stmt = con.prepareStatement("INSERT INTO produto (codigoProduto,descProduto,marcaProduto,precoProduto,corProduto) VALUES (?,?,?,?,?)");
        
        stmt.setString(1,p.getCodigoProduto());
        stmt.setString(2,p.getDescProduto());
        stmt.setString(3,p.getMarcaProduto());
        stmt.setDouble(4,p.getPrecoProduto());
        stmt.setString(5,p.getCorProduto());
        
        
        
        
        stmt.execute();
        
    } catch (SQLException ex) {
        Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        
    }finally{
        // ConnectionFactory.closeConnection(con, stmt);
    }
   }
    public static ArrayList<Produto> AllProduto(){
        
        try {
        Connection con = ConnectionFactory.getConnection(); 
        PreparedStatement stmt = null;
        
        stmt = con.prepareStatement("SELECT * FROM produto");
        
        
        
       ResultSet result =  stmt.executeQuery();
       
       ArrayList lista = new ArrayList();
       
       while(result.next()){
           Produto p = new Produto(); 
           p.setCodigoProduto(result.getString("codigoProduto"));
           p.setDescProduto(result.getString("descProduto"));
           lista.add(p);
       }
       return lista;
       
       
    } catch (SQLException ex) {
        Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        
    }finally{
        // ConnectionFactory.closeConnection(con, stmt);
    }
    }
    public static ArrayList selectDOE(){
        
        try {
        Connection con = getConnection(); 
        PreparedStatement stmt = con.prepareStatement("SELECT descOperacao FROM operacao");
        
        ResultSet resultSet = stmt.executeQuery();
        
        ArrayList desc = new ArrayList();
        while(resultSet.next()){
            desc.add(resultSet.getString(1));
        }
        
        return desc;
        
        //stmt.ResultSet(1,c.getCorProduto());
        //stmt.execute();
        } catch (SQLException ex) {
        Logger.getLogger(CorDAO.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
        
    }
    public static String selectDescProd(String codigo){
        
        try {
        Connection con = getConnection(); 
        PreparedStatement stmt = con.prepareStatement("SELECT descProduto FROM produto WHERE codigoProduto = ?");
        stmt.setString(1, codigo);
        
        ResultSet resultSet = stmt.executeQuery();
        resultSet.next();
        return resultSet.getString(1);
        
        
        
        //stmt.ResultSet(1,c.getCorProduto());
        //stmt.execute();
        } catch (SQLException ex) {
        Logger.getLogger(CorDAO.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
        
    }
    
    
    
    
    
}

