/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.beenear;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Beenear {

    public static void main(String[] args) {
        BaggageStore baggageStore = new BaggageStore(); // se creaza depozitul de bagaje, initial v-a fi gol
        Menu menu = new Menu(); // se creaza meniul 
        menu.Display();
        int choosedOptionId = menu.readOption();
        while (choosedOptionId != 4) {
            switch (choosedOptionId) {
                case 1:
                    System.out.println("M-ai sunt disponibile " + baggageStore.CheckEmptySlots() + " locuri.");
                    break;
                case 2: {
                    try {
                        //for testing
                        //String msg2 = "Introduceti data de checkin:";
                        //String str = readLine(msg2);
                        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                        //LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
                        //String identifier = baggageStore.addBaggage(dateTime);
                        String identifier = baggageStore.addBaggage();
                        System.err.println("Bagajul dumneavoastra a fost depus. Cod de identificare: " + identifier);
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                }
                case 3: {
                    String msg = "Introduceti codul de identificare:";
                    String id = readLine(msg);
                    try {
                        Baggage b = baggageStore.getBaggage(id);
                        System.out.println("Durata: " + b.getDuration());
                        System.out.println("Pret: " + b.getPrice() + " lei.");
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                }
                case 4:
                    return;
                default:
                    System.err.println("Optiune invalida!");
            }

            menu.Display();
            choosedOptionId = menu.readOption();
        }
    }

    private static String readLine(String msg) {
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return line;
    }
}
