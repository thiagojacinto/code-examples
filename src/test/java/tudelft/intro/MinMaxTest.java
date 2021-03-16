package tudelft.intro;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinMaxTest {

	private final MinMax mm = new MinMax();

	@ParameterizedTest
	@MethodSource("generator")
	void validListOfNumbers(int[] nums, int expectedMin, int expectedMax) {
		mm.find(nums);

		assertEquals(expectedMax, mm.getMax());
		assertEquals(expectedMin, mm.getMin());
	}

	private static Stream<Arguments> generator() {
		// list in an descending order
		Arguments tc1 = Arguments.of(new int[]{27, 26, 25}, 25, 27);

		// numbers in random order
		Arguments tc2 = Arguments.of(new int[]{5, 2, 15, 27}, 2, 27);

		// ... what else?
		
		// list of equals
		Arguments tc3 = Arguments.of(new int[]{25,25,25,25}, 25, 25);
		
		// list in an ascending order
		Arguments tc4 = Arguments.of(new int[] {1,2,3}, 1, 3);
		
		// only one argument
		Arguments tc5 = Arguments.of(new int[] {1}, 1, 1);
		
		// only two arguments
		Arguments tc6 = Arguments.of(new int[] {1,2}, 1, 2);
		
		// negative number
		Arguments tc7 = Arguments.of(new int[] {1,2,-3}, -3, 2);
		
		// only a negative number
		Arguments tc8 = Arguments.of(new int[] {-3}, -3, -3);
		
		// min integer value
		Arguments tc9 = Arguments.of(new int[] {1, 10, 20, -5, Integer.MIN_VALUE,}, Integer.MIN_VALUE, 20);
		// max integer value
		Arguments tc10 = Arguments.of(new int[] {1, 10, Integer.MAX_VALUE, 20, -5}, -5, Integer.MAX_VALUE);

		return Stream.of(tc1, tc2, tc3, tc4, tc5, tc6, tc7, tc8, tc9, tc10);
	}
}
