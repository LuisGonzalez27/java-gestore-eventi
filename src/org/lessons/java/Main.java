package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
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
    }
}
