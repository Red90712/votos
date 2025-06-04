package dao;

import java.sql.*;
import java.util.*;
import modelo.Candidato;

public class CandidatoDAO {

    public List<Candidato> obtenerTodos() {
        List<Candidato> lista = new ArrayList<>();
        String sql = """
            SELECT c.id, c.nombre, c.partido_id, p.nombre AS nombrePartido,
                   COUNT(v.id) AS totalVotos
            FROM candidato c
            JOIN partido p ON c.partido_id = p.id
            LEFT JOIN voto v ON v.candidato_id = c.id
            GROUP BY c.id, c.nombre, c.partido_id, p.nombre
        """;

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Candidato c = new Candidato();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setPartidoId(rs.getInt("partido_id"));
                c.setNombrePartido(rs.getString("nombrePartido"));
                c.setTotalVotos(rs.getInt("totalVotos"));
                lista.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

public List<Candidato> buscar(String nombre) {
    List<Candidato> lista = new ArrayList<>();
    String sql = """
        SELECT c.id, c.nombre, c.partido_id, p.nombre AS nombrePartido,
               COUNT(v.id) AS totalVotos
        FROM candidato c
        JOIN partido p ON c.partido_id = p.id
        LEFT JOIN voto v ON v.candidato_id = c.id
        WHERE LOWER(c.nombre) LIKE LOWER(?)
        GROUP BY c.id, c.nombre, c.partido_id, p.nombre
    """;

    try (Connection con = Conexion.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, "%" + nombre + "%");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Candidato c = new Candidato();
            c.setId(rs.getInt("id"));
            c.setNombre(rs.getString("nombre"));
            c.setPartidoId(rs.getInt("partido_id"));
            c.setNombrePartido(rs.getString("nombrePartido"));
            c.setTotalVotos(rs.getInt("totalVotos"));
            lista.add(c);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}

}
