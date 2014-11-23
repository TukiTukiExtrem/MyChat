package message;

/**
 * @author Wortha Simon
 * @version 20141121
 *
 *          Wendet bei der NAchricht toUpperCase an
 */
public class UpperCase extends Decorator {

	private WriteAble wa;

	/**
	 * @param w
	 *            will ein ChatMessage Objekt das erweitert wird
	 */
	public UpperCase(WriteAble w) {
		this.wa = w;
	}

	/**
	 * Macht die eingegebene Nachricht UpperCase (non-Javadoc)
	 * 
	 * @see message.Decorator#getString()
	 */
	@Override
	public String getString() {
		return this.wa.getString().toUpperCase();
	}
}
