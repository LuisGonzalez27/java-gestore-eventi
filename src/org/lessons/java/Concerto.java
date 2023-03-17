package org.lessons.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{
    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, LocalDate data, int numeroPostiTotale, LocalTime ora, BigDecimal prezzo) throws DataException, PostiException {
        super(titolo, data, numeroPostiTotale);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }
    //metodi per restituire data e ora formattata e prezzo formattato
    public String getFormatTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return ora.format(formatter);
    }

    public String getFormatPrice() {
        DecimalFormat df = new DecimalFormat("##,##€");
        return df.format(prezzo);
    }

    /*
    Fare l’override del metodo toString() in modo che venga restituita una stringa del tipo:
    data e ora formattata - titolo - prezzo formattato
     */
    @Override
    public String toString() {
        return "Concerto di " + getTitolo()
                + " il " + dataFoormattata(getData())
                + " inizio alle "+ getFormatTime()
                + ", prezzo biglietto " + getFormatPrice()
                + ", posti disponibili " + getNumeroPostiTotale() + ".";
    }
}
