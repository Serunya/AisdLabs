import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Menu.MainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Menu{
        private static Stack stack;
        private static SStack sstack;
        public static void MainMenu() throws IOException {
            System.out.println("Выберите форму физического представления стека.\n1)Цепное представление стека\n" +
                    "2)Сплошное представление стека");
            int choice = (char)System.in.read();
                if(choice == '1'){
                    stack = new Stack();
                    Stack();
                }
                if(choice == '2'){
                    System.out.print("Введите кол-во элементов в стеке: ");
                    System.in.skip(10);
                    choice = (int) System.in.read();
                    sstack = new SStack(choice);
                    SStack();
                }
        }
        private static void Stack() throws IOException {
            System.out.println("Выберите какое действие хотите сделать со стеком\n" +
                    "1)Добавить элемент в стек\n" +
                    "2)Достать последний элемент\n" +
                    "3)Вывести стек\n" +
                    "4)Проверить на пустоту");
            System.in.skip(2);
            int choice = (char) System.in.read();
            switch (choice){
                case ('1'):
                    System.out.print("Введите элемент стека: ");
                    Scanner scanner = new Scanner(System.in);
                    int num = scanner.nextInt();
                    stack.push(num);
                    Stack();
                    break;
                case ('2'):
                    System.out.println("Достали элемент: " + stack.pop());
                    Stack();
                    break;
                case ('3'):
                    System.out.println("Стек: ");
                    stack.output_stack();
                    Stack();
                    break;
                case ('4'):
                    System.out.println("Стек пуст: " + stack.isEmpty());
                    Stack();
                    break;
            }
        }

        private static void SStack() throws IOException {
            System.out.println("Выберите какое действие хотите сделать со стеком\n" +
                    "1)Добавить элемент в стек\n" +
                    "2)Достать последний элемент\n" +
                    "3)Вывести стек\n" +
                    "4)Проверить на пустоту");
            System.in.skip(2);
            char choice = (char) System.in.read();
            switch (choice){
                case ('1'):
                    System.out.print("Введите элемент стека: ");
                    Scanner scanner = new Scanner(System.in);
                    int num = scanner.nextInt();
                    sstack.push(num);
                    SStack();
                    break;
                case ('2'):
                    System.out.println("Достали элемент: " + sstack.pop());
                    SStack();
                    break;
                case ('3'):
                    System.out.print("Стек: ");
                    sstack.output_stack();
                    System.out.println();
                    SStack();
                    break;
                case ('4'):
                    System.out.println("Стек пуст: " + sstack.isEmpty());
                    SStack();
                    break;
            }
        }

    }
}
