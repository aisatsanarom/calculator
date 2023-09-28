
import java.util.Scanner;
public class Main {
    public static void  main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String condition = scanner.nextLine(); //Условие, введенное через консоль


         //Метод для разделения ввода c консоли на числа по заданному символу в массив
        String [] numbers = condition.split("[+\\-*/]");
        int a=Integer.parseInt(numbers [0].trim()); //Инициализация и преобразование в число первого значения из строки условия
        int b=Integer.parseInt(numbers [1].trim()); //Инициализация и преобразование в число второго значения из строки условия
        String sign =" ";//Знак условия

        //Метод для распознавания сложения, вычитания и т.д. из строки условия
        if (condition.contains("+")){
             sign = "+";
        }else if(condition.contains("-")){
            sign = "-";
        }else if(condition.contains("*")){
            sign = "*";
        }else if(condition.contains("/")){
            sign = "/";
        }else{
            System.out.println("Ошибка");
        }

        Oper addition = new Oper (); //Создаем объект класса для операции суммирования
        addition.num1=a;
        addition.num2=b;
        addition.operator=sign;
      //System.out.println(sum.num1);
      //System.out.println(sum.operator);
      //System.out.println(sum.num2);
        int resultAddition= addition.Calculate();
        System.out.println(resultAddition);
        //Создаем объект класса для операции вычитания

    }
}

        class Oper { //Класс, включающий данные для доступных операций (сумма, разница, произведение и деление)
            int num1;
            int num2;
            String operator;

         int Calculate() { //Метод класса для рассчета результата
            if (operator.equals("+")){
        int result = num1 + num2;
           return result;
            }else{
                return (0);

}
    }
        }


