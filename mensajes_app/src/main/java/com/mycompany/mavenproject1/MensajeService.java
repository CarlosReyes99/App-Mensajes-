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
    
    public static Mensaje[] mensajeLista;
    
    public static void recibirObjeto(Mensaje[] mensaje) {
        MensajeService.mensajeLista = mensaje;
    }
    public static void crearMensaje(){
        Scanner sc= new Scanner(System.in);
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
    
    }
    
    public static void actualizarMensaje(){
    }
    
    
}
