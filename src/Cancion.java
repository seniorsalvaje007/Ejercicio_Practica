import java.util.Objects;

public class Cancion {

    private String titulo;
    private String artista;
    private int duracionENSegundos;

    public Cancion (String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionENSegundos = duracion;
    }

    public String getTitulo () {
        return this.titulo;
    }

    public String getArtista () {
        return this.artista;
    }

    public int getDuracion () {
        return this.duracionENSegundos;
    }

    @Override
    public String toString () {
        return "Nombre de la cancion: " + this.titulo + "\n" +
                "Artista: " + this.artista + "\n" +
                "Duracion en segundos: " + this.duracionENSegundos + " segundos";
    }

    @Override
    public boolean equals (Object posibleCancion) {
        if (this == posibleCancion) return true;
        if (posibleCancion == null || this.getClass() != posibleCancion.getClass()) return false;
        Cancion cancion = (Cancion) posibleCancion;
        return Objects.equals(this.titulo, cancion.titulo) && Objects.equals(this.artista, cancion.artista);
    }

    @Override
    public int hashCode () {
        return java.util.Objects.hash(this.titulo, this.artista);
    }

}
