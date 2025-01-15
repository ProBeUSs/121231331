public class Main {
    public static void main(String[] args) {

        int a = 10;
        int b = 0;
        String c = null;
        String d = "123abc";
        int[] e = {1, 2, 3};

        try {
            int result = a / b;
        } catch (ArithmeticException ex) {
            System.out.println("Ділення на нуль - " + ex.getMessage());
        }

        try {
            int length = c.length();
            System.out.println("Довжина рядка " + length);
        } catch (NullPointerException ex) {
            System.out.println("" + ex.getMessage());
        }

        try {
            int number = Integer.parseInt(d);
            System.out.println("" + number);
        } catch (NumberFormatException ex) {
            System.out.println("Невірний формат числа " + ex.getMessage());
        }

        try {
            int value = e[5];
            System.out.println("" + value);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Вихід за межі масиву  " + ex.getMessage());
        }


    }
}
