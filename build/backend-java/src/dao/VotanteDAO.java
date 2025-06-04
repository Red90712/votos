package dao;

import java.sql.*;
import java.util.*;
import modelo.Votante;

public class VotanteDAO {

    public List<Votante> obtenerTodos() {
        List<Votante> lista = new ArrayList<>();
        String sql = """
            SELECT v.id, v.nombre, v.vereda_id, ve.nombre AS nombreVereda,
                   c.nombre AS nombreCandidato, p.nombre AS nombrePartido
            FROM votante v
            JOIN vereda ve ON v.vereda_id = ve.id
            LEFT JOIN voto vo ON v.id = vo.votante_id
            LEFT JOIN candidato c ON vo.candidato_id = c.id
            LEFT JOIN partido p ON c.partido_id = p.id
        """;

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Votante votante = new Votante();
                votante.setId(rs.getInt("id"));
                votante.setNombre(rs.getString("nombre"));
                votante.setVeredaId(rs.getInt("vereda_id"));
                lista.add(votante);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public List<Votante> buscar(String nombre) {
    List<Votante> lista = new ArrayList<>();
    String sql = """
        SELECT v.id, v.nombre, v.vereda_id, ve.nombre AS nombreVereda,
               c.nombre AS nombreCandidato, p.nombre AS nombrePartido
        FROM votante v
        JOIN vereda ve ON v.vereda_id = ve.id
        LEFT JOIN voto vo ON v.id = vo.votante_id
        LEFT JOIN candidato c ON vo.candidato_id = c.id
        LEFT JOIN partido p ON c.partido_id = p.id
        WHERE LOWER(v.nombre) LIKE LOWER(?)
    """;

    try (Connection con = Conexion.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, "%" + nombre + "%");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Votante votante = new Votante();
            votante.setId(rs.getInt("id"));
            votante.setNombre(rs.getString("nombre"));
            votante.setVeredaId(rs.getInt("vereda_id"));
            lista.add(votante);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}

}
