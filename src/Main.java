import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

//    According wikiHow,
//    MonthlyMortgage = Principal * (  monthlyInterestRate * (1+monthlyInterestRate)^numberOfPayment  )
//                      / (  (1+monthlyInterestRate)^numberOfPayment  -  1  )
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal;
        float monthlyInterest;
        int numberOfPayments;

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal>=1000 && principal<=1_000_000) {
                break;
            }
            else {
                System.out.println("Enter an integer between 1,000 to 1,000,000");
            }
        }

        while(true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if(annualInterest>=1 && annualInterest<= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            else{
                    System.out.println("Enter Annual Interest Rate between 1 and 30");
                }
        }

        while(true) {
            System.out.print("Period (Years of payment back): ");
            byte years = scanner.nextByte();
            if(years>=1 && years<=30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            else {
                System.out.println("Enter years between 1 to 30");
            }
        }

        double mortgage = principal * ( monthlyInterest * Math.pow(1+monthlyInterest,numberOfPayments))
                          / ( Math.pow(1+monthlyInterest,numberOfPayments) -1);

        String mortgageFormatted =NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage per month: " + mortgageFormatted);



    }
}
