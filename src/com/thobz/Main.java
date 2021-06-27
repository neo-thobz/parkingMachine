package com.thobz;

import java.util.InputMismatchException;
import java.util.Vector;
import java.util.Scanner;

public class Main {
    static int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200};

    static void denominateCash(int change) {
        Vector<Integer> denominatedValues = new Vector<>();

        for (int i = denominations.length - 1; i >= 0; i--) {
            while (change >= denominations[i]) {
                change -= denominations[i];
                denominatedValues.add(denominations[i]);
            }
        }

        for (int i = 0; i < denominatedValues.size(); i++) {
            System.out.print(" "+ denominatedValues.elementAt(i));
        }

        System.out.println();
    }

    static public boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            try {
                System.out.print("Enter the amount due: ");
                int amountOwed = sc.nextInt();

                System.out.print("Enter the amount paid: ");
                int amountPaid = sc.nextInt();

                if (amountPaid < amountOwed)
                {
                    do
                    {
                        System.out.println("Not enough to pay for your parking please enter an amount greater then: "+ amountOwed);
                        amountPaid = sc.nextInt();
                    }while(amountPaid < amountOwed);
                }

                int changeAmount = amountPaid - amountOwed;
                System.out.print("Your change is R "+ changeAmount +" will be given in the following denominations:");
                denominateCash(changeAmount);

                System.out.println("Thank you for using the parking calculator.");

                System.out.print("Enter 0 to exit program or any key to calculate again: ");
                String exit = sc.next();

                if (isStringInt(exit)){
                    int x = Integer.parseInt(exit);
                    if (x == 0){
                        done = true;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input entered. Please enter an integer value, program will now restart.");
                sc.nextLine();
            }
        }

        sc.close();
    }
}
