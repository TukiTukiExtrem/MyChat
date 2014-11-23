package test;

import static org.junit.Assert.*;
import message.ChatMessage;
import message.UpperCase;
import message.WriteAble;

import org.junit.Test;

/**
 * @author Simon Wortha
 * @version 20141120
 *
 *          Testcases zu UpperCase
 */
public class UpperCaseTest {

	/**
	 * Testet um getString die Nachricht richtig bearbeitet
	 */
	@Test
	public void test_getString() {
		WriteAble cm = new ChatMessage("test");
		cm = new UpperCase(cm);
		assertEquals("TEST", cm.getString());
	}

	/**
	 * Testet um getString die Nachricht richtig bearbeitet
	 */
	@Test
	public void test_getStringSonderzeichen() {
		WriteAble cm = new ChatMessage("!");
		cm = new UpperCase(cm);
		assertEquals("!", cm.getString());
	}
}
