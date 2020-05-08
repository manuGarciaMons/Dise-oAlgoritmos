 

// Programa Java para encontrar el único elemento repetido en una
// matriz de tamaño n y elementos del rango 1 a n-1.


/*
 * Un método eficiente es usar la búsqueda binaria .
1- Comprueba si el elemento del medio es el que se repite.
2- Si no es así, verifique si el elemento central está en la posición correcta, si es así, comience a buscar el elemento repetido en la derecha.
3- De lo contrario, la repetición estará a la izquierda.
 * */

 // si existe mas de un elemento repetido con 
 // igual numero de repeticiones, siempre se tendra como referencia el valor mas cercano a la derecha.
  
class ElementoRepetido
{ 

	// Devuelve la posicion de la segunda aparición de un elemento repetido
	// La función asume que los elementos de la matriz están en el rango de
	// 1 a n-1.
    static int EncontrarElemRepetido(int array[], int minimo, int maximo) 
    { 
        // minimo = 0 , maximo = n-1; 
        if (minimo > maximo) 
            return -1; 
       
        int medio = (minimo + maximo) / 2; 
       
        // Comprueba si el elemento medio es el que se repite
        if (array[medio] != medio + 1) 
        { 
            if (medio > 0 && array[medio]==array[medio-1]) 
                return medio; 

         // Si el elemento medio no está en su posición, eso significa
         // el elemento repetido está a la izquierda
            return EncontrarElemRepetido(array, minimo, medio-1); 
        } 
      

        // Si medio está en la posición correcta, se repite uno en
       // derecho.
        return EncontrarElemRepetido(array, medio+1, maximo); 
    } 
      
    
    public static void main(String[] args)  
    { 
        int  array[] = {1,1,2, 3, 3, 4, 5}; 
        int index = EncontrarElemRepetido(array, 0, array.length-1); 
        if (index != -1) 
        	
            System.out.println("Elemento que mas se repete : "+array[index]); 
    } 
} 

