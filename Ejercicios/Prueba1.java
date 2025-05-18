package Ejercicios;

import Actividad.Exceptions.ExceptionEmpty;
import Actividad.Exceptions.ItemDuplicated;
import Actividad.Exceptions.ItemNoFound;

public class Prueba1 {
    public static void main(String[] args) throws ItemNoFound, ExceptionEmpty {
    LinkedBST<String> bst = new LinkedBST<>();

    try {
        bst.insert("Sales");
        bst.insert("Domestic");
        bst.insert("International");
        bst.insert("Canada");
        bst.insert("S. America");
        bst.insert("Overseas");
        bst.insert("Africa");
        bst.insert("Europe");
        bst.insert("Asia");
        bst.insert("Australia");

        System.out.println("Visualizacion con parentesis:");
        bst.parenthesize();

    } catch (ItemDuplicated e) {
        System.out.println("Error: " + e.getMessage());
    }
}
}
