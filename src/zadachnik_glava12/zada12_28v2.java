package zadachnik_glava12;

import java.util.Scanner;

public class zada12_28v2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Задайте квадратную матрицу.");
		System.out.println("Введите количество строк: ");
		int rows = sc.nextInt();
		System.out.println("Введите количество столбцов: ");
		int cols = sc.nextInt();
		sc.close();
		if (rows != cols) {
			return;
		}
		int[][] table = createTable(rows, cols);
		generateData(table);
		printResult(table);
	}

	public static int[][] createTable(int rows, int cols) {
		int[][] result = new int[rows][];
		for (int i = 0; i < result.length; ++i) {
			result[i] = new int[cols];
		}

		return result;
	}

	public static void generateData(int[][] table) {
		final int n = table.length;
		int i = 0, j, k = 0, p = 1;
		while (i < n * n) { // Цикл по номеру витка
			k++;
			for (j = k - 1; j < n - k + 1; j++) { // Определение значений
													// верхнего гор столбца
				table[k - 1][j] = p++;
				i++;
			}
			for (j = k; j < n - k + 1; j++) { // По правому вертикальному
												// столбцу
				table[j][n - k] = p++;
				i++;
			}
			for (j = n - k - 1; j >= k - 1; j--) { // по нижнему горизонтальному
													// столбцу
				table[n - k][j] = p++;
				i++;
			}
			for (j = n - k - 1; j >= k; j--) { // по левому вертикальному
												// столбцу
				table[j][k - 1] = p++;
				i++;
			}
		}

	}

	private static void printResult(int[][] table) {
		for (int i = 0; i < table.length; ++i) {
			for (int j = 0; j < table[i].length; ++j) {
				System.out.printf("%-2d ", table[i][j]);
			}
			System.out.println("\n");
		}

	}
}
