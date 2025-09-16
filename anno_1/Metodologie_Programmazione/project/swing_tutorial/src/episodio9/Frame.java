package episodio9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private TextAreaPanel textAreaPanel = new TextAreaPanel();
    private BarraStrumenti barraStrumenti = new BarraStrumenti();
    private PannelloForm pannelloForm = new PannelloForm();

    public Frame() {
        super("Titolo");
        setLayout(new BorderLayout());

        barraStrumenti.setTextListener((testo) -> {
            textAreaPanel.appendText(testo);
        });

        add(barraStrumenti, BorderLayout.PAGE_START);
        add(pannelloForm, BorderLayout.LINE_START);
        add(textAreaPanel, BorderLayout.CENTER);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
