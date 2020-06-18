package uebung06;

import static org.junit.Assert.*;

import org.junit.Test;

public class Reverser1stTest {

	@Test
	public void test() {
		assertEquals("world Hello", Reverser.reverseSentence("Hello world"));
		assertEquals("you with be force the May", Reverser.reverseSentence("May the force be with you"));
	}

}