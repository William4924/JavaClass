
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WarcasterAssasinationCalculatorTest {

	@Test
	public void SquareOf6Is36() {
		WarcasterAssasinationCalculator test = new WarcasterAssasinationCalculator();
		int output = test.square(6);
		assertEquals(36, output);
	}
}