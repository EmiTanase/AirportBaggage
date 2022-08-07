/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.beenear;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<MenuOption> menuOptions = new ArrayList<MenuOption>(); //am creat o lista cu optiunile din meniu

    public Menu() {
        this.initializeMenuOptions(); // cand se creaza meniul se initializeaza si optiunile din meniu
    }

    private void initializeMenuOptions() { // initializam lista cu optiuni din meniu
        menuOptions.add(new MenuOption(1, "Verificare locuri disponibile."));
        menuOptions.add(new MenuOption(2, "Lasa un bagaj."));
        menuOptions.add(new MenuOption(3, "Ridicare bagaj."));
        menuOptions.add(new MenuOption(4, "Paraseste aplicatia."));
    }

    public void Display() {
        System.out.println("Va rugam sa alegeti o optiune:");
        for (MenuOption option : menuOptions) {
            //System.out.println(option.getId() + "." + option.getDescription());
            System.out.println(String.format("%d.%s", option.getId(), option.getDescription())); // folosim interpolare pt eficienta
        }
    }

    public int readOption() { // citiim optiunea introdusa de user
        try {
            Scanner scanner = new Scanner(System.in);
            int opt = scanner.nextInt();
            return opt;
        } catch (Exception e) {
            return -1;
        }
    }

}
