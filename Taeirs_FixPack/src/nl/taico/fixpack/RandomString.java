package nl.taico.fixpack;

import java.util.Random;

public class RandomString {
	private static final char[] symbols = new char[26];
	static {
		for (int idx = 0; idx < 26; ++idx) {
			symbols[idx] = (char) ('a' + idx);
		}
	}

	private final Random random = new Random();
	private final char[] buf;

	public RandomString(int length) {
		if (length < 1) throw new IllegalArgumentException("length < 1: " + length);
		buf = new char[length];
	}

	public String nextString() {
		for (int idx = 0; idx < buf.length; ++idx){
			buf[idx] = symbols[random.nextInt(symbols.length)];
			if (buf[idx] == '\0') idx--;
		}
		return new String(buf);
	}

	public static char randomChar() {
		return (char) ('a' + (new Random()).nextInt(26));
	}
}
