package Actividad.bstreeInterface;

import Actividad.Exceptions.ExceptionEmpty;
import Actividad.Exceptions.ItemDuplicated;
import Actividad.Exceptions.ItemNoFound;

public interface BinarySearchTree<E> {   
    void insert(E data) throws ItemDuplicated;
    E search(E data) throws ItemNoFound;
    void delete(E data) throws ExceptionEmpty;
    boolean isEmpty();
}
