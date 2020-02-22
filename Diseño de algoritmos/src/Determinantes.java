import java.util.Scanner;

public class Determinantes
{
	
   // algunas de las conclusiones que se pueden sacar es que el algoritmo 1, es mas eficiente que el 2.
	// es importante aclarar que en ambos metodos en los que la solucion es trabajar con una matrix nxn, se utiliza la 
	// recursividad, si embargo varian algunos recorridos en el algoritmo.
	//El recorrido de ambos algoritmos se basa en dividir la matriz nxn en sub matrices que permiten ser evaluadas
	// por medio de las posiciones que abarcan en el arreglo.
   // private double[][] matriz;
	
	int matriz [][];
    
 public Determinantes(int[][] matriz) {
	}

public static void main(String args[]) {
	
	 long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
	 TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
	  
 
 Scanner entrada = new Scanner(System.in);
 
  System.out.println("Introduzca el valor deseado para la matriz");
  int tamanno = entrada.nextInt(), i, j;
  int matriz[][] = new int[tamanno][tamanno];
  for (i=0;i<tamanno;i++)
  {
   for (j=0;j<tamanno;j++)
   {
    matriz[i][j] = (int)(Math.random()*10)-5;
   }
  }

  imprimirMatriz(matriz);
  System.out.println("tiempo ejecucion:");
  System.out.println(System.currentTimeMillis()-TInicio);
  System.out.println(determinante(matriz));
  
  
  System.out.println("*****************************************");
  imprimirMatriz(matriz);
  System.out.println("tiempo ejecucion:");
  System.out.println(System.currentTimeMillis()-TInicio);
  System.out.println(determinanteGauss(matriz));
  

  
  TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
  tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
  System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //
 }


// imprime la matriz en pantalla, de acuerdo al tamaño seleccionado por pantalla
 public static void imprimirMatriz(int matriz[][])
 {
  int i, j;
  for (i=0;i<matriz.length;i++)
  {
   for (j=0;j<matriz.length;j++)
    System.out.print(String.valueOf(matriz[i][j]) + "\t");
   System.out.println();
  }
  System.out.println();
 }

 
 //para el primer algoritmo, partir la matriz en en pedazos de 4 posiciones
 public static int[][] subMatrices(int matriz[][], int x, int y)
 {
  int submatriz[][] = new int[matriz.length-1][matriz.length-1];
  int i, j, cur_x=0, cur_y=0;
  for (i=0;i<matriz.length;i++)
  {
   if (i != x)
   {
    cur_y=0;
    for (j=0;j<matriz.length;j++)
    {
     if (j != y)
     {
      submatriz[cur_x][cur_y] = matriz[i][j];
      cur_y++;
     }
    }
    cur_x++;
   }
  }
  return submatriz;
 }

 

 /**
 
  *
  * @param matrix A double[][] 
 * @return determinante de la matriz
  */

 
 public static int determinante(int matriz[][])
 {
  int deter=0;
  int i, mult = 1;
  if (matriz.length > 2)
  {
   for (i=0;i<matriz.length;i++)
   {
    deter += mult * matriz[i][0] * determinante(subMatrices(matriz,i,0));
    mult *= -1;
   }
   return deter;
  }else
   return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
 }
 
 
 public static int determinanteGauss(int[][] matriz)
 {
     int det;
     if(matriz.length==2)
     {
         det=(matriz[0][0]*matriz[1][1])-(matriz[1][0]*matriz[0][1]);
         return det;
     }
     int suma=0;
     for(int i=0; i<matriz.length; i++){
   int[][] nm =new int[matriz.length-1][matriz.length-1];
         for(int j=0; j<matriz.length; j++){
             if(j!=i){
                 for(int k=1; k<matriz.length; k++){
                 int indice=-1;
                 if(j<i)
                 indice=j;
                 else if(j>i)
                 indice=j-1;
                 nm[indice][k-1]=matriz[j][k];
                 }
             }
         }
         if(i%2==0)
         suma+=matriz[i][0] * determinanteGauss(nm);
         else
         suma-=matriz[i][0] * determinanteGauss(nm);
     }
     return suma;
 }


 
	}

