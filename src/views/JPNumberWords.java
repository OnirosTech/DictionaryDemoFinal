package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class JPNumberWords extends JPanel{

    JLabel jlNumbWordsActualDictionary;
    JLabel jlWordTotal;

    public JPNumberWords() {
        //this.setBorder(new EmptyBorder(10,10,10,10));
        initComponents();
    }

    private void initComponents() {
        jlNumbWordsActualDictionary = new JLabel("# Palabras del Diccionario Actual: ");

        jlWordTotal = new JLabel("0");

        add(jlNumbWordsActualDictionary);
        add(jlWordTotal);
    }

    public void setJlWordTotal(int total) {
        jlWordTotal.setText(String.valueOf(total));
    }
}
