package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.PartidoDAO;
import dao.CandidatoDAO;
import dao.VotanteDAO;

@WebServlet("/api/filtro")
public class FiltroServlet extends HttpServlet {
    private PartidoDAO partidoDAO = new PartidoDAO();
    private CandidatoDAO candidatoDAO = new CandidatoDAO();
    private VotanteDAO votanteDAO = new VotanteDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String tipo = req.getParameter("tipo");     // "partido", "candidato", "votante"
        String nombre = req.getParameter("nombre"); // texto de búsqueda

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        Gson gson = new Gson();

        switch (tipo) {
            case "partido":
                out.print(gson.toJson(partidoDAO.buscar(nombre)));
                break;
            case "candidato":
                out.print(gson.toJson(candidatoDAO.buscar(nombre)));
                break;
            case "votante":
                out.print(gson.toJson(votanteDAO.buscar(nombre)));
                break;
            default:
                out.print("{\"error\": \"Tipo de búsqueda no válido\"}");
        }
    }
}
