
import java.time.LocalDate;

public class Evento {

    private String titoloEvento;
    private LocalDate dataEvento;
    private int numeroPostiTotali;
    private int numeroPostiRiservati;

    private static LocalDate now = LocalDate.now();

    public Evento(String titolo, LocalDate data, int numeroPostiTotali) {
        this.titoloEvento = titolo;
        setData(data);
        setNumeroPostiTotali(numeroPostiTotali);
        numeroPostiRiservati = 0;
    }

    public void setTitolo(String titolo) {
        this.titoloEvento = titolo;
    }

    public void setData(LocalDate data) throws IllegalArgumentException {
        if (data.isAfter(now)) {
            this.dataEvento = data;
        } else {
            throw new IllegalArgumentException("La data inserita non è valida!");
        }
    }

    private void setNumeroPostiTotali(int numeroPostiTotali) throws IllegalArgumentException {
        if (numeroPostiTotali < 1) {
            throw new IllegalArgumentException("Il numero di posti totali dell'evento non può essere negativo!");
        }
        
        this.numeroPostiTotali = numeroPostiTotali;
    }

    public String getTitolo() {
        return titoloEvento;
    }

    public LocalDate getData() {
        return dataEvento;
    }

    public int getNumeroPostiTotali() {
        return numeroPostiTotali;
    }

    public int getNumeroPostiRiservati() {
        return numeroPostiRiservati;
    }

    public void prenota(int numeroPrenotazioni) throws Exception {
        if (dataEvento.isBefore(now)) {
            throw new Exception("L'evento è già passato!");
        } else if (numeroPostiRiservati == numeroPostiTotali) {
            throw new Exception("L'evento è sold out!");
        } 

        numeroPostiRiservati += numeroPrenotazioni;
    }

    public void disdici(int numeroDisdette) throws Exception {
        if (dataEvento.isBefore(now)) {
            throw new Exception("L'evento è già passato!");
        } else if (numeroPostiRiservati == 0) {
            throw new Exception("Non ci sono posti riservati!");
        }

        numeroPostiRiservati -= numeroDisdette;
    }

    public int getNumeroPostiDisponibili() {
        return numeroPostiTotali - numeroPostiRiservati;
    }

    @Override
    public String toString() {
        return dataEvento + " - " + titoloEvento;
    }

}