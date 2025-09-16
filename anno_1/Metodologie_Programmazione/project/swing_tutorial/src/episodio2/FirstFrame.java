package episodio2;

import javax.swing.*;

public class FirstFrame extends JFrame {
    public FirstFrame() {
        super("La nostra prima finesta");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
