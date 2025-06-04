package modelo;

public class Voto {
    private int id;
    private int votanteId;
    private int candidatoId;

    public Voto() {}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVotanteId() {
        return this.votanteId;
    }

    public void setVotanteId(int votanteId) {
        this.votanteId = votanteId;
    }

    public int getCandidatoId() {
        return this.candidatoId;
    }

    public void setCandidatoId(int candidatoId) {
        this.candidatoId = candidatoId;
    }

}
