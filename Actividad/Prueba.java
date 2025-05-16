package Actividad;
import Actividad.Exceptions.ExceptionEmpty;
import Actividad.Exceptions.ItemDuplicated;
import Actividad.Exceptions.ItemNoFound;
import Actividad.bstreelinklistinterfgeneric.LinkedBST;

public class Prueba {
    public static void main(String[] args) {
        LinkedBST<Integer> bst = new LinkedBST<>();

        System.out.println("¿Esta vacio? " + bst.isEmpty());

        try {
            bst.insert(100);
            bst.insert(50);
            bst.insert(200);
            bst.insert(75);
            bst.insert(400);
            bst.insert(700);

            System.out.println("BST InOrder: " + bst.toString());
            System.out.println("BST PreOrder: " + bst.toStringPreOrder());
            System.out.println("BST PostOrder: " + bst.toStringPostOrder());

            System.out.println("Buscar 75: " + bst.search(75));
            System.out.println("Buscar 400: " + bst.search(400));

            System.out.println("Eliminar 75");
            bst.delete(75);
            System.out.println("BST InOrder despues de eliminar 75: " + bst.toString());

            System.out.println("Eliminar 100");
            bst.delete(100);
            System.out.println("BST InOrder despues de eliminar 100: " + bst.toString());

            System.out.println("Eliminar 400");
            bst.delete(400);
            System.out.println("BST InOrder despues de eliminar 400: " + bst.toString());

            System.out.println("¿Esta vacio? " + bst.isEmpty());

        } catch (ItemDuplicated | ItemNoFound | ExceptionEmpty e) {
            System.out.println("Error detectado: " + e.getMessage());
        }
    }
}

