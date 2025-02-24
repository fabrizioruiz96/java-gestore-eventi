
import java.time.LocalDate;



public class MainProva {
    
    public static void main(String[] args) {
        LocalDate data = LocalDate.of(2025, 6, 6);

        try {
            Evento nuovoEvento = new Evento("Salmo", data, -5);
        } catch (Exception exception) {
            System.out.println("Errore: " + exception.getMessage());
        }
    }
}
