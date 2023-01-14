/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MrX
 */
public class ConnectionToMysql {
    private static Connection connection;
    private static ConnectionToMysql instance;
    
    
    private ConnectionToMysql() {
    }
    public  Connection getConnection(){
       
    
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "");
            System.out.println("Conexion exitosa");
        } catch (SQLException e){
            System.out.println("falla en conexion: "+e);
        }
       return connection;
    }
    public void closeConnection() throws SQLException{
        try {
            connection.close();
            
        } catch (SQLException e){
            System.out.println("falla en conexion: "+e);
            connection.close();
        }finally{
        connection.close();
        }
        /*return connection;*/
    }
    
    
    //aplicando patron singleton
    public static ConnectionToMysql getInstance() throws SQLException{
        if (instance == null) {
            instance = new ConnectionToMysql();
        }
        return instance;
    }
    
    
}
