import java.util.*;
public class BuildBST {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }

    public static Node insert(Node root , int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){//left subtree
            root.left = insert(root.left, val);
        }else{
            //right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static boolean searchInBST(Node root , int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }else if(root.data > key){
            return searchInBST(root.left, key);
        }else{
            return searchInBST(root.right, key);
        }
    }

    public static Node deleteInBST(Node root , int val){
        if(root.data > val){
            root.left = deleteInBST(root.left, val);
        }else if(root.data < val){
           root .right =  deleteInBST(root.right, val);
        }else{
            if(root.left==null && root.right==null){
                return null;
            }else if(root.right==null){
                return root.left;
            }else if(root.left==null){
                return root.right;
            }else{
                Node IS =  inorderSuccessor(root.right);
                root.data = IS.data;
                root.right = deleteInBST(root.right, IS.data);
            }
        }
        return root;
    }

    public static Node inorderSuccessor(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root , int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }else if(root.data < k1){
            printInRange(root.right, k1, k2);
        }else{
            printInRange(root.left, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size();i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println("Null");
    }

    public static void printRoot2Leaf(Node root , ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root , Node min , Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }
        else if(max!=null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Node mirrorBST(Node root){
        if(root==null){
            return null;
        }
        Node leftST = mirrorBST(root.left);
        Node rightST = mirrorBST(root.right);

        root.left = rightST;
        root.right = leftST;

        return root;
    }

    public static void main(String[] args) {
        int[] values={8,5,3,6,10,11};
        Node root = null;
        for(int i=0; i<values.length;i++){
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();
        // System.out.println(searchInBST(root, 5));
        // root = deleteInBST(root, 5);
        // inOrder(root);
        // printInRange(root, 6, 9);
        // printRoot2Leaf(root, new ArrayList<>());
        // if(isValidBST(root, null, null)){
        //     System.out.println("Valid");
        // }else{
        //     System.out.println("Not Valid");
        // }

        root = mirrorBST(root);
        inOrder(root);

    }
}
