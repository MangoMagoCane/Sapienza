package episodio6;

import java.awt.BorderLayout;

import javax.swing.*;

public class TextAreaPanel extends JPanel {
    private JTextArea textArea = new JTextArea();

    public TextAreaPanel() {
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public void appendText(String text) {
        textArea.append(text);
    }

}
