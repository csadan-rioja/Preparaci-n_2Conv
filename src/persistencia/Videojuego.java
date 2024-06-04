package persistencia;

public class Videojuego {
    private int id;
    private String titulo;
    private String desarrollador;
    private int anoLanzamiento;

    public Videojuego(int id, String titulo, String desarrollador, int anoLanzamiento) {
        this.id = id;
        this.titulo = titulo;
        this.desarrollador = desarrollador;
        this.anoLanzamiento = anoLanzamiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public int getAnoLanzamiento() {
        return anoLanzamiento;
    }

    public void setAnoLanzamiento(int anoLanzamiento) {
        this.anoLanzamiento = anoLanzamiento;
    }

}
