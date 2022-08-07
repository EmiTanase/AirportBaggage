/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.beenear;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BaggageStore {

    private final int Capacity = 100;
    private List<Baggage> store;

    public BaggageStore() {
        store = new ArrayList<Baggage>(); //am creat o lista goala cu bagaje
    }

    public int CheckEmptySlots() {
        return Capacity - store.size(); //capacitatea depozitului - cate bagaje sunt in lista
    }

    private void addBaggage(Baggage b) throws Exception {
        //verificare loc disponibil
        if (CheckEmptySlots() <= 0) {
            throw new Exception("Nu mai sunt locuri disponibile!");
        }
        store.add(b); // adaugam bagajul in lista (depozit)
    }

    public String addBaggage() throws Exception {
        Baggage b = new Baggage(); // creem bagajul
        addBaggage(b);
        return b.getUniqueID();
    }

    public String addBaggage(LocalDateTime checkInDate) throws Exception {
        Baggage b = new Baggage(checkInDate); // creem bagajul
        addBaggage(b);
        return b.getUniqueID();
    }

    public Baggage getBaggage(String identifier) throws Exception { //scoatem bagajul din depozit
        for (Baggage b : store) { //verificam bagajul 1 cate 1
            if (b.getUniqueID().equals(identifier)) { //daca am gasit un bagaj care are codul egal cu cel indtrodus de user
                b.setCheckOut(LocalDateTime.now()); // setam data de check out a bagajului cu data curenta
                return b;
            }
        }

        throw new Exception("Bagajul nu poate fi gasit!");
    }
}
