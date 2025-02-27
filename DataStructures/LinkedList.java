public class LinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){ //add node before the starting node
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    public void addLast(int data){ //add node after the last node
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }

    public void add(int idx,int data){ //add a node at given index
        Node newNode=new Node(data);
        size++;
        if(idx==0){
            newNode.next=head;
            head=newNode;
            return;
        }
        Node temp=head;
        for(int i=0;i<idx-1;i++){
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public int removeFirst(){
        int val;
        if(head==null){
            System.out.println("Linkedlist is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            size=0;
            val=head.data;
            head=tail=null;
            return val;
        }
        size--;
        val=head.data;
        head=head.next;
        return val;
    }

    public int removeLast(){
        int val;
        if(head==null){
            System.out.println("Linkedlist is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            size=0;
            val=head.data;
            head=tail=null;
            return val;
        }
        Node prevNode=head;
        for(int i=0;i<size-2;i++){
            prevNode=prevNode.next;
        }
        size--;
        val=prevNode.next.data;
        prevNode.next=null;
        tail=prevNode;
        return val;
    } 

    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        // ll.print();
        ll.add(2, 3);
        ll.print();
        System.out.println(ll.removeFirst());
        ll.print();
        System.out.println(ll.removeLast());
        ll.print();
        System.out.println(size);
    }
}
