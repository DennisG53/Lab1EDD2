package com.example.denni.lab1edd2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Arbol {

    public class Nodo {
        public Nodo(Character clave) {
            this.clave = clave;
        }

        public Character clave;

    }

    public Arbol(Nodo drecho, Nodo izquierdo, Nodo aux) {
        Derecho = drecho;
        Izquierdo = izquierdo;
        Aux = aux;
    }

    //---------------------Nodos----------------------
    public Nodo Derecho;
    public Nodo Izquierdo;
    public Nodo Aux;
    //-------------------Fin Nodos---------------------



    public Character IngresoArbol(List<Character> Ingresos){


        List<Character> Listado = new ArrayList<Character>();

        Collections.sort(Ingresos); //ordena la lista de nodos

        Character DatoDerecho= Ingresos.get(0);
        Ingresos.remove(0);
        Nodo derecho = new Nodo(DatoDerecho);

        Character DatoIzquierdo= Ingresos.get(0);
        Ingresos.remove(0);
        Nodo izquierdo = new Nodo(DatoIzquierdo);

        Nodo DatosPadre = new Nodo();


    }

    public Nodo ResultadPadres(Nodo izq, Nodo der){

    }



}
