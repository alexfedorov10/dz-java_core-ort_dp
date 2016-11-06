import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		int[] mas = new int[10];

		for (int i = 0; i < mas.length; i++) {
			mas[i] = (int) (Math.random() * 11);
			System.out.print(" | " + mas[i] + " |");
		}
		for (int j = 0; j < mas.length; j = j + 2) {
			int d = mas.length - 1;
			int temp = mas[j];
			mas[j] = mas[d - j];
			mas[d - j] = temp;
		}
		System.out.print("\nCopy   = ");
		System.out.println(Arrays.toString(mas));

	}
}
