public class Queue {
    private IQueue head;

    public Queue(){
        this.head = null;
    }

    public void push(int data){
        if(head == null){
            head = new IQueue(data);
        }
        else {
            IQueue temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new IQueue(data);
        }
    }

    public int pop(){
        if (head != null) {
            int temp = head.data;
            head = head.next;
            return temp;
        }
        else{
            return -1;
        }
    }

    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        else{
            return false;
        }
    }

    public void output_queue(){
        IQueue temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private class IQueue{
        private int data;
        private IQueue next = null;
        public IQueue(int data){
            this.data = data;
        }
    }
}
