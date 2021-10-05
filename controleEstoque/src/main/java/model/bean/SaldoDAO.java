/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import connection.ConnectionFactory;
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
public class SaldoDAO {
    
      public static ArrayList<Saldo>AllSaldo(){
        
        try{
        Connection con = ConnectionFactory.getConnection(); 
        PreparedStatement stmt = null;
        
      //stmt = con.prepareStatement("SELECT((SELECT SUM(quantProduto) FROM operacao WHERE descOperacao = \"Entrada\" AND codigoProduto = 666) - (SELECT SUM(quantProduto) FROM operacao WHERE descOperacao = \"Saida\" AND codigoProduto = 666))");
        
      stmt = con.prepareStatement("SELECT P.codigoProduto AS codigoProduto, ((SELECT SUM(quantProduto) FROM operacao WHERE descOperacao = \"Entrada\" AND codigoProduto = P.codigoProduto) - (SELECT SUM(quantProduto) FROM operacao WHERE descOperacao = \"Saida\" AND codigoProduto = P.codigoProduto)) AS saldo FROM produto P");
      
      
      // trabalhar aqui
      
      ResultSet result =  stmt.executeQuery();
       
      ArrayList sal = new ArrayList();
        
        while(result.next()){
        Saldo s = new Saldo();
        s.setCodigoProduto(result.getString("codigoProduto"));
        s.setPegaSaldo(result.getInt("saldo"));
        sal.add(s);
        }
        return sal;
        //setCodigoProduto(result.getString("codigoProduto"));
        
        /*
        stmt.setString(1,e.getCodigoProduto());
        stmt.setString(2,e.getDescOperacao());
        stmt.setInt(3,e.getQuantProduto());
        stmt.setString(4,e.getDataOperacao());
        
        stmt.execute();
        */
    
        }
        catch(SQLException ex){
        Logger.getLogger(OperacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    return null;
}
    public static int selectPegaSaldo(String codigo){
     try{
        Connection con = ConnectionFactory.getConnection(); 
        PreparedStatement stmt = null;
    
      stmt = con.prepareStatement("SELECT (SELECT SUM(quantProduto) FROM operacao WHERE descOperacao = \"Entrada\" AND codigoProduto = "+codigo+") - (SELECT SUM(quantProduto) FROM operacao WHERE descOperacao = \"Saida\" AND codigoProduto = "+codigo+") ");
      
      
      // trabalhar aqui
      
      ResultSet result =  stmt.executeQuery();
       
       
        result.next();
        return result.getInt(1);
       
    
        }
        catch(SQLException ex){
        Logger.getLogger(OperacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    return 0;
    
    }
    
}
