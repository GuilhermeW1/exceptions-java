package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.entities.Reservation;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author guilherme
 */
public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            System.out.println("Room number ");
            int number = sc.nextInt();
            System.out.println("Check in date (dd/MM/yyyy)");
            LocalDate checkIn = LocalDate.parse(sc.next(), df);
            System.out.println("Check out date (dd/MM/yyyy)");
            LocalDate checkOut = LocalDate.parse(sc.next(), df);
            
            if (!checkOut.isAfter(checkIn)) {
                System.out.println("Error in reservation checkout date must be after checkin date");
            } else {
                Reservation res = new Reservation(number, checkIn, checkOut);
                System.out.println("Reservation " +res);
                
                System.out.println();
                System.out.println("Entre data to update");
                System.out.println("Check in date (dd/MM/yyyy)");
                checkIn = LocalDate.parse(sc.next(), df);
                System.out.println("Check out date (dd/MM/yyyy)");
                checkOut = LocalDate.parse(sc.next(), df);
                
                LocalDate now = LocalDate.now();
                if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
                    System.out.println("Reservation dates must be in the future");
                } else if (!checkOut.isAfter(checkIn)) {
                    System.out.println("Error in reservation checkout date must be after checkin date");
                } else {
                    res.updateDates(checkIn, checkOut);
                    System.out.println("Reservation "+ res);
                }                
            }
            
            
            
    }
}
