/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MrX
 */

public class MensajeDao {
     public static List<Mensaje> mensajeArray= new ArrayList<>();
     
    
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
        try {
            PreparedStatement ps= null;
            ResultSet rs= null;
            
            ConnectionToMysql cnt = ConnectionToMysql.getInstance();
            Connection connect = cnt.getConnection();
            String query= "SELECT  * FROM mensajes;";
            ps = connect.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs= ps.executeQuery();
            rs.last();
            int rowCount= rs.getRow();
            System.out.println("filas: "+rowCount);
            
            //Array de objetos
            Mensaje[] mensajeLista = new Mensaje[rowCount];
           
            
            //Regresando resulset a su estado original
            rs.beforeFirst();
            
            
            //validando si existen resultados y llenando en caso de que hayan
            int i=0;
            while(rs.next()){
                //Llena array de objetos
                mensajeLista[i] = new Mensaje(rs.getInt("id_mensajes"), rs.getString("mensaje"), rs.getString("autor_mensaje"), rs.getString("fecha_mensaje"));
                i++;
            }
            //Mandando objeto(s) de tipo Mensaje a service 
            MensajeService.recibirObjeto(mensajeLista);
           
        } catch (SQLException e) {
            System.out.println("mensaje no creado por: "+e);
        }
    }
    
    public static void borrarMensaje(int id_mensaje){
        
        
    }
    
    public static void actualizarMensajes(Mensaje mensaje){
    
    
    }
    
}
