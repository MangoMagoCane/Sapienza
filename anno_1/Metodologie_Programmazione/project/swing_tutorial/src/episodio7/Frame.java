package episodio7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private TextAreaPanel textAreaPanel = new TextAreaPanel();
    private JButton button = new JButton("Clicammi!");
    private BarraStrumenti barraStrumenti = new BarraStrumenti();

    public Frame() {
        super("Titolo");
        setLayout(new BorderLayout());

        barraStrumenti.setTextAreaPanel(textAreaPanel);

        button.addActionListener((_) -> {
            textAreaPanel.appendText("ciao!\n");
        });

        add(barraStrumenti, BorderLayout.PAGE_START);
        add(textAreaPanel, BorderLayout.CENTER);
        add(button, BorderLayout.PAGE_END);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
