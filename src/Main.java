import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MyException extends Exception {
    public MyException (String str) {
        System.out.println(str);
    }
}

public class Main {
    public static void main (String[] args) throws MyException {
        System.out.print("Expression format: a + b \nEnter: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            str = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        if (str.length()<1 || str.length()>11)  throw new MyException("Invalid string");

        System.out.println(calc(str));
    }

    public static int arabic (String x) {
        switch (x){
            case "0": return 0;
            case "1": return 1;
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": return 10;
            default: return -1;
        }
    }

    public static int rim (String x) {
        switch (x){
            case "I": return 1;
            case "II": return 2;
            case "III": return 3;
            case "IV": return 4;
            case "V": return 5;
            case "VI": return 6;
            case "VII": return 7;
            case "VIII": return 8;
            case "IX": return 9;
            case "X": return 10;
            default: return -1;
        }
    }

    public static String arithmetic (int a, int b, String sign) throws MyException {
        String re = "";
        switch (sign) {
            case "+":
                re += (a + b);
                break;
            case "-":
                re += (a - b);
                break;
            case "*":
                re += (a * b);
                break;
            case "/":
                try {
                    re += (a / b);
                } catch (ArithmeticException e) {
                    System.out.println("Division by zero");
                }
                break;
            default:
                throw new MyException("Incorrect sign");
        }
        return re;
    }

    public static String returnRim (String result) throws MyException { //перевод результата вычислений из арабских чисел в римские
        int res = Integer.parseInt(result);
        try {
            String[] roman = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                    "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                    "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                    "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
            return roman[res];
        } catch (Exception e) {
            throw new MyException("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
        }
    }

    public static String result (String a, String b, String sign) throws MyException {
        if ((arabic(a)>=0) && (arabic(b)>=0)) //если оба числа арабские, то считаем и возвращаем результат
            return arithmetic(arabic(a),arabic(b), sign);
        else if ((rim(a)>0) && (rim(b)>0))  //если оба числа римские, то считаем и возвращаем результат
            return returnRim(arithmetic(rim(a),rim(b), sign));
        else throw new MyException("Incorrect expression");
    }

    public static String calc(String input) throws MyException { //принимает строку с арифметическим выражением между двумя числами и возвращает строку с результатом их выполнения.
        String[] parts = input.split(" ", 3);
        return result(parts[0], parts [2], parts[1]);
    }
}