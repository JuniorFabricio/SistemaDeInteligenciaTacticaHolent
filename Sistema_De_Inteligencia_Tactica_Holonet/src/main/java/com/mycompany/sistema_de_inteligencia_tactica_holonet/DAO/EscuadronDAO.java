/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sistema_de_inteligencia_tactica_holonet.DAO;

import com.mycompany.sistema_de_inteligencia_tactica_holonet.DTO.EscuadronDTO;
import java.util.List;

/**
 *
 * @author DAM2P
 */
public interface EscuadronDAO 
{
    
    void generarTablaSiNoExiste();
    
    void registrarEscuadron(EscuadronDTO escuadron);
    
    List<EscuadronDTO> obtenerTodos();
}
