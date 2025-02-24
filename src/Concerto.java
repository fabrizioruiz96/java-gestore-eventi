
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento {
    
    private LocalTime oraConcerto;
    private double prezzo;

    public Concerto(String titolo, LocalDate data, int numeroPosti, LocalTime ora, double prezzo) {
        super(titolo, data, numeroPosti);
        setOraConcerto(ora);
        setPrezzo(prezzo);
    }

    public LocalTime getOraConcerto() {
        return oraConcerto;
    }

    public void setOraConcerto(LocalTime oraConcerto) {
        this.oraConcerto = oraConcerto;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getPrezzoFormattato() {
        NumberFormat formatoEuro = NumberFormat.getCurrencyInstance(Locale.ITALY);
        return formatoEuro.format(prezzo);
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getDataOra() {
        LocalDateTime dataOraEvento = LocalDateTime.of(getData(), oraConcerto);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
        return dataOraEvento.format(formatter);
    }

    @Override
    public String toString() {
        return getDataOra() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }

}
