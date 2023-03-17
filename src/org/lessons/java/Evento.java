package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    //Creare una classe Evento che abbia le seguenti proprietà:
    private String titolo;
    private LocalDate data;
    private int numeroPostiTotale;
    private int numeroPostiPrenotati;

    //Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel
    //costruttore, tranne posti prenotati che va inizializzato a 0
    public Evento(String titolo, LocalDate data, int numeroPostiTotale) throws DataException, PostiException {
        this.titolo = titolo;

        LocalDate oggi = LocalDate.now();
        if(data.isBefore(oggi)){
            throw new DataException("La data inserita non è validain in quanto è già passata!");
        } else {
            this.data = data;
        }

        if(numeroPostiTotale <= 0) {
            throw new PostiException("Il numero di posti totali deve essere maggiore di 0 !");
        } else{
            this.numeroPostiTotale = numeroPostiTotale;
        }

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

    public void setData(LocalDate data) {
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
    public void prenota() throws DataException, PostiException{
        LocalDate oggi = LocalDate.now();

        if(data.isBefore(oggi)) {
            throw new DataException("Non puoi prenotare per questo evento!");
        } else if (numeroPostiTotale < 1) {
            throw new PostiException("Posti in negativo");

        } else {
            numeroPostiTotale--;
            numeroPostiPrenotati++;
        }
    }
    /*
    2. disdici: riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono
        prenotazioni deve sollevare un’eccezione.
     */
    public void disdici() throws DataException, PostiException {
        LocalDate oggi = LocalDate.now();

        if(data.isBefore(oggi)) {
            throw new DataException("Non puoi prenotare per questo evento!");
        } else if (numeroPostiTotale < 0){
            throw new PostiException("Posti in negativo!");
        } else {
            numeroPostiTotale++;
            numeroPostiPrenotati--;
        }
    }
    /*
    3. l’override del metodo toString() in modo che venga restituita una stringa
        contenente: data formattata - titolo
     */
    public String dataFoormattata(LocalDate data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }

    @Override
    public String toString() {
        return this.dataFoormattata(getData()) + " Evento: " + getTitolo();
    }
}
