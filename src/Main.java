import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите арифметическое выражение в формате: a + b");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        if (str.isEmpty()) {
            System.out.println("введена пустая строка");
        }
        else if (str.length()<1 || str.length()>11) {
            System.out.println("неккоректная строка");
        }
        else {
            int whit = 0;
            char [] arrayChars = str.toCharArray ();
            for (int i = 0; i< str.length(); i++) {
                if (arrayChars[i] == ' ') whit++;
            }
            if (whit == 2) System.out.println(calc(str));
            else System.out.println("неккоректный формат выражения");
        }
    }

    public static int arabic (String x) {
        switch (x){
            case ("0"): return 0;
            case ("1"): return 1;
            case ("2"): return 2;
            case ("3"): return 3;
            case ("4"): return 4;
            case ("5"): return 5;
            case ("6"): return 6;
            case ("7"): return 7;
            case ("8"): return 8;
            case ("9"): return 9;
            case ("10"): return 10;
            default: return -1;
        }
    }

    public static int rim (String x) {
        switch (x){
            case ("I"): return 1;
            case ("II"): return 2;
            case ("III"): return 3;
            case ("IV"): return 4;
            case ("V"): return 5;
            case ("VI"): return 6;
            case ("VII"): return 7;
            case ("VIII"): return 8;
            case ("IX"): return 9;
            case ("X"): return 10;
            default: return -1;
        }
    }

    public static String arithmetic (int a, int b, String sign) {
        switch (sign) {
            case ("+"):
                return "" + (a + b);
            case ("-"):
                return "" + (a - b);
            case ("*"):
                return "" + (a * b);
            case ("/"): {
                if (b == 0) return "на 0 делить нельзя";
                else return "" + (a / b);
            }
            default:
                System.out.println("калькулятор умеет только +, -, * и /");
        }
        return "ошибка";
    }

    public static String returnRim (String result) {
        int res = Integer.parseInt(result);
        if (res <= 0) return "Результатом работы калькулятора с римскими числами могут быть только положительные числа";
        else {
            String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                    "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                    "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                    "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
            };
            return roman[res];
        }
    }

    public static String result (String a, String b, String sign) {

        if ((arabic(a)>=0) && (arabic(b)>=0)) {
            return arithmetic(arabic(a),arabic(b), sign);
        }
        else if ((rim(a)>0) && (rim(b)>0)) {
            return returnRim(arithmetic(rim(a),rim(b), sign));
        }
        else return "некоректный ввод";
    }

    public static String calc(String input){ //принимает строку с арифметическим выражением между двумя числами и возвращает строку с результатом их выполнения.
        String[] parts = input.split(" ", 3);
        return result(parts[0], parts [2], parts[1]);
    }
}
