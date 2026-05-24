import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cancion> colaDeReproduccion = new ArrayList<>();

        while (true) {
            System.out.println("Input the title of the song, empty stops: ");
            String titulo = scanner.nextLine().trim();
            if (titulo.isEmpty()) {
                break;
            }

            System.out.println("Input the artist: ");
            String artista = scanner.nextLine().trim();

            System.out.println("Input the duration in seconds: ");
            int duracion = Integer.parseInt(scanner.nextLine());

            colaDeReproduccion.add(new Cancion(titulo, artista, duracion));
            System.out.println();
        }

        System.out.println("--- Tu Playlist Procesada ---");

        List<String> listaOrdenada = colaDeReproduccion.stream()
                .distinct()
                .sorted(Comparator
                        .comparing(Cancion::getArtista)
                        .thenComparing((c1, c2) -> Integer.compare(c2.getDuracion(), c1.getDuracion()))
                )
                .map(cancion -> cancion.getTitulo().toUpperCase())
                .collect(Collectors.toList());

        for (String cancion:listaOrdenada) {
            System.out.println(cancion);
        }
    }
}