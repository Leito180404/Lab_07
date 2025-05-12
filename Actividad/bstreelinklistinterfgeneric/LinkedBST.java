package Actividad.bstreelinklistinterfgeneric;

import Actividad.Exceptions.ExceptionEmpty;
import Actividad.Exceptions.ItemDuplicated;
import Actividad.Exceptions.ItemNoFound;
import Actividad.bstreeInterface.BinarySearchTree;

public class LinkedBST<E> implements BinarySearchTree<E> {
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void delete(E data) throws ExceptionEmpty {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
    @Override
    public E search(E data) throws ItemNoFound {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
    
}
