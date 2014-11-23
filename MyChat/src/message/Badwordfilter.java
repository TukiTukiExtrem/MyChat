package message;

import java.util.ArrayList;

/**
 * @author Wortha Simon
 * @version 20141121
 *
 *          Wendet bei der Nachricht den Badwordfilter an
 */
public class Badwordfilter extends Decorator {
	private WriteAble wa;

	/**
	 * @param w
	 *            will ein ChatMessage Objekt das erweitert wird
	 */
	public Badwordfilter(WriteAble w) {
		this.wa = w;
	}

	@Override
	public String getString() {
		ArrayList<String> badwords = new ArrayList<String>();
		badwords.add("Arsch");
		badwords.add("scheiss");
		badwords.add("dumbass");

		String message = wa.getString();

		for (String s : badwords) {
			message = message.replace(s, "****");
		}
		return message;
	}
}
