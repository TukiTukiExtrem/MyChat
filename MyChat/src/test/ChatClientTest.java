package test;

import static org.junit.Assert.*;

import org.junit.Test;

import connection.ChatClient;

/**
 * @author Samuel Schober
 *
 */
public class ChatClientTest {

	/**
	 * 
	 */
	@Test
	public void test() {
		ChatClient chat = new ChatClient(null, 0);
		
		assertEquals(1, chat);
	}

}
