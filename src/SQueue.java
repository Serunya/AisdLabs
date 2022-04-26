public class SQueue {
    private int[] queue;
    private int size;
    private int index = -1;
    public SQueue(int size){
        this.size = size;
        queue = new int[size];
    }
    public void push(int data){
        if(index < size - 1){
            index++;
            queue[index] = data;
        }
    }

    public int pop(){
        if(index > -1){
            int temp = queue[0];
            for(int i = 1;i <= index;i++){
                queue[i-1] = queue[i];
            }
            index--;
            return temp;
        }
        else
        {
            return -1;
        }
    }

    public boolean isEmpty(){
        if (index == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void output_queue(){
        for(int i = 0; i <= index;i++){
            System.out.print(queue[i] + " ");
        }
    }
}
