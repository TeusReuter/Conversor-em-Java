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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class CorDAO {
    
    public static ArrayList selectIdCor(){
        
        try {
        Connection con = getConnection(); 
        PreparedStatement stmt = con.prepareStatement("SELECT corProduto FROM cor");
        
        
        ResultSet resultSet = stmt.executeQuery();
        
        ArrayList cor = new ArrayList();
        while(resultSet.next()){
            cor.add(resultSet.getString(1));
        }
        
        return cor;
        
        //stmt.ResultSet(1,c.getCorProduto());
        //stmt.execute();
        } catch (SQLException ex) {
        Logger.getLogger(CorDAO.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
        
    }
}
