package episodio6;

import java.awt.FlowLayout;

import javax.swing.*;

public class BarraStrumenti extends JPanel {
    private JButton buttoneBuongiorno = new JButton("Buongiorno!");
    private JButton buttoneBuonasera = new JButton("Buonasera!");

    public BarraStrumenti() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(buttoneBuongiorno);
        add(buttoneBuonasera);
    }
}
