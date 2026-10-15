/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistema_de_inteligencia_tactica_holonet;

import com.mycompany.sistema_de_inteligencia_tactica_holonet.DAO.EscuadronDAO;
import com.mycompany.sistema_de_inteligencia_tactica_holonet.DAO.EscuadronDAOImpl;
import java.util.Scanner;

/**
 *
 * @author DAM2P
 */
public class Sistema_De_Inteligencia_Tactica_Holonet {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        EscuadronDAO dao=new EscuadronDAOImpl();
        
        
        dao.generarTablaSiNoExiste();
        System.out.println("====================================================");
        
        
        
    }
}
