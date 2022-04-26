import java.io.IOException;
import java.util.Scanner;

public class Main {
    static List<Integer> list = new List<Integer>();
    static Array array;

    public static void main(String[] args) {
        try {
            menu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void menu() throws IOException {
        System.out.println("Выберите цепное или сплошное представление списка" +
                "\n1) Цепное представление" +
                "\n2) Сплошное представление");
        char choice = (char) System.in.read();
        switch (choice){
            case ('1'):
                LIST();
                break;
            case ('2'):
                create_array();
                break;
        }
    }

    private static void LIST() throws IOException {
        System.out.println("Выберите что хотите сделать со списком" +
                "\n1)Добавить элемент" +
                "\n2)Удалить элемент" +
                "\n3)Вывести список" +
                "\n4)Удалить список");
        System.in.skip(2);
        char choice = (char) System.in.read();
        Scanner scanner = new Scanner(System.in);
        switch (choice){
            case('1'):
                System.out.println("Введите элемент: ");
                int data = scanner.nextInt();
                System.out.println("Введите позицию: ");
                int pos = scanner.nextInt();
                list.insert(data,pos);
                break;
            case('2'):
                System.out.println("Введите позицию: ");
                pos = scanner.nextInt();
                list.earse(pos);
                break;
            case ('3'):
                list.output_list();
                break;
            case ('4'):
                list.clean();
                break;
        }
        LIST();
    }

    private static void create_array(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер листа: ");
        int size = scanner.nextInt();
        array = new Array(size);
        try {
            ARRAY();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ARRAY() throws IOException {
        System.out.println("Выберите что хотите сделать со списком" +
                "\n1)Добавить элемент" +
                "\n2)Удалить элемент" +
                "\n3)Вывести список" +
                "\n4)Удалить список");
        System.in.skip(2);
        char choice = (char) System.in.read();
        Scanner scanner = new Scanner(System.in);
        switch (choice){
            case('1'):
                System.out.println("Введите элемент: ");
                int data = scanner.nextInt();
                System.out.println("Введите позицию: ");
                int pos = scanner.nextInt();
                array.insert(data,pos);
                break;
            case('2'):
                System.out.println("Введите позицию: ");
                pos = scanner.nextInt();
                array.earase(pos);
                break;
            case ('3'):
                array.output_list();
                break;
            case ('4'):
                array.anigilatornaya_pushka_AAAAAAAAAAAAAAAAAAAAA();
                break;
        }
        ARRAY();
    }

}
