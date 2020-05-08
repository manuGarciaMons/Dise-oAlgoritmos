 

// Programa Java para encontrar el �nico elemento repetido en una
// matriz de tama�o n y elementos del rango 1 a n-1.


/*
 * Un m�todo eficiente es usar la b�squeda binaria .
1- Comprueba si el elemento del medio es el que se repite.
2- Si no es as�, verifique si el elemento central est� en la posici�n correcta, si es as�, comience a buscar el elemento repetido en la derecha.
3- De lo contrario, la repetici�n estar� a la izquierda.
 * */

 // si existe mas de un elemento repetido con 
 // igual numero de repeticiones, siempre se tendra como referencia el valor mas cercano a la derecha.
  
class ElementoRepetido
{ 

	// Devuelve la posicion de la segunda aparici�n de un elemento repetido
	// La funci�n asume que los elementos de la matriz est�n en el rango de
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

         // Si el elemento medio no est� en su posici�n, eso significa
         // el elemento repetido est� a la izquierda
            return EncontrarElemRepetido(array, minimo, medio-1); 
        } 
      

        // Si medio est� en la posici�n correcta, se repite uno en
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

