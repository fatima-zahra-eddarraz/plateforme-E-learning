package learn;



import javax.swing.*;
import java.io.IOException;

public class InternetImpl implements Plateform {

	public void CheckadminLogin() throws IOException {
		System.out.println("dkhalna");
		Main m = new Main();
		JOptionPane.showMessageDialog(null, "Username and password correct");
		m.changeScene("platform.fxml");
	}

	public void CheckStudentLogin() throws IOException {
		Main m = new Main();
		m.changeScene("pltstudent.fxml");
	}

	public void RegistreStudent() throws IOException {
		JOptionPane.showMessageDialog(null, "Registration validate");
	}
}
