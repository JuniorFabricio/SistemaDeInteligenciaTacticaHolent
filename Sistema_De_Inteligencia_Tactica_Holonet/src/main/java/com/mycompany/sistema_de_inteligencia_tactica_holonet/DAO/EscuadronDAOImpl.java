/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_inteligencia_tactica_holonet.DAO;

import com.mycompany.sistema_de_inteligencia_tactica_holonet.DTO.EscuadronDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAM2P
 */
public class EscuadronDAOImpl implements EscuadronDAO {

    private final ConexionDB conexionDB = new ConexionDB("jdbc:postgresql://localhost:5432/imperio_db", "openpg", "openpgpwd");

    @Override
    public void generarTablaSiNoExiste() {
        String sql = """
    CREATE TABLE IF NOT EXISTS escuadrones_imperiales (
        id_escuadron VARCHAR(50) PRIMARY KEY,
        nombre VARCHAR(100) NOT NULL,
        sector_base VARCHAR(150) NOT NULL,
        numero_cazas INT NOT NULL
    );
    """;

        try (Connection conn = conexionDB.conectar(); PreparedStatement st = conn.prepareCall(sql)) {

            st.execute(sql);
            System.out.println(" Tabla ya esta creada y lista para usar");

        } catch (SQLException e) {
            System.err.println("Problema a la hora de crear la tabla o no existe " + e.getMessage());
        }
    }

    @Override
    public void registrarEscuadron(EscuadronDTO escuadron) {
        String sql = """
        INSERT INTO escuadrones_imperiales (
            id_escuadron, 
            nombre, 
            sector_base, 
            numero_cazas
        ) VALUES (?, ?, ?, ?);
        """;

        try (Connection conn = conexionDB.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, escuadron.getIdEscuadron());
            ps.setString(2, escuadron.getNombre());
            ps.setString(3, escuadron.getSectorBase());
            ps.setInt(4, escuadron.getNumeroCazas());

            ps.executeUpdate();
            System.out.println("Se ha resgistro correctamente: " + escuadron.getNombre() + " registrado.");

        } catch (SQLException e) {
            System.err.println("Error en al resgistrar dicho usuario: " + e.getMessage());
        }

    }

    @Override
    public List<EscuadronDTO> obtenerTodos() {
        List<EscuadronDTO> lista = new ArrayList<>();

        String sql = "SELECT * from escuadrones_imperiales";

        try (Connection conn = conexionDB.conectar(); 
                PreparedStatement st = conn.prepareCall(sql);
                ResultSet rs=st.executeQuery()) {
               while(rs.next())
               {
                  lista.add(new EscuadronDTO(rs.getString("id_escuadron"),rs.getString("nombre"),rs.getString("sector_base"),rs.getInt("numero_cazas")));
                  
               }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return lista;

    }

}
