package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Partido;

public class VotoDAO {

    public List<Partido> obtenerVotosPorPartido() {
    List<Partido> lista = new ArrayList<>();
    String sql = """
        SELECT p.id, p.nombre, COUNT(v.id) AS total
        FROM partido p
        JOIN candidato c ON p.id = c.partido_id
        LEFT JOIN voto v ON c.id = v.candidato_id
        GROUP BY p.id, p.nombre
    """;

    try (Connection con = Conexion.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Partido p = new Partido();
            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setTotalVotos(rs.getInt("total"));
            lista.add(p);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}
}
