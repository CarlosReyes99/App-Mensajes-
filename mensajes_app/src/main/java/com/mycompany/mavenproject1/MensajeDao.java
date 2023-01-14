/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author MrX
 */

public class MensajeDao {
    
    
    public static void crearMensaje(Mensaje mensaje){
       
        try {
            PreparedStatement ps= null;
            ConnectionToMysql cnt = ConnectionToMysql.getInstance();
            Connection connect = cnt.getConnection();
            String query= "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?, ?);";
            ps = connect.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, mensaje.getAutor_mensaje());
            ps.executeUpdate();
            System.out.println("mensaje creado");
           
        } catch (SQLException e) {
            System.out.println("mensaje no creado por: "+e);
        }
    }
    
    public static void leerMensaje(){
    
    }
    
    public static void borrarMensaje(int id_mensaje){
        
        
    }
    
    public static void actualizarMensajes(Mensaje mensaje){
    
    
    }
    
}
