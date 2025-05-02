import java.lang.annotation.Native;

public class StackLL {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static class Stack {
        static Node head=null;
        public static boolean isEmpty(){
            return head==null;
        }
        public static void push(int data){
            Node newNode=new Node(data);
            if(isEmpty()){
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int val=head.data;
            head=head.next;
            return val;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            int val=head.data;
            return val;
        }
    }
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Stack s=new Stack();
        s.push(100);
        s.push(13);
        s.push(300);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
