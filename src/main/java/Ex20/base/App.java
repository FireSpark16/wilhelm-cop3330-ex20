/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Xander Wilhelm
 */

package Ex20.base;

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        double cost = myApp.getCost();
        double tax;
        String state= myApp.getState();
        if(state.equals("Wisconsin"))
        {
            String county = myApp.getCounty();
            double wisTax = 0.05;
            if (county.equals("Eau Claire"))
                tax = myApp.calcTax(cost, (wisTax+0.005));
            else if(county.equals("Dunn"))
                tax = myApp.calcTax(cost, (wisTax+0.004));
            else
                tax = myApp.calcTax(cost, wisTax);
        }
        else if(state.equals("Illinois"))
        {
            double illTax = 0.08;
            tax = myApp.calcTax(cost, illTax);
        }
        else
            tax = myApp.calcTax(cost, 0);

        double total = myApp.calcTotal(tax, cost);
        myApp.output(tax, total);
    }

    private void output(double tax, double total) {
        System.out.print("The tax is $" + String.format("%.2f",tax) + ".\nThe total is $" + String.format("%.2f",total) + ".");
    }

    private double calcTotal(double tax, double cost) {
        return Math.ceil((cost + tax) * 100) /100;
    }

    private double calcTax(double cost, double tax) {
        return Math.ceil((cost * tax) * 100) /100;
    }

    private String getCounty() {
        System.out.print("What county do you live in? ");
        return in.nextLine();
    }

    private String getState() {
        System.out.print("What state do you live in? ");
        return in.nextLine();
    }

    private double getCost() {
        System.out.print("What is the order amount? ");
        return Double.parseDouble(in.nextLine());
    }

}