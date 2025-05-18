package Ejercicios;
import Actividad.Exceptions.ExceptionEmpty;
import Actividad.Exceptions.ItemDuplicated;
import Actividad.Exceptions.ItemNoFound;
import Actividad.bstreeInterface.BinarySearchTree;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    public class Node {
        public E data;
        public Node left;
        public Node right;
    
        public Node(E data){
            this (data, null, null);
        }

        public Node(E data, Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    public LinkedBST(){
        this.root = null;
    }


    @Override
    public void insert(E data) throws ItemDuplicated {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node current = root;
        Node parent = null;
        while (current != null) {
            int cmp = data.compareTo(current.data);
            if (cmp == 0) {
                throw new ItemDuplicated("El dato " + data + " ya existe en el arbol.");
            }
            parent = current;
            if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (data.compareTo(parent.data) < 0) {
            parent.left = new Node(data);
        } else {
            parent.right = new Node(data);
        }
    }

    @Override
    public E search(E data) throws ItemNoFound {
        Node current = root;
        while (current != null) {
            int cmp = data.compareTo(current.data);
            if (cmp == 0) {
                return current.data;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        throw new ItemNoFound("El dato " + data + " no se encontro en el arbol.");
    }
    private StringBuilder sb;

    private void inOrder(Node node) {
    if (node != null) {
        inOrder(node.left);
        if (sb.length() > 0) {
            sb.append(" ");
        }
        sb.append(node.data);
        inOrder(node.right);
        }
    }

    @Override
    public String toString() {
        sb = new StringBuilder();
        inOrder(root);
        return sb.toString();
    }

    private void preOrder(Node node) {
    if (node != null) {
        if (sb.length() > 0) {
            sb.append(" ");
        }
        sb.append(node.data);
        preOrder(node.left);
        preOrder(node.right);
        }
    }

    public String toStringPreOrder() {
        sb = new StringBuilder();
        preOrder(root);
        return sb.toString();
    }

    private void postOrder(Node node) {
    if (node != null) {
        postOrder(node.left);
        postOrder(node.right);
        if (sb.length() > 0) {
            sb.append(" ");
        }
        sb.append(node.data);
        }
    }

    public String toStringPostOrder() {
    sb = new StringBuilder();
    postOrder(root);
    return sb.toString();
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
    
    private Node findNode(E data) throws ItemNoFound {
        return findNodeRec(root, data);
    }

    private Node findNodeRec(Node node, E data) throws ItemNoFound {
        if (node == null) {
            throw new ItemNoFound("El dato " + data + " no se encontro en el arbol.");
        }
        int cmp = data.compareTo(node.data);
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return findNodeRec(node.left, data);
        } else {
            return findNodeRec(node.right, data);
        }
    }

    private E findMinNode(Node node) throws ItemNoFound {
        if (node == null) {
            throw new ItemNoFound("El subarbol esta vacio.");
        }
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        search(current.data);
        return current.data;
    }

    private E findMaxNode(Node node) throws ItemNoFound {
        if (node == null) {
            throw new ItemNoFound("El subarbol esta vacio.");
        }
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        search(current.data);
        return current.data;
    }

    @Override
    public void delete(E data) throws ExceptionEmpty {
        if (root == null) {
            throw new ExceptionEmpty("El arbol esta vacio.");
        }
        try {
            root = deleteNode(root, data);
        } catch (ItemNoFound e) {
            throw new RuntimeException(e);
        }
    }

    private Node deleteNode(Node node, E data) throws ItemNoFound{
        if (node == null) {
            return null; 
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = deleteNode(node.left, data);
        } else if (cmp > 0) {
            node.right = deleteNode(node.right, data);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            }

            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            if (node.left != null && node.right != null) {
                E minData = findMinNode(node.right);
                node.data = minData;
                node.right = deleteNode(node.right, minData);
            }
        }
        return node;
    }
    //ejercicio 1.a
    public void destroyNodes() throws ExceptionEmpty {
    if (root == null) {
        throw new ExceptionEmpty("El arbol ya esta vacio.");
    }
    root = null;
    }

    //ejercicio 1.b
    public int countAllNodes() {
        return countAllNodesRec(root);
    }
    //ejercicio 1.b
    private int countAllNodesRec(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }
        return 1 + countAllNodesRec(node.left) + countAllNodesRec(node.right);
    }

    //ejercicio 1.c
    public int countNodes() {
        return countNodesRec(root);
    }
    //ejercicio 1.c
    private int countNodesRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodesRec(node.left) + countNodesRec(node.right);
    }

    //ejercicio 1.d
    public int height(E x) {
        Node start;
        try {
            start = findNode(x);
        } catch (ItemNoFound e) {
            return -1;
        }
        if (start == null) return -1;

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(start);
        int height = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        return height;
    }

    //ejercicio 1.e
    public int amplitud(int nivel) {
        if (root == null || nivel < 0) return 0;
        if (nivel > height(root.data)) return 0;

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
        if (currentLevel == nivel) {
            return size;
        }
        for (int i = 0; i < size; i++) {
            Node current = queue.poll();
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        currentLevel++;
    }
        return 0;
    }

    //ejercicio 2.a
    public int areaBST() {
        if (root == null) return 0;

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        int hojas = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
        if (current.left == null && current.right == null) {
            hojas++;
        }
        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);
        }

        int altura = height(root.data);
        return hojas * altura;
    }
}
