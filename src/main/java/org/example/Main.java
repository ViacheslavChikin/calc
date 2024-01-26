package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите два числа (ОТ 1 ДО 10, можно римскими или арабскими цифрами)" +
                " и арифметическую опирацию между ними");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) {

        int rezultat;
        String rezultat1;
        int chislo1 = 0;
        int chislo2 = 0;
        boolean isRim = false;


        String[] chisla = input.split("[*+\\-/]");

        if (chisla.length != 2)
            throw new RuntimeException("Должно быть два числа и математическое действие между ними");

        if (!isRim(chisla[0]) && isRim(chisla[1]) || (isRim(chisla[0]) && !isRim(chisla[1])))
            throw new RuntimeException(" Числа должны быть одновременно или римскими или арабскими ");

        if (isRim(chisla[0]) && isRim(chisla[1])) {
            chislo1 = toArab(chisla[0]);
            chislo2 = toArab(chisla[1]);
            isRim = true;
        } else if (!isRim(chisla[0]) && !isRim(chisla[1])) {
            chislo1 = Integer.parseInt(chisla[0]);
            chislo2 = Integer.parseInt(chisla[1]);
            isRim = false;
        }

        if (chislo1 > 10 || chislo1 < 1 || chislo2 > 10 || chislo2 < 1)
            throw new RuntimeException(" Числа должны быть ОТ 1 ДО 10");

        rezultat = vichislrnie(chislo1, chislo2, input);
        rezultat1 = String.valueOf(rezultat);

        if (isRim) {
            if (rezultat < 1) {
                throw new RuntimeException("Результатом работы калькулятора с римскими числами " +
                        "могут быть только положительные числа");
            }
            rezultat1 = toRim(rezultat);
        }

        return rezultat1;
    }

    static int vichislrnie(int chislo1, int chislo2, String q) {
        if (q.contains("+")) return chislo1 + chislo2;
        else if (q.contains("-")) return chislo1 - chislo2;
        else if (q.contains("/")) return chislo1 / chislo2;
        else return chislo1 * chislo2;

    }

    static String[] rim = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII",
            "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV",
            "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII",
            "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI",
            "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII",
            "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII",
            "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV",
            "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    static boolean isRim(String string) {
        for (String s : rim) {
            if (string.equals(s)) return true;
        }
        return false;
    }

    static int toArab(String string) {
        for (int i = 0; i < rim.length; i++) {
            if (string.equals(rim[i])) return i;
        }
        return -500;
    }

    static String toRim(int i) {
        return rim[i];
    }
}
