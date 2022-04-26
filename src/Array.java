public class Array {
    int[] list;
    private int index;
    private int size;
    public int counter;

    private Array(){};

    public Array(int size){
        this.size = size;
        list = new int[size];
        this.index = -1;
        this.counter = 0;
    }

    public boolean insert(int data, int pos){
        if(pos > size | pos < 0)
            return false;
        if(index == size - 1)
            return false;
        if(pos > index + 1) {
            list[++index] = data;
            return true;
        }
        for(int i=index;i >= pos;i--){
            list[i+1] = list[i];
            counter++;
        }
        list[pos] = data;
        index++;
        return true;
    }

    public boolean earase(int pos){
        if(pos > size | pos < 0)
            return false;
        for(int i = pos;i < index;i++){
            list[i] = list[i+1];
            counter++;
        }
        index--;
        return true;
    }

    public boolean push_down(int data){
        if(index >= size - 1)
            return false;
        list[++index] = data;
        return true;
    }

    public void output_list(){
        if(index == -1) {
            System.out.println("Лист пуст");
            return;
        }
        System.out.print("Лист( " + list[0]);
        for(int i = 1; i < index;i++){
            System.out.print( ", " + list[i]);
        }
        System.out.println(" )");
    }

    public void anigilatornaya_pushka_AAAAAAAAAAAAAAAAAAAAA(){
        for(int i = 0; i < size;i++){
            list[i] = 0;
        }
        index = -1;
    }

}
