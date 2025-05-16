package Actividad.bstreelinklistinterfgeneric;

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

    @Override
    public void delete(E data) throws ExceptionEmpty {
        if (root == null) {
            throw new ExceptionEmpty("El arbol esta vacio.");
        }
        root = deleteNode(root, data);
    }

    private Node deleteNode(Node node, E data) {
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
            throw new UnsupportedOperationException("");
        }
        return node;
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

    private String toStringRec(Node node) {
        if (node == null) {
            return "";
        }
        return toStringRec(node.left) + node.data + " " + toStringRec(node.right);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
    
    
}
