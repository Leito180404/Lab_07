package Ejercicios;

import Actividad.Exceptions.ExceptionEmpty;
import Actividad.Exceptions.ItemDuplicated;
import Actividad.Exceptions.ItemNoFound;


public class Prueba {
    public static void main(String[] args) throws ItemNoFound, ExceptionEmpty {
        LinkedBST<Integer> bst1 = new LinkedBST<>();
        LinkedBST<Integer> bst2 = new LinkedBST<>();

        try {
            bst1.insert(100);
            bst1.insert(50);
            bst1.insert(200);
            bst1.insert(75);
            bst1.insert(400);

            bst2.insert(80);
            bst2.insert(30);
            bst2.insert(120);
            bst2.insert(90);
            bst2.insert(500);

            System.out.println("Area BST1: " + bst1.areaBST());
            System.out.println("Area BST2: " + bst2.areaBST());

            boolean sameArea = sameArea(bst1, bst2);
            System.out.println("Tienen misma area? " + sameArea);

        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static <E extends Comparable<E>> boolean sameArea(LinkedBST<E> tree1, LinkedBST<E> tree2) {
        try {
            return tree1.areaBST() == tree2.areaBST();
        } catch (Exception e) {
            System.out.println("Error al calcular area: " + e.getMessage());
            return false;
        }
    }

}

