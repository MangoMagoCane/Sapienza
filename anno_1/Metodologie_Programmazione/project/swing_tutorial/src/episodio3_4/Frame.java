package episodio3_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private JTextArea textArea = new JTextArea();
    private JTextField textField = new JTextField();
    private JButton button = new JButton("Clicammi!");

    public Frame() {
        super("Titolo");
        setLayout(new BorderLayout());

        button.addActionListener((ActionEvent e) -> {
            String textFieldText = textField.getText();
            if (textFieldText.equals("")) return;
            textArea.append(textFieldText + "\n");
            textField.setText("");
        });

        add(textArea, BorderLayout.CENTER);
        add(textField, BorderLayout.PAGE_START);
        add(button, BorderLayout.PAGE_END);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
