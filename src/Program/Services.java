package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Services {

	protected static String generateRandomString() {
		String chars = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(7);

		Random random = new Random();
		for (int i = 0; i < 7; i++) {
			int index = random.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}

		return sb.toString();
	}

	protected static List<Generic> median(List<Generic> list, int tam) {
		int meio = list.size() / 2;
		List<Generic> lisTemp = new ArrayList<>();

		if (list.get(0).getValue().getClass().equals(Integer.class)) {
			if (tam % 2 == 0) {
				Integer temp1 = (Integer) (list.get(meio - 1).getValue());
				Integer temp2 = (Integer) (list.get(meio).getValue());
				Double media = (double) ((temp1 + temp2) / 2);
				lisTemp.add(new Generic<Double>(media));
			} else {
				lisTemp.add(list.get(meio));
			}
		}

		else if(list.get(0).getValue().getClass().equals(String.class)) {
			if (tam % 2 == 0) {
				Generic temp1 = list.get(meio - 1);
				Generic temp2 = list.get(meio);
				lisTemp.add(temp2);
				lisTemp.add(temp1);

			} else {
				lisTemp.add(list.get(meio));
			}
		}
		return lisTemp;
	}

}
