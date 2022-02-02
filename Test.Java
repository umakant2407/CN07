import org.junit.Test;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



class ValidatorClass{

    public static void main(String[] args) throws ParseException {
        validateFunction();
    }

    public static void validateFunction() throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        assertEquals(true,CreditCardValidation.isCardVailid("379354508162306",date.parse("05/02/2022"),"456"));
        assertEquals(false,CreditCardValidation.isCardVailid("379354508162306",date.parse("02/02/2022"),"456"));
        assertEquals(false,CreditCardValidation.isCardVailid("379354508162306",date.parse("05/02/2022"),"45687"));
    }

}
