public class Basics{ //String reversal by words
    public static void main(String[] args) {
        String m="Sky is Blue";
        String word[] = m.trim().split(" ");
        for(int i=word.length-1;i>=0;i--){
            System.out.print(word[i]+" ");
        }
    }
}