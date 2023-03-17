package org.lessons.java;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Concerto newConcerto;
        try {
            newConcerto = new Concerto("Bob Dylan", LocalDate.parse("2030-12-05"), 200, LocalTime.parse("21:00"), BigDecimal.valueOf(45.50));
            System.out.println(newConcerto);
        } catch (Exception e) {
            System.out.println("Non è possibile inserire l'evento! " + e.getMessage());
        }

        Scanner scan = new Scanner(System.in);

        System.out.println("Inserisce il nome dell'evento: ");
        String titolo = scan.nextLine();

        System.out.println("Inserisci la data dell'evento (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Inserisci il numero totale dei posti disponibile per l'evento: ");
        int numeroPostiTotale = Integer.parseInt(scan.nextLine());

        Evento newEvento = null;
        try{
            newEvento = new Evento(titolo, data, numeroPostiTotale);
            System.out.println(newEvento);
        } catch (Exception e){
            System.out.println("Non è possibile inserire evento! " + e.getMessage());
        }

        boolean scelta = false;
        while (!scelta) {
            System.out.println("Cosa vuoi fare una 1-prenotazione, 2-disdetta , 3-uscire ?");

            String newScelta = scan.nextLine();

            switch (newScelta) {
                case ("1") -> {
                    System.out.print("Quante prenotazioni vuoi effettuare? ");
                    int numeroPrenotazioni = Integer.parseInt(scan.nextLine());
                    int i = 0;

                    if (newEvento.getNumeroPostiTotale() > newEvento.getNumeroPostiPrenotati() + numeroPrenotazioni) {
                        while (i < numeroPrenotazioni) {
                            newEvento.prenota();
                            i++;
                        }
                    } else {
                        System.out.println("Non puoi prenotare " + numeroPrenotazioni + " posti" + ", il massimo di posti è di " + (newEvento.getNumeroPostiTotale() - newEvento.getNumeroPostiPrenotati()));
                    }

                    System.out.println("Posti prenotati " + newEvento.getNumeroPostiPrenotati() + ", rimangono " + newEvento.getNumeroPostiTotale() + " posti.");
                }
                case ("2") -> {
                    System.out.print("Quante disdette vuoi effettuare? ");
                    int counterDisdette = Integer.parseInt(scan.nextLine());
                    int disdetta = 0;

                    if (counterDisdette <= newEvento.getNumeroPostiPrenotati()) {
                        while (disdetta < counterDisdette) {
                            newEvento.disdici();
                            disdetta++;
                        }
                    } else {
                        System.out.println("Non puoi effettuare " + counterDisdette + " disdette" + ", il massimo è di " + newEvento.getNumeroPostiPrenotati());
                    }

                    System.out.println("Posti prenotati " + newEvento.getNumeroPostiPrenotati() + ", rimangono " + newEvento.getNumeroPostiTotale() + " posti.");

                }
                case ("3") -> {
                    System.out.print("Grazie e arrivederci.");
                    scelta = true;
                }
                default -> {
                }
            }
        }
    }
}
