/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Juansho
 */
public class BD {
    
    private static BD bd = null;
    private static String stServer = "127.0.0.1";
    private static String stPort = "3306";
    private static String stBase = "ProyectoMusica";
    private static String stUser = "root";
    private static String stClave = "";
    private Connection cnn;
    private Statement stmt;
    private ResultSet rs;
    
    private BD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://" + stServer +":" + stPort + "/" + stBase , stUser, stClave);
            stmt = cnn.createStatement();
        } catch (Exception ex) {
            //Log.rutea("Error BD Constructor " +ex.getMessage());
        }
    }
    public static void createInstance(){
        if (bd == null)bd = new BD();
    }
    public static  synchronized BD getInstance(){
        if (bd == null)createInstance();
        return bd;
    }
    public boolean sqlEjecutar(String sql){
        try {
            int resultado = stmt.executeUpdate(sql);
            if (resultado == 0) return false;
            return true;
        } catch (SQLException ex) {
            //Log.rutea("Error Ejecutar " +ex.getMessage() + "\n" + sql);
            return false;
        }
    }
    public boolean sqlSelect(String sql){
        try {
            rs = stmt.executeQuery(sql);
            return true;
        } 
        catch (Exception ex) {
            //Log.rutea("Error en sqlSelect... "+ex.getMessage());
            return false;
        }
    }
    
    public boolean sqlFetch(){
        try {return rs.next();} 
        catch (Exception ex) {
            //Log.rutea("Error en sqlFetch... "+ex.getMessage());
            return false;
        }
    }
    
    public String getString(String campo){
        try {return rs.getString(campo);} 
        catch (Exception ex) {
            //Log.rutea("Error en getString... "+ex.getMessage());
            return null;
        }
    }
    
    public int getInt(String campo){
        try {return rs.getInt(campo);} 
        catch (Exception ex) {
            return 0;
        }
    }
}
