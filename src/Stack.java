public class Stack{
    private IStack head;
    public Stack(){
        head = null;
    }

    public void push(int data){
        head = new IStack(data,head);
    }

    public int pop(){
        if (head != null){
            int temp = head.data;
            head = head.prev;
            return temp;
        }
        return -1;
    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        return false;
    }

    public void output_stack(){
        IStack temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    private class IStack{
        private int data;
        private IStack prev;

        private IStack(int data,IStack prev){
            this.data = data;
            this.prev = prev;
        }
    }
}
