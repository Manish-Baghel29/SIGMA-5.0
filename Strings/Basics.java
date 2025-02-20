public class Basics{
    public static void main(String[] args) {
        String m="abba";
        StringBuilder n=new StringBuilder("");
        for(int i=0;i<m.length();i++){
            char k=(char)(m.charAt(i)+1);
            n.append(k);
        }
        System.out.println(n);
        
    }
}