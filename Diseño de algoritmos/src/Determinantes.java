import java.util.Scanner;

class Determinantes
{
 public static void main(String args[]) {
 
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

  System.out.println(determinante(matriz));
 }

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
}
