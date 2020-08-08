package ph.cary;

public class Main {

    public static void main(String[] args) {

        int principal = (int)Console.input("Principal", 1000, 1000000);
        double interest = Console.input("Interest", 1, 30);
        int years = (int)Console.input("Years", 1, 30);

        var calculator = new Calculator(principal, interest, years);

        var report = new Report(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }
}
