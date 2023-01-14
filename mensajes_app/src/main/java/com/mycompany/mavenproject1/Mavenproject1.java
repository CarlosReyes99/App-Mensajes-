/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MrX
 */
public class Mavenproject1 {

    public static void main(String[] args)  {
        
        
        //haciendo conexion con método singleton
        ConnectionToMysql cnt;
        
        try {
            cnt = ConnectionToMysql.getInstance();
            cnt.getConnection();
        } catch (SQLException e) {
            System.out.println("No se pudo completar la conexion");
        }
        
        //Entrada de datos con teclado
        Scanner sc= new Scanner(System.in);
        int opcion =0;
        
        //menu interactivo usuario
        do {            
            System.out.println("*****************");
            System.out.println("Aplicacion de mensajes");
            System.out.println("1.- Listar mensaje");
            System.out.println("2.- Crear mensaje");
            System.out.println("3.- Actualizar mensaje");
            System.out.println("4.- Eliminar mensaje");
            System.out.println("5.- Salir");
            
            opcion= sc.nextInt();
            
            switch (opcion) {
                case 1 -> MensajeService.listarMensaje();
                case 2 -> MensajeService.crearMensaje();
                case 3 -> MensajeService.actualizarMensaje();
                case 4 -> MensajeService.eliminarMensaje();
                default -> {
                }
            }
            
        } while (opcion != 5 );
        
        
        
    }
}
