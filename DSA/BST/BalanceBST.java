import java.util.*;
public class BalanceBST {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static Node sortedArr2BST(int[] arr,int st , int ed){
        if(st>ed){
            return null;
        }
        int mid = (st+ed)/2;
        Node root = new Node(arr[mid]);
        root.left = sortedArr2BST(arr, st, mid-1);
        root.right = sortedArr2BST(arr, mid+1, ed);

        return root;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,7,8,10,11,12};
        Node root  = sortedArr2BST(arr, 0, arr.length-1);
        inorder(root);
    }
}
