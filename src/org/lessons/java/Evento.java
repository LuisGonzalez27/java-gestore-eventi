package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Evento {
    //Creare una classe Evento che abbia le seguenti proprietà:
    private String titolo;
    private LocalDate data;
    private int numeroPostiTotale;
    private int numeroPostiPrenotati;

    //Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel
    //costruttore, tranne posti prenotati che va inizializzato a 0
    public Evento(String titolo, LocalDate data, int numeroPostiTotale) throws Exception {


        if(numeroPostiTotale <= 0) {
            throw new Exception("Il numero di posti totali deve essere maggiore di 0 !");
        }
        this.titolo = titolo;
        this.data = data;
        this.numeroPostiTotale = numeroPostiTotale;
        this.numeroPostiPrenotati = 0;
    }

    //Metodi getter e setter
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) throws Exception {
        if(LocalDate.now().isAfter(data)) {
            throw new Exception("La data inserita è gia passata");
        }
        this.data = data;
    }

    public int getNumeroPostiTotale() {
        return numeroPostiTotale;
    }

    public int getNumeroPostiPrenotati() {
        return numeroPostiPrenotati;
    }

    /*
    Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:
    1. prenota: aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha posti
       disponibili deve sollevare un’eccezione.
	 */
    public void prenota() throws Exception {
        if(data.isBefore(LocalDate.now()) || (numeroPostiPrenotati == numeroPostiTotale)) {
            throw new Exception("Non puoi prenotare per questo evento!");
        }
        numeroPostiPrenotati++;

    }
    /*
    2. disdici: riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono
        prenotazioni deve sollevare un’eccezione.
     */
    public void disdici() throws Exception {
        LocalDate pastEvent = LocalDate.now();
        if(data.isBefore(pastEvent) || (numeroPostiPrenotati == 0)) {
            throw new Exception("Non è possibile disdire per questo evento!");
        }
        numeroPostiPrenotati--;
    }
    /*
    3. l’override del metodo toString() in modo che venga restituita una stringa
        contenente: data formattata - titolo
     */
    DateTimeFormatter dataFormattata = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALIAN);

    @Override
    public String toString() {
        return "Data del evento: " + data.format(dataFormattata) + " Titolo: " + titolo;
    }
}
