
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        System.out.print("Inserisci il titolo dell'evento: ");
        String titolo = scan.nextLine();
       
        System.out.println("Inserisci la data");
        System.out.print("Giorno: ");
        int giorno = scan.nextInt();
        
        System.out.print("Mese (numero): ");
        int mese = scan.nextInt();
        
        System.out.print("Anno: ");
        int anno = scan.nextInt();
        
        LocalDate dataEvento = LocalDate.of(anno, mese, giorno);
        
        System.out.print("Quanti posti sono disponibili? ");
        int postiTotali = scan.nextInt();

        scan.nextLine();
        Evento nuovoEvento = new Evento(titolo, dataEvento, postiTotali);

        System.out.print("Desideri effettuare delle prenotazioni?(Y/N) ");
        String risposta = scan.nextLine();

        switch (risposta.toUpperCase()) {

            case "Y":
                System.out.print("Quanti posti vuoi prenotare? ");
                int postiDaPrenotare = scan.nextInt();
                
                nuovoEvento.prenota(postiDaPrenotare);
                break;

            case "N":
                System.out.println("Nessuna prenotazione effettuata!");
                break;
                
            default:
                System.out.println("Nessuna prenotazione effettuata!");
                break;
        }

        System.out.printf ("Posti prenotati: %s\nPosti ancora disponibili: %s",
                            nuovoEvento.getNumeroPostiRiservati(),
                            nuovoEvento.getNumeroPostiDisponibili());
        
        
    }
    
}
