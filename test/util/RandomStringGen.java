package util;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public final class RandomStringGen {
	
	private static final int SIZE = 10;
	
	private RandomStringGen () {}
	
	private final static Random random = new Random();
	
	public final static String randomStringAllCharsNotEmpty () {
		return RandomStringUtils.random(random.nextInt(SIZE) + 1);
	}
	
	public final static String randomStringAlphabetNotEmpty () {
		return RandomStringUtils.randomAlphabetic(random.nextInt(SIZE) + 1);
	}
	
	public final static String randomStringAlphaNumericNotEmpty () {
		return RandomStringUtils.randomAlphanumeric(random.nextInt(SIZE) + 1);
	}

}
