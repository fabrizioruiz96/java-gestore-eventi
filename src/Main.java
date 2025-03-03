
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Evento evento = null;
        ProgrammaEventi programmaEventi = null;

//ATTIVO UN CICLO WHILE(TRUE) COSICCHE IL PROGRAMMA CONTINUERA' A GIRARE FINCHE' L'UTENTE NON DECIDERA' DI CHIUDERLO
        while (true) {
            
            //MENU AZIONI PER CREARE E MANIPOLARE UN EVENTO
            System.out.println("\n*** GESTORE EVENTI ***");
            System.out.println("1. Crea un nuovo evento");
            System.out.println("2. Prenota un posto");
            System.out.println("3. Disdici un posto");
            System.out.println("4. Mostra dettagli dell'evento");
            System.out.println("0. Esci");

            System.out.print("\nScegli un'opzione: ");
            int scelta = scan.nextInt();
            scan.nextLine();

            switch (scelta) {
                //CASE PER LA CREAZIONE DELL'EVENTO
                case 1:
                    try {

                        System.out.println("\nCREA UN NUOVO EVENTO!");
                        System.out.print("Inserisci il titolo dell'evento: ");
                        String titoloEvento = scan.nextLine();

                        System.out.print("Inserisci la data (yyyy-MM-dd): ");
                        String dataEvento = scan.nextLine();
                        LocalDate parsedDataEvento = LocalDate.parse(dataEvento);

                        System.out.print("Inserisci i posti totali: ");
                        int postiTotaliEvento = scan.nextInt();

                        evento = new Evento(titoloEvento, parsedDataEvento, postiTotaliEvento);

                        System.out.print("L'evento è un concerto (Y/N)? ");
                        String isConcerto = scan.next().toUpperCase();

                        if (isConcerto.equals("Y")) {

                            System.out.print("Inserisci l'ora (HH:mm): ");
                            String oraEvento = scan.next();
                            LocalTime parsedOraEvento = LocalTime.parse(oraEvento);

                            System.out.print("Inserisci il prezzo del biglietto: ");
                            int prezzoEvento = scan.nextInt();

                            evento = new Concerto(titoloEvento, parsedDataEvento, postiTotaliEvento,
                                    parsedOraEvento, prezzoEvento);
                        }

                        System.out.println("\nEvento creato con successo!\n" + evento.toString());

                    } catch (Exception ex) {

                        System.err.println("\nERRORE: " + ex.getMessage()
                            + "\nNon è stato possibile creare l'evento!");
                    }
                    break;
                //CASE PER LA PRENOTAZIONE DI POSTI
                case 2:
                    if (evento != null) {
                        try {
                            
                            System.out.println("\nPRENOTAZIONE POSTI");
                            System.out.print("Quanti posti vuoi prenotare? ");
                            int postiPrenotazione = scan.nextInt();
    
                            evento.prenotaPosti(postiPrenotazione);
                            System.out.println("\nPosti prenotati con successo!");
    
                        } catch (Exception ex) {
    
                            System.err.println("\nERRORE: " + ex.getMessage()
                                + "\nNon è stato possibile prenotare i posti!");
                        }
                    } else {
                        System.out.println("\nNessun evento in programma!");
                    }
                    break;
                //CASE PER LA DISDETTA DI POSTI
                case 3:
                    if (evento != null) {
                        try {
                            
                            System.out.println("\nDISDETTA POSTI");
                            System.out.print("Quanti posti vuoi disdire? ");
                            int postiDisdetta = scan.nextInt();
    
                            evento.disdiciPosti(postiDisdetta);
                            System.out.println("\nPosti disdetti con successo!");
    
                        } catch (Exception ex) {
    
                            System.err.println("\nERRORE: " + ex.getMessage()
                                + "\nNon è stato possibile disdire i posti!");
                        }
                    } else {
                        System.out.println("\nNessun evento in programma!");
                    }
                    break;
                //CASE PER RICEVERE I DETTAGLI DELL'EVENTO
                case 4:
                    if (evento != null) {
                        System.out.println("\nDETTAGLI EVENTO\n"
                            + evento.toString()
                            + "\nPosti prenotati " + evento.getNumeroPostiRiservati()
                            + "\nPosti disponibili " + evento.getNumeroPostiDisponibili());
                    } else {
                        System.out.println("\nNessun evento in programma!");
                    }
                    break;
                //CASE PER CHIUDERE IL PROGRAMMA
                case 0: 
                    System.out.println("\nESCO DAL PROGRAMMA"); 
                    scan.close();
                    return;
                //DEFAULT CHE TI RIPORTA AL MENU OPZIONI
                default:
                System.out.println("\nOpzione non valida!");
            }
        }
    }

}