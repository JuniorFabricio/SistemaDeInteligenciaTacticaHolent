/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_inteligencia_tactica_holonet.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DAM2P
 */
public class ConexionDB {
    private final String url;
    private final String user;
    private final String password;

   
    public ConexionDB(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    
    
    
    
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
}
