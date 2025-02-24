
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        System.out.print("Inserisci il titolo dell'evento da creare: ");
        String titolo = scan.nextLine();

        System.out.println("Inserisci la data e l'orario");
        System.out.print("Giorno: ");
        int giorno = scan.nextInt();

        System.out.print("Mese(numero): ");
        int mese = scan.nextInt();

        System.out.print("Anno: ");
        int anno = scan.nextInt();

        LocalDate data = LocalDate.of(anno, mese, giorno);

        System.out.print("Ore: ");
        int ore = scan.nextInt();

        System.out.print("Minuti: ");
        int minuti = scan.nextInt();

        LocalTime orario = LocalTime.of(ore, minuti);

        System.out.print("Posti a disposizione per l'evento: ");
        int posti = scan.nextInt();

        System.out.print("Prezzo del biglietto: ");
        double prezzo = scan.nextDouble();

        Concerto nuovoConcerto = new Concerto(titolo, data, posti, orario, prezzo);

        System.out.print("Desideri effettuare delle prenotazioni?(Y/N) ");
        String rispostaPrenotazioni = scan.next().toUpperCase();

        if (rispostaPrenotazioni.equals("Y")) {
            System.out.print("Quanti posti desideri prenotare? ");
            int postiPrenotazione = scan.nextInt();
            nuovoConcerto.prenotaPosti(postiPrenotazione);
        } else {
            System.out.println("Nessun posto prenotato!");
        }

        System.out.printf("Posti prenotati %s\nPosti disponibili %s\n",
                nuovoConcerto.getNumeroPostiRiservati(),
                nuovoConcerto.getNumeroPostiDisponibili());

        System.out.print("Desideri disdire delle prenotazioni?(Y/N) ");
        String rispostaDisdette = scan.next().toUpperCase();

        if (rispostaDisdette.equals("Y")) {
            System.out.print("Quanti prenotazioni desideri disdire? ");
            int postiDisdette = scan.nextInt();
            nuovoConcerto.prenotaPosti(postiDisdette);
        } else {
            System.out.println("Nessuna disdetta effettuata!");
        }

        System.out.printf("Posti prenotati %s\nPosti disponibili %s\n",
                nuovoConcerto.getNumeroPostiRiservati(),
                nuovoConcerto.getNumeroPostiDisponibili());

        System.out.println(nuovoConcerto.toString());

        scan.close();

    }

}
