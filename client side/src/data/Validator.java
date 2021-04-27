package data;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.text.JTextComponent;

public class Validator {

	public static boolean isPresent(JTextComponent c) {
		if (c.getText().length() == 0) {
				showMessage(c,  "is a required field. \nPlease re-enter.");
				c.requestFocusInWindow();
				return false;
			}
			return true;
		}

		private static void showMessage(JTextComponent c, String message) {
			JOptionPane.showMessageDialog(c, message, "Invalid Entry", JOptionPane.ERROR_MESSAGE);
		}
		
		public static boolean isString(JTextComponent c) {
			if(c.getText().matches("[-1234567890]+")) {
				showMessage(c,  "is a letter field. \nPlease re-enter.");
					c.requestFocusInWindow();
					return false;
				}
				return true;
			}
}




