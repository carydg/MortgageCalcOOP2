package ph.cary;

public class Calculator {
    private int principal;
    private double interest;
    private int years;

    private final int PERCENT = 100;
    private final int MONTHS_IN_YEAR = 12;

    public Calculator(int principal, double interest, int years) {
        this.principal = principal;
        this.interest = interest;
        this.years = years;
    }

    public double calculateMortgage() {
        double monthlyInterest = getMothlyInterest();
        double numberOfPayments = getNumberOfPayments();

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public double calculateBalance(int numberOfPaymentsMade) {
        double monthlyInterest = getMothlyInterest();
        double numberOfPayments = getNumberOfPayments();

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    private double getMothlyInterest() {
        return interest / PERCENT / MONTHS_IN_YEAR;
    }
    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    public double[] getRemainingBalances() {
        var balance = new double[getNumberOfPayments()];
        for (int month = 1; month <= balance.length; month++) {
            balance[month-1] = calculateBalance(month);
        }
        return balance;
    }
}
