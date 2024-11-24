package a;
import javax.swing.JOptionPane;
public class ChoosingOption{
	public static void main(String[] args) {
		String[] options = { "I do", "I don't"};
	    int selection = JOptionPane.showOptionDialog(null, "Select one:", "Let's play a game!", 
	                                                      0, 2, null, options, options[0]);
	    if (selection == 0) {
	      JOptionPane.showMessageDialog(null, "You chose I do !");
	    }
	    if (selection == 1) { 
	      JOptionPane.showMessageDialog(null, "You chose I don't !");
	    }
	}
}
