/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.beenear;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;
import static javafx.util.Duration.millis;

public class Baggage {

    private String uniqueID = null;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public Baggage() {
        LocalDateTime now = LocalDateTime.now();
        checkIn = now;
        uniqueID = UUID.randomUUID().toString();
    }

    public Baggage(LocalDateTime checkIn) {
        this.checkIn = checkIn;
        uniqueID = UUID.randomUUID().toString();
    }

    /**
     * @return the checkIn
     */
    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    /**
     * @param checkIn the checkIn to set
     */
    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * @return the checkOut
     */
    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    /**
     * @param checkOut the checkOut to set
     */
    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public int getPrice() {
        int price = 0;
        Duration duration = Duration.between(checkOut, checkIn);
        long mins = Math.abs(duration.getSeconds()) / 60; // calculam diferenta in minute
        if (mins <= 0) {
            return 0;
        }
        if (mins >= 60) {
            price += 10;
        }

        long extraHours = (mins - 60) / 60; //calculam numarul de ore extra
        if (extraHours > 0) {
            price += extraHours * 5;
        }
        if (mins % 60 > 0) { // verificam daca exista si minute extra
            price += 5;
        }

        return price;
    }

    /**
     * @return the uniqueID
     */
    public String getUniqueID() {
        return uniqueID;
    }

    public String getDuration() {
        Duration duration = Duration.between(checkOut, checkIn);
        String result = formatDuration(duration);
        return result;
    }

    private static String formatDuration(Duration duration) {
        long seconds = Math.abs(duration.getSeconds());
        long absSeconds = Math.abs(seconds);
        String positive = String.format(
                "%d:%02d:%02d",
                absSeconds / 3600,
                (absSeconds % 3600) / 60,
                absSeconds % 60);
        return seconds < 0 ? "-" + positive : positive;
    }

}
