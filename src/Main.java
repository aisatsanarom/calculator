
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void  main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();//Условие, введенное через консоль
        String someInput = calc(input); //в метод Calc подставлям значение ввода
        System.out.println(someInput); // выводим результат из метода Calc

    }
    private static String calc(String input) {

        String[] arabic = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] roman = {"null", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] romanOut = {"null", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII","XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "X" };
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

     // System.out.println(indexA);
    //System.out.println(indexD);

 if (numbers.length > 3) { // Ограничение по длине выражения
            return ("Ошибка, должно быть три символа");

        } else if (arabicA && arabicD ) {
            return operationMethod(a, b, d); //в метод для римских подставлям разделенный массив

        }else if (romanA && romanD ) {
            String result = operationMethod(indexA, b, indexD);
            return romanOut [Integer.parseInt(result)];
        }
        return ("Ошибка, неподходящие символы");
    }

    private static String aToNumber(String a) {
        String result;
        switch (a) {
            case "I":
                result = "1";
                break;
            case "II":
                result = "2";
                break;
            case "III":
                result = "3";
                break;
            case "IV":
                result = "4";
                break;
            case "V":
                result = "5";
                break;
            case "VI":
                result = "6";
                break;
            case "VII":
                result = "7";
                break;
            case "VIII":
                result = "8";
                break;
            case "IX":
                result = "9";
                break;
            case "X":
                result = "10";
                break;
            default:
                result = "-1";
        }
        return result;
    }

    private static String operationMethod (String valueA, String valueB, String valueC) { //Метод для распознавания сложения, вычитания и т.д. из строки условия
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















