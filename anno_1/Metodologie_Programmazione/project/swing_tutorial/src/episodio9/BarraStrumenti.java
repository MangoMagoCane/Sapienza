package episodio9;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class BarraStrumenti extends JPanel implements ActionListener {
    private JButton buttoneBuongiorno = new JButton("Buongiorno!");
    private JButton buttoneBuonasera = new JButton("Buonasera!");
    private TextListener textListener;

    public BarraStrumenti() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        buttoneBuongiorno.addActionListener(this);
        buttoneBuonasera.addActionListener(this);
        add(buttoneBuongiorno);
        add(buttoneBuonasera);
    }

    public void setTextListener(TextListener textListener) {
        this.textListener = textListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (textListener == null) {
            return;
        }

        JButton premuto = (JButton) e.getSource();

        if (premuto == buttoneBuongiorno) {
            textListener.testoEmesso("Buongiorno!\n");
        } else if (premuto == buttoneBuonasera) {
            textListener.testoEmesso("Buonasera!\n");
        }
    }
}
