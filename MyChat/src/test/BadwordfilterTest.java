package test;

import static org.junit.Assert.*;
import message.Badwordfilter;
import message.ChatMessage;
import message.WriteAble;

import org.junit.Test;

/**
 * @author Simon Wortha
 * @version 20141120
 * 
 *          Testcases zu Badwordfilter
 *
 */
public class BadwordfilterTest {

	/**
	 * Testet on Badwordfilter die Nachricht richtig bearbeitet
	 */
	@Test
	public void test_getString() {
		WriteAble cm = new ChatMessage("test");
		cm = new Badwordfilter(cm);
		assertEquals("test", cm.getString());
	}

	/**
	 * Testet on Badwordfilter die Nachricht richtig bearbeitet
	 */
	@Test
	public void test_getStringWithBadword1() {
		WriteAble cm = new ChatMessage("ARSCH");
		cm = new Badwordfilter(cm);
		assertEquals("****", cm.getString());
	}

	/**
	 * Testet on Badwordfilter die Nachricht richtig bearbeitet
	 */
	@Test
	public void test_getStringWithBadword2() {
		WriteAble cm = new ChatMessage("SCHEISS");
		cm = new Badwordfilter(cm);
		assertEquals("****", cm.getString());
	}

	/**
	 * Testet on Badwordfilter die Nachricht richtig bearbeitet
	 */
	@Test
	public void test_getStringWithBadword3() {
		WriteAble cm = new ChatMessage("DUMBASS");
		cm = new Badwordfilter(cm);
		assertEquals("****", cm.getString());
	}
}
