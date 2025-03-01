
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammaEventi {

//DEFINISCO LE PROPRIETA'
    private String titolo;
    private List<Evento> eventi;

//DEFINISCO IL COSTRUTTORE
    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        eventi = new ArrayList<>();
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public List<Evento> getList() {
        return eventi;
    }

    public void addEvento(Evento evento) {
        eventi.add(evento);
    }

    public List<Evento> getEventiOnData(LocalDate data) {
        List<Evento> eventiOnData = new ArrayList<>();
        
        for (int idx = 0; idx < eventi.size(); idx++) {
            if (eventi.get(idx).getData() == data) {
                eventiOnData.add(eventi.get(idx));
            }
        }

        return eventiOnData;
    }

    public int numEventi() {
        return eventi.size();
    }

    public void deleteEventi() {
        eventi.clear();
    }

    public String getListaOrdinata() {
        Collections.sort(eventi);
        return getTitolo() + ":" + eventi;
    }
}
