import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class CreditCardValidation{
    
    public static void main(String[] args) {

        //create Scanner object
        Scanner scanner = new Scanner(System.in);

        //user input of card number
        String cardNumber;
        System.out.println("Enter your card number :-");
        cardNumber =scanner.next();

        //user input of card expiry date in valid formate
        boolean flag=false;
        String tempDate;
        Date date=new Date();
        SimpleDateFormat cardExpiryDate = new SimpleDateFormat("dd/MM/yyyy");
        cardExpiryDate.setLenient(false);
        System.out.println("Enter card expiry date (in DD/MM/YYYY Format)-: ");
        while(!flag){
            tempDate=scanner.next();
            try {
                date = cardExpiryDate.parse(tempDate);
                flag=true;
            } catch (ParseException e) {
                System.out.println("Error :Invalid Date Entered or Invalid Date Format");
                System.out.println("----Enter Again----");
                flag=false;
            }
        }

        //user input of card number
        String cvNumber="a";
        System.out.println("Enter your card CV number :-");
        cvNumber=scanner.next();

        //Run the isCardValid Function
        isCardVailid(cardNumber,date,cvNumber);

    }
        //validating CV
        private static boolean isValidCv(String cvNumber) {
            if(cvNumber.length()==3 || cvNumber.length()==4)
                return true;
            else
                return false;
        }

        //checking valid expiry date
        private static boolean isvadidExpiryDate(Date date) {
            Date todaDate=new Date();
            if(date.compareTo(todaDate)>0)
                return true;
            else
                return false;
        }

        //cheching the validation of card number by luhn algorithm
        private static boolean validateCreditCardNumber(String cardNumber) {

            int[] ints = new int[cardNumber.length()];
            for (int i = 0; i < cardNumber.length(); i++) {
                ints[i] = Integer.parseInt(cardNumber.substring(i, i + 1));
            }
            for (int i = ints.length - 2; i >= 0; i = i - 2) {
                int j = ints[i];
                j = j * 2;
                if (j > 9) {
                    j = j % 10 + 1;
                }
                ints[i] = j;
            }
            int sum = 0;
            for (int i = 0; i < ints.length; i++) {
                sum += ints[i];
            }
            if (sum % 10 == 0) {
                return true;
            } else {
                return false;
            }
        }

        // checking card is valid or not
        private static Void isCardVailid(String cardNumber, Date date,String cvNumber) {
            if(validateCreditCardNumber(cardNumber) && isvadidExpiryDate(date) && isValidCv(cvNumber) )
                System.out.println("---------Card is Vailid------");
            else
            System.out.println("---------Card is In Vailid------");

            return null;
        }

}
