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
        private static Queue stack;
        private static SQueue sstack;
        public static void MainMenu() throws IOException {
            System.out.println("Выберите форму физического представления очереди.\n1)Цепное представление очереди\n" +
                    "2)Сплошное представление очереди");
            int choice = (char)System.in.read();
            if(choice == '1'){
                stack = new Queue();
                Queue();
            }
            if(choice == '2'){
                System.out.print("Введите кол-во элементов в стеке: ");
                System.in.skip(10);
                choice = (int) System.in.read();
                sstack = new SQueue(choice);
                SQueue();
            }
        }
        private static void Queue() throws IOException {
            System.out.println("Выберите какое действие хотите сделать с очередью\n" +
                    "1)Добавить элемент в очередь\n" +
                    "2)Достать последний элемент\n" +
                    "3)Вывести очередь\n" +
                    "4)Проверить на пустоту");
            System.in.skip(2);
            int choice = (char) System.in.read();
            switch (choice){
                case ('1'):
                    System.out.print("Введите элемент очереди: ");
                    Scanner scanner = new Scanner(System.in);
                    int num = scanner.nextInt();
                    stack.push(num);
                    Queue();
                    break;
                case ('2'):
                    System.out.println("Достали элемент: " + stack.pop());
                    Queue();
                    break;
                case ('3'):
                    System.out.println("Очередь: ");
                    stack.output_queue();
                    Queue();
                    break;
                case ('4'):
                    System.out.println("Очередь пуста: " + stack.isEmpty());
                    Queue();
                    break;
            }
        }

        private static void SQueue() throws IOException {
            System.out.println("Выберите какое действие хотите сделать с очередью\n" +
                    "1)Добавить элемент в очередь\n" +
                    "2)Достать последний элемент\n" +
                    "3)Вывести очередь\n" +
                    "4)Проверить на пустоту");
            System.in.skip(2);
            char choice = (char) System.in.read();
            switch (choice){
                case ('1'):
                    System.out.print("Введите элемент очереди: ");
                    Scanner scanner = new Scanner(System.in);
                    int num = scanner.nextInt();
                    sstack.push(num);
                    SQueue();
                    break;
                case ('2'):
                    System.out.println("Достали элемент: " + sstack.pop());
                    SQueue();
                    break;
                case ('3'):
                    System.out.print("Очередь: ");
                    sstack.output_queue();
                    System.out.println();
                    SQueue();
                    break;
                case ('4'):
                    System.out.println("Очередь пуста: " + sstack.isEmpty());
                    SQueue();
                    break;
            }
        }

    }
}

