import java.util.Scanner;

public class main {

	public static int mayorBeneficio(int[] valor, int tamaño) {
		int[] solucion = new int[tamaño + 1];
		solucion[0] = 0;

		for (int i = 1; i <= tamaño; i++) {
			int max = -1;
			for (int j = 0; j < i; j++) {
				max = Math.max(max, valor[j] + solucion[i - (j + 1)]);
				solucion[i] = max;
			}
		}
		return solucion[tamaño];
	}

	public static void main(String[] args) {
		int[] value = { 1, 5, 8, 9, 10,17, 17, 20, 24,30 };
		Scanner entrada = new Scanner (System.in);
		System.out.println("Ingrese el valor n (Longitud) de la varilla");
		int len = entrada.nextInt();
		System.out.println("El mayor beneficio es " + len + ":"
				+ mayorBeneficio(value, len));

	}

}