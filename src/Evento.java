
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String titoloEvento;
    private LocalDate dataEvento;
    private final int numeroPostiTotali;
    private int numeroPostiRiservati;

    private static LocalDate now = LocalDate.now();

    public Evento(String titolo, LocalDate data, int numeroPostiTotali) throws IllegalArgumentException {
        numeroPostiRiservati = 0;
        this.titoloEvento = titolo;
        setData(data);

        if (numeroPostiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti non può essere negativo!");
        }
        this.numeroPostiTotali = numeroPostiTotali;
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

    public String getTitolo() {
        return titoloEvento;
    }

    public LocalDate getData() {
        return dataEvento;
    }

    private String getDataFormattata() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MMM/yyyy");
        return dataEvento.format(formatter);
    }

    public int getNumeroPostiTotali() {
        return numeroPostiTotali;
    }

    public int getNumeroPostiRiservati() {
        return numeroPostiRiservati;
    }

    public void prenota() throws Exception {
        if (dataEvento.isBefore(now)) {
            throw new Exception("L'evento è già passato!");
        } else if (numeroPostiRiservati == numeroPostiTotali) {
            throw new Exception("L'evento è sold out!");
        } 

        numeroPostiRiservati++;
    }

    public void prenotaPosti(int numeroPrenotazioni) throws Exception {
        if (dataEvento.isBefore(now)) {
            throw new Exception("L'evento è già passato!");
        } else if (numeroPostiRiservati == numeroPostiTotali) {
            throw new Exception("L'evento è sold out!");
        } 

        numeroPostiRiservati += numeroPrenotazioni;
    }

    public void disdici() throws Exception {
        if (dataEvento.isBefore(now)) {
            throw new Exception("L'evento è già passato!");
        } else if (numeroPostiRiservati == 0) {
            throw new Exception("Non ci sono posti riservati!");
        }

        numeroPostiRiservati--;
    }

    public void disdiciPosti(int numeroDisdette) throws Exception {
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
        return getDataFormattata() + " - " + titoloEvento;
    }

}