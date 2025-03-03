
import java.time.LocalDate;

public class MainBonus {

    public static void main(String[] args) {

        Evento evento = null;
        ProgrammaEventi compleanni = new ProgrammaEventi("Compleanni amici");
        
        LocalDate data1 = LocalDate.of(2025, 12, 16);
        evento = new Evento("Fabrizio", data1, 95);
        compleanni.addEvento(evento);
        
        LocalDate data2 = LocalDate.of(2025, 4, 1);
        evento = new Evento("Sara", data2, 95);
        compleanni.addEvento(evento);
        
        LocalDate data3 = LocalDate.of(2025, 10, 22);
        evento = new Evento("Davide", data3, 95);
        compleanni.addEvento(evento);

        LocalDate data4 = LocalDate.of(2026, 1, 7);
        evento = new Evento("Roberta", data4, 95);
        compleanni.addEvento(evento);
        
        LocalDate data5 = LocalDate.of(2025, 7, 21);
        evento = new Evento("Gigi", data5, 95);
        compleanni.addEvento(evento);
        
        LocalDate data6 = LocalDate.of(2026, 2, 6);
        evento = new Evento("Federico", data6, 95);
        compleanni.addEvento(evento);
        
        System.out.println(compleanni.numEventi());
        System.out.println(compleanni.getList());
        System.out.println(compleanni.getEventiOnData("2025-04-01"));
        System.out.println(compleanni.getListaOrdinata());
    }
}