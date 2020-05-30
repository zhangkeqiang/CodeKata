package kata.kata12;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Isomorphic {
	public boolean check(String one, String another) {
		return Arrays.equals(normalized(one), normalized(another));
	}

	private List<Integer> distinctChars(String one) {
		return one.chars().distinct().boxed().collect(toList());
	}

	protected int[] normalized(String one) {
		return one.chars().map(distinctChars(one)::indexOf).toArray();
	}
}
