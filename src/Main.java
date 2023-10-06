
import java.io.IOException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void  main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        String someInput = null;
        try {
            someInput = calc(input);  //в метод Calc подставлям значение ввода
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
       someInput = "Ошибка";
        }
        System.out.println(someInput); // выводим результат из метода Calc

    }
    private static String calc(String input) throws IOException, ArrayIndexOutOfBoundsException {

        String[] arabic = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] roman = {"null", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] romanOut = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String[] numbers = input.split(" "); //Разделение ввода консоли на символы по пробелу в массив
        String a = numbers[0];
        String b = numbers[1];
        String d = numbers[2];

        boolean arabicA = Arrays.asList(arabic).contains(a); // Принадлежность к арабским символам
        boolean arabicD = Arrays.asList(arabic).contains(d);
        boolean romanA = Arrays.asList(roman).contains(a);
        boolean romanD = Arrays.asList(roman).contains(d);// Принадлежность к римским символам

        String indexA = aToNumber(a); // Перевод из римских в арабские a (через индекс массива)
        String indexD = aToNumber(d); // Перевод из римских в арабские d (через индекс массива)



     //System.out.println(indexA);
    //System.out.println(indexD);


        if ( numbers.length != 3 |a==null ) { // если символов больше трех
            throw new IOException();
        }

            if (arabicA && arabicD ) {
            return operationMethod(a, b, d); //в метод для римских подставлям разделенный массив

        }else if (romanA && romanD ) {
            String result = operationMethod(indexA, b, indexD);
            return romanOut [Integer.parseInt(result)];
        }else  {
            throw new IOException();
    }
    }



    private static String aToNumber(String a) {
        String result;
        String[] roman = {"null", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i<roman.length; i++){
            if(a.equals(roman[i])){
                result = String.valueOf(i);
                return result;
            }
        }
        return "-1";
    }

    private static String operationMethod (String valueA, String valueB, String valueC)   { //Метод для распознавания сложения, вычитания и т.д. из строки условия
        if (valueB.contains("+")) {
               int result = Integer.parseInt(valueA) + Integer.parseInt(valueC);
return String.valueOf(result);
        }else if (valueB.contains("-")) {
                int result = Integer.parseInt(valueA) - Integer.parseInt(valueC);
                return String.valueOf(result);
        }else if (valueB.contains("*")) {
            int result = Integer.parseInt(valueA) * Integer.parseInt(valueC);
            return String.valueOf(result);
        }else if (valueB.contains("/")) {
            int result = Integer.parseInt(valueA) / Integer.parseInt(valueC);
            return String.valueOf(result);
            }else{
               return ("Ошибка");
        }
    }
}