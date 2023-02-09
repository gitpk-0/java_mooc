/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pk
 */
public class Debt {

    private double balance, interestRate;

    // constructor
    public Debt(double initialBalance, double initialInterestRate) {
        this.balance = initialBalance;
        this.interestRate = initialInterestRate;
    }

    // methods
    public void printBalance() {
        System.out.println(balance);
    }

    public void waitOneYear() {
        this.balance = balance * interestRate;
    }
    
}
