package configuration;

import java.util.ArrayList;
import java.util.List;

public class Prueba {
    public static void main(String[] args) {
//        List <String> cadenas = new ArrayList<>();
//        cadenas.add("Auria");
//        cadenas.add("Alejandra");
//        cadenas.add("Anette");
//        cadenas.add("Janet");
//        cadenas.add("César");
//        
//        System.out.println("obtener elemento 1 (0)");
//        System.out.println(cadenas.get(0));
//        
////        System.out.println("Eliminar pos 0, o sea 1");
////        cadenas.remove(0);
//        
//        int sizeList = cadenas.size();
//        System.out.println("Tamaño: " + sizeList);
//        
//        System.out.println("posición: " + cadenas.get(sizeList-1)); //siempre devuelve el útlimo elemento
//        
//        for (int i = 0; i < sizeList; i++) {
//            System.out.println("posición: " + (i + 1) + " " + "elemento: " + cadenas.get(i));
//        }
//        
//        System.out.println("vaciar todo");
//        cadenas.clear();
//        if(cadenas.isEmpty()) {
//            System.out.println("está vacía y pues no hay nada, true");
//        } else {
//            System.out.println("no está vacía");
//        }
        System.out.println("");
        double total = 0.0;
        //prueba
        double array[] = {1457.0, 364.0, 728.0};
        for (int i = 0; i < array.length; i++) {
            total = total + array[i];
        }
        System.out.println("total " + total);
        
        double t = 0.0;
        List<Double> precios = new ArrayList<>();
        precios.add(1457.0);
        precios.add(728.0);
        precios.add(364.0);
        
        for (int i = 0; i < precios.size(); i++) {
            t = t + precios.get(i);
        }
        System.out.println("totaal " + t);
    }
}
