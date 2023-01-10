/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

/**
 *
 * @author MrX
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Conexion cnx = new Conexion();
        try {
            
            cnx.get_connection();
        } catch (Exception e) {
            System.out.println("No se pudo completar la conexion");
        }
    }
}
