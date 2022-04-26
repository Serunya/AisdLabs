public class List<B> {
    element<B> head;
    int size;

    public List(){
        head = null;
        size = 0;
    };

    public List(B data){
        head = new element<B>(data);
        size = 1;
    }


    public boolean insert(B data, int pos){
        if(pos > size){
            return false;
        }
        if(pos == 0){
            element temp = new element<B>(data);
            temp.next = head;
            head = temp;
            size++;
            return true;
        }
        element temp = head;
        for(int i = 0; i < pos-1;i++){
            temp = temp.next;
        }
        element new_temp = new element<B>(data);
        new_temp.next = temp.next;
        temp.next = new_temp;
        size++;
        return true;
    }

    public boolean earse(int pos){
        if (pos >= size | pos < 0)
            return false;
        if(pos == 0){
            head = head.next;
            return true;
        }
        element temp = head;
        for(int i = 1; i < pos;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return true;
    }

    public void push_down(B data){
        element temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new element(data);
    }

    public void push_front(B data){
        element temp = new element<B>(data);
        temp.next = head;
        head = temp;
    }

    public B pop_down(){
        if(head == null){
            return null;
        }
        if(head.next == null){
            B temp = head.data;
            head = null;
            return temp;
        }
        element temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        B t = (B) temp.next.data;
        temp.next = null;
        return t;
    }

    public B pop_front(){
        B temp = head.data;
        head = head.next;
        return temp;
    }

    public void output_list(){
        if(head == null){
            System.out.println("Лист пуст!");
            return;
        }
        System.out.print("Лист( " + head.data);
        element temp = head.next;
        while(temp != null){
            System.out.print(", " + temp.data);
            temp = temp.next;
        }
        System.out.println(" )");
    }

    private class element<B>{
        B data;
        element<B> next;

        element(B data){
            this.data = data;
            this.next = null;
        }
    }

    public void clean(){
        head = null;
    }
}
