package Program;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

public class QuickSort {

	private static long movimentacoes = 0L;
	private static long comparacoes = 0L;

	public static void ordenar(List<Generic> list, int ini, int fim) {
		comparacoes++;
		if (ini < fim) {
			int pivot = partition(list, ini, fim);

			ordenar(list, ini, pivot - 1);
			ordenar(list, pivot + 1, fim);
		}
	}

	private static int partition(List<Generic> list, int ini, int fim) {
		Generic pivot = list.get(fim);
		int i = ini - 1;

		for (int j = ini; j < fim; j++) {
			comparacoes++;
			if (list.get(j).compareTo(pivot) < 0) {
				i++;
				movimentacoes++;
				Collections.swap(list, i, j);
			}
		}
		movimentacoes++;
		Collections.swap(list, i + 1, fim);
		return i + 1;
	}
}
