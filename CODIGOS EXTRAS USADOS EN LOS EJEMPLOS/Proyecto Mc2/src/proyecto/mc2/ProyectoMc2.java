package proyecto.mc2;  

import java.util.LinkedList; 
import java.util.Queue; 

class Nodos { 
    int data; 
    Nodos left, right; // Las Referencias de los nodos izquierdo y derecho

    public Nodos(int item) { // Constructor de la clase Nodos
        data = item;
        left = right = null;
    }
}

class BinarioArbol { 
    Nodos root; // Raíz del árbol

    void printLevelOrder() { // Método para realizar la búsqueda en anchura 
        
        Queue<Nodos> queue = new LinkedList<Nodos>(); // Crear una cola para almacenar nodos
        queue.add(root); // Agregar la raíz a la cola
        while (!queue.isEmpty()) { // Mientras la cola no esté vacía
            Nodos tempNode = queue.poll(); // Sacar el primer nodo de la cola
            System.out.print(tempNode.data + " "); // Imprimir el valor del nodo
            if (tempNode.left != null) { // Si hay un nodo izquierdo, agregarlo a la cola
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) { // Si hay un nodo derecho, agregarlo a la cola
                queue.add(tempNode.right);
            }
        }
    }

    void printInorder(Nodos nodos) { // Método para realizar la búsqueda en profundidad 
        if (nodos == null) { // Si el nodo es nulo, retornar
            return;
        }
        printInorder(nodos.left); // Recursivamente imprimir el subárbol izquierdo
        System.out.print(nodos.data + " "); // Imprimir el valor del nodo actual
        printInorder(nodos.right); // Recursivamente imprimir el subárbol derecho
    }
}

public class ProyectoMc2 { 
    
    public static void main(String[] args) { 
        
        BinarioArbol tree = new BinarioArbol(); 
        
        tree.root = new Nodos(1); // Crear la raíz del árbol con valor 1
        tree.root.left = new Nodos(2); // Crear un nodo izquierdo con valor 2
        tree.root.right = new Nodos(3); // Crear un nodo derecho con valor 3
        tree.root.left.left = new Nodos(4); // Crear un nodo izquierdo del nodo izquierdo con valor 4
        tree.root.left.right = new Nodos(5); // Crear un nodo derecho del nodo izquierdo con valor 5

        System.out.println("Busqueda en Arbol por ancho:"); // Imprimimos el  mensaje
        tree.printLevelOrder(); // Llamamos al método de búsqueda en anchura

        System.out.println("\nBusqueda en Arbol por profundidad:"); // Imprimimos el  mensaje
        tree.printInorder(tree.root); // Llamamos al método de búsqueda en profundidad
    }
}
