import java.util.Arrays;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        int[] precio = { 1,	5,	8,	9,	10,	17,	17,	20,	24,	30 };
        System.out.println("Longitudes disponibles: 1,2,3,4,5,6,7,8,9,10");
        System.out.println("Precios: 1,5,8,9,10,17,17,20,24,30");
        Scanner entrada = new Scanner (System.in);
		System.out.println("Ingrese el valor n (Longitud) de la varilla en un rango de 1-10");
        System.out.println();
        int tam = entrada.nextInt();
        main r = new main();
        r.maximoBeneficio(precio,tam);
    }

    public void maximoBeneficio(int[] precio, int tam){
        int columnas = tam;
        int filas = tam;

        int[][] matrix =  new int[filas+1][columnas+1];
        for(int i=0; i <=filas; i++){
            matrix[i][0] = 0;
        }
        for(int i=0; i <=columnas; i++){
            matrix[0][i] = 0;
        }

        for(int i=1; i <=filas; i++){
            for(int j=1; j<=columnas; j++) {
                if (j >= i){
                    matrix[i][j] = Math.max(matrix[i-1][j],precio[i-1]+matrix[i][j-i]);
                }else{
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }
        System.out.println("Matriz de Iteraciones");
        for(int i=0; i <=filas; i++){
            for(int j=0; j <=filas; j++) {
                System.out.print(matrix[i][j]+" ");
                
            }
           
            System.out.println();
        }
       
        System.out.println("El mayor beneficio para una logitud: "+tam+" es: "+matrix[filas][columnas]);
    }
}
