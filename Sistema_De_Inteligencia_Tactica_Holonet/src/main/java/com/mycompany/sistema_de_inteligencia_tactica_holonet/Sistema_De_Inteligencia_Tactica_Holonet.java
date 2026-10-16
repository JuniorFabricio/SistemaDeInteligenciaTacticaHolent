/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistema_de_inteligencia_tactica_holonet;

import com.mycompany.sistema_de_inteligencia_tactica_holonet.DAO.EscuadronDAO;
import com.mycompany.sistema_de_inteligencia_tactica_holonet.DAO.EscuadronDAOImpl;
import com.mycompany.sistema_de_inteligencia_tactica_holonet.DTO.EscuadronDTO;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DAM2P
 */
public class Sistema_De_Inteligencia_Tactica_Holonet {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        EscuadronDAO dao=new EscuadronDAOImpl();
        
        
        dao.generarTablaSiNoExiste();
        System.out.println("===================================================="); 
        
        
        do{
            System.out.println("\n--- SISTEMA DE INTELIGENCIA TÁCTICA HOLONET ---");
            System.out.println("1. Registrar un nuevo escuadron");
            System.out.println("2. Listadod de todos los escuadrones");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion=sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("\n ====Resgistro del nuevo escuadron====");
                    System.out.println("Introduce su ID");
                    String id=sc.nextLine();
                    System.out.println("Introduce su nombre");
                    String nombre=sc.nextLine();
                    System.out.println("Introduce sector base");
                    String sectorBase = sc.nextLine();
                    System.out.print("introduce numero de Cazas");
                    int numeroCazas = sc.nextInt();
                    sc.nextLine();
                  
                    dao.registrarEscuadron(new EscuadronDTO(id, nombre, sectorBase, numeroCazas));
                    System.out.println("===Se ha ingresado correctamente===");
                    break;
                case 2:
                   List<EscuadronDTO> escuadrones= dao.obtenerTodos();
                   
                    for (EscuadronDTO es : escuadrones) {
                            System.out.println(es);
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
            }
             
        
        }while(opcion!=0);
        
        
        
    }
}
