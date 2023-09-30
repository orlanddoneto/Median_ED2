package Program;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import Program.Generic;

public class Main {

	public static void main(String[] args) {

		int lenArray1 = 5; // tamanho do primeiro array
		int lenArray2 = 5; // tamanho do segundo array
		int type = 2; // [1] para inteiros [2] para String

		List<Generic> secondArray = new ArrayList<>();
		List<Generic> firstArray = new ArrayList<>();
		List<Generic> mainArray = new ArrayList<>();
		Random random = new Random();

		switch (type) {
		case 1:
			// gera os dois arrays com valores inteiros
			for (int i = 0; i < lenArray1; i++) {
				firstArray.add(new Generic<Integer>(random.nextInt(100))); // aqui você informa o valor máximo de um elemento do array
			}

			for (int i = 0; i < lenArray2; i++) {
				secondArray.add(new Generic<Integer>(random.nextInt(100))); // aqui você informa o valor máximo de um elemento do array
			}

			break;

		case 2:
			// gera os dois arrays com valores string
			for (int i = 0; i < lenArray1; i++) {
				firstArray.add(new Generic<String>(Services.generateRandomString())); // aqui você informa o valor máximo de um elemento do array
			}
			for (int i = 0; i < lenArray2; i++) {
				secondArray.add(new Generic<String>(Services.generateRandomString())); // aqui você informa o valor máximo de um elemento do array
			}

			break;
		}

		mainArray.addAll(firstArray);
		mainArray.addAll(secondArray);
		int lenMainArray = lenArray1 + lenArray2;

		// Ordena o array usando QuickSort
		QuickSort.ordenar(mainArray, 0, lenMainArray - 1);

		// Imprime o array
		for (int i = 0; i < lenMainArray; i++) {
			System.out.println((i+1)+"º) "+mainArray.get(i).getValue());
		}

		// Imprime a mediana
		System.out.println();
		System.out.println("MEDIANA: ");
		List<Generic> resultMedian = Services.median(mainArray, lenMainArray);

		for (Generic item : resultMedian) {
			System.out.println(item.getValue());
		}

	}

}
