package message;

/**
 * @author Wortha Simon
 * @version 20141119
 *
 *          Die Nachricht, also der reine Text der gesendet wird
 */
public class ChatMessage implements WriteAble {
	private String message;

	/**
	 * @param text
	 */
	public ChatMessage(String text) {
		this.message = text;
	}

	@Override
	public String getString() {
		return message;
	}

}
