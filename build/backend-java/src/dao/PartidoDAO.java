package dao;

import java.sql.*;
import java.util.*;
import modelo.Partido;

public class PartidoDAO {

    public List<Partido> obtenerTodos() {
        List<Partido> lista = new ArrayList<>();
        String sql = "SELECT id, nombre FROM partido";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Partido p = new Partido();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

public List<Partido> buscar(String nombre) {
    List<Partido> lista = new ArrayList<>();
    String sql = "SELECT id, nombre FROM partido WHERE LOWER(nombre) LIKE LOWER(?)";

    try (Connection con = Conexion.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, "%" + nombre + "%");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Partido p = new Partido();
            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            lista.add(p);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}
}
