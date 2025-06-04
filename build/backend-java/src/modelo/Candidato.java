package modelo;

public class Candidato {
    private int id;
    private String nombre;
    private int partidoId;
    private String nombrePartido;
    private int totalVotos;

    public Candidato() {}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidoId() {
        return this.partidoId;
    }

    public void setPartidoId(int partidoId) {
        this.partidoId = partidoId;
    }

    public String getNombrePartido() {
        return this.nombrePartido;
    }

    public void setNombrePartido(String nombrePartido) {
        this.nombrePartido = nombrePartido;
    }

    public int getTotalVotos() {
        return this.totalVotos;
    }

    public void setTotalVotos(int totalVotos) {
        this.totalVotos = totalVotos;
    }

    // Getters y Setters
}

