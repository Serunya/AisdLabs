public class SStack {
    private int[] stack;
    private int index;
    private int size;

    public SStack(int size){
        stack = new int[size];
        index = -1;
        this.size = size;
    }

    public void push(int data){
        if (index < size - 1){
            index++;
            stack[index] = data;
        }
    }

    public int pop(){
        if(index > -1 ){
            return stack[index--];
        }
        else{
            return -1;
        }
    }

    public boolean isEmpty(){
        if (index == -1){
            return true;
        }
        else{
            return false;
        }
    }

    public void output_stack(){
        int temp = index;
        while(temp != -1){
            System.out.print(stack[temp] + " ");
            temp--;
        }
    }
}
