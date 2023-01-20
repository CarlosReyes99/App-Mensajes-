/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *
 * @author MrX
 */
public class MensajeService {
    
    private static Mensaje[] mensajeLista;
    private  static Scanner sc= new Scanner(System.in);
    private static String msj = sc.nextLine();
    public static void recibirObjeto(Mensaje[] mensaje) {
        MensajeService.mensajeLista = mensaje;
    }
    public static void crearMensaje(){
        
        System.out.println("Escribe tu mensaje: ");
        String msj = sc.nextLine();
        System.out.println("Escribe al autor del mensaje:");
        String autorMsj= sc.nextLine();
        
        Mensaje mensaje = new Mensaje();
        
        mensaje.setMensaje(msj);
        mensaje.setAutor_mensaje(autorMsj);
        MensajeDao.crearMensaje(mensaje);
    
    }
    
    public static void listarMensaje(){
        MensajeDao.leerMensaje();
        for(int i= 0; i<mensajeLista.length;i++){
            System.out.println("ID MENSAJE: "+mensajeLista[i].getId_mensaje());
            System.out.println("MENSAJE: "+mensajeLista[i].getMensaje());
            System.out.println("AUTOR DE MENSAJE: "+mensajeLista[i].getAutor_mensaje());
            System.out.println("Fecha de mensaje: "+mensajeLista[i].getFecha_mensaje());
            
        }
    }
     public static void eliminarMensaje(){
        System.out.println("Escribe el ID del mensaje a eliminar: ");
        msj = sc.nextLine();
        MensajeDao.borrarMensaje(Integer.parseInt(msj));
         
    
    }
    
    public static void actualizarMensaje(){
        System.out.println("Escribe el ID del mensaje a actualizar: ");
        String idmsj = sc.nextLine();
        System.out.println("Escribe el mensaje: ");
        msj = sc.nextLine();
        
        Mensaje mensaje= new Mensaje();
        mensaje.setId_mensaje(Integer.parseInt(idmsj));
        mensaje.setMensaje(msj);
        MensajeDao.actualizarMensajes(mensaje);
    }
    
    
}
