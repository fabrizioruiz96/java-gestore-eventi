
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento {

//DEFINISCO LE PROPRIETA'
    private LocalTime oraConcerto;
    private double prezzo;

//DEFINISCO IL COSTRUTTORE
    public Concerto(String titolo, LocalDate data, int numeroPosti, LocalTime ora, double prezzo) {
        super(titolo, data, numeroPosti);
        setOraConcerto(ora);
        setPrezzo(prezzo);
    }

//SEZIONE SETTER
    public void setOraConcerto(LocalTime oraConcerto) {
        this.oraConcerto = oraConcerto;
    }
    
    //setter prezzo con rispettivo controllo di correttezza
    public void setPrezzo(double prezzo) {
        if (prezzo < 0) {
            throw new IllegalArgumentException("Il prezzo del biglietto non può essere negativo!");
        }
        this.prezzo = prezzo;
    }

//SEZIONE GETTER
    private LocalTime getOraConcerto() {
        return oraConcerto;
    }

    private double getPrezzo() {
        return prezzo;
    }

    public String getPrezzoFormattato() {
        NumberFormat formatoEuro = NumberFormat.getCurrencyInstance(Locale.ITALY);
        return formatoEuro.format(prezzo);
    }

    public String getDataOra() {
        LocalDateTime dataOraEvento = LocalDateTime.of(getData(), oraConcerto);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
        return dataOraEvento.format(formatter);
    }

//OVERRIDE DEL TO STRING
    @Override
    public String toString() {
        return getDataOra() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }

}
