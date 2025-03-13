package de.bsohef;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        float fuelLevel = GetNewValue("Füllstand");
        //dem Verbrauch (pro 100 km).
        float fuelUssage =  GetNewValue("Vebrauch Pro 100Km");
        //nach der Anzahl an Kilometern, die gefahren werden sollen.
        float distance =  GetNewValue("Zu fahrende Strecke");
        // dem Preis pro Liter Benzin.
        float price = GetNewValue("Der Preis Pro Liter");

        //berechnet den restlichen Tankinhalt nach der zu fahrenden Strecke.
        float fuelLevelPost = fuelLevel - (fuelUssage / 100) * distance;

        if (fuelLevelPost < 0) {
            // eine Warnmeldung aus, wenn der Tankinhalt nicht reicht.
            System.out.println("Dein Tank reicht für die Strecke nicht aus!");
        }
        else
        {
            System.out.println("Nach der Strecke hast du noch " + fuelLevelPost + " Liter im tank.");
        }

        //gibt die Kosten für die Fahrt aus.
        float priceTotal = ((fuelUssage / 100) * distance) * price;
        System.out.println("Der Preis für die Strecke ist " + Math.round(priceTotal * Math.pow(10,2)) / Math.pow(10,2) + " Euro.");

    }

    public static float GetNewValue(String name)
    {
        System.out.println("Bitte um eingabe: " + name);

        Scanner input = new Scanner(System.in);
        float newValue = input.nextFloat();

        //Fängt unrealistische Eingaben (negative Werte) ab und gibt eine Fehlermeldung aus.
        if(newValue < 0)
        {
            System.out.println("Die Eingabe ist ist ungültig und darf nicht kleiner als 0 sein!" + name + " ist ungültig!");
            return GetNewValue(name);
        }
        return newValue;
    }
}
