package episodio7;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class BarraStrumenti extends JPanel implements ActionListener {
    private JButton buttoneBuongiorno = new JButton("Buongiorno!");
    private JButton buttoneBuonasera = new JButton("Buonasera!");
    private TextAreaPanel textAreaPanel;

    public BarraStrumenti() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        buttoneBuongiorno.addActionListener(this);
        buttoneBuonasera.addActionListener(this);
        add(buttoneBuongiorno);
        add(buttoneBuonasera);
    }

    public void setTextAreaPanel(TextAreaPanel textAreaPanel) {
        this.textAreaPanel = textAreaPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton premuto = (JButton) e.getSource();
        if (premuto == buttoneBuongiorno) {
            textAreaPanel.appendText("Doggy!\n");
        } else if (premuto == buttoneBuonasera) {
            textAreaPanel.appendText("Kitty!\n");
        } 

    }
}
