package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JDAddTranslate extends JDialog implements KeyListener {
    private JLabel jlWordES;
    private JLabel jlTranslation;
    private JTextField jtfWordES;
    private JTextField jtfTranslate;
    private JPanel jpContainer;
    private JButton jbCancelTranslation;
    public JButton jbAddWordTranslation;

    public JDAddTranslate(ActionListener listener) {
        initComponents(listener);
        this.setVisible(false);
        this.setLocationRelativeTo(null);
        this.jtfTranslate.addKeyListener(this);
        this.jtfWordES.addKeyListener(this);
    }

    private void initComponents(ActionListener listener) {
        //this.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        this.setTitle("Agregar Traducción a Diccionario Actual");
        this.setSize(265,210);
        this.setResizable(false);

        jpContainer = new JPanel(new GridBagLayout());
        GridBagConstraints gbcJD = new GridBagConstraints();

        gbcJD.insets = new Insets(0,5,10,5);
        gbcJD.fill = GridBagConstraints.BOTH;
        gbcJD.gridwidth = GridBagConstraints.REMAINDER;

        gbcJD.ipadx = 0;
        gbcJD.ipady = 0;
        jlWordES = new JLabel("Palabra en Español");
        jpContainer.add(jlWordES,gbcJD);

        gbcJD.ipadx = 0;
        gbcJD.ipady = 1;
        jtfWordES = new JTextField(20);
        jpContainer.add(jtfWordES,gbcJD);

        gbcJD.ipadx = 0;
        gbcJD.ipady = 2;
        jlTranslation= new JLabel("Traducción");
        jpContainer.add(jlTranslation,gbcJD);

        gbcJD.ipadx = 0;
        gbcJD.ipady = 3;
        jtfTranslate = new JTextField(1);
        jpContainer.add(jtfTranslate,gbcJD);

        gbcJD.ipadx = 0;
        gbcJD.ipady = 4;
        gbcJD.gridwidth = 1;
        gbcJD.fill = GridBagConstraints.NONE;
        jbAddWordTranslation = new JButton("Agregar");
        jbAddWordTranslation.setActionCommand("AddWordToDictionary");
        jbAddWordTranslation.addActionListener(listener);
        jbAddWordTranslation.setEnabled(false);
        jpContainer.add(jbAddWordTranslation,gbcJD);

        gbcJD.ipadx = 1;
        gbcJD.ipady = 4;
        jbCancelTranslation = new JButton("Cancelar");
        jbCancelTranslation.setActionCommand("CancelAction");
        jbCancelTranslation.addActionListener(listener);
        jpContainer.add(jbCancelTranslation,gbcJD);

        this.add(jpContainer);
    }

    public String getSpanishWord() throws Exception {
        if (jtfWordES.getText().equals(""))
            throw new Exception("Campo Español vacio, introduzca una palabra");
        else
            return jtfWordES.getText();
    }

    public String getTranslationWord() throws Exception {
        if(jtfTranslate.getText().equals(""))
            throw new Exception("Campo de traducción vacio, introduzca una palabra");
        else
            return jtfTranslate.getText();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }
    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        jbAddWordTranslation.setEnabled(!jtfWordES.getText().equals("") && !jtfTranslate.getText().equals(""));
    }

    @Override
    public void dispose() {
        clearFields();
        super.dispose();
    }

    public void clearFields() {
        jtfWordES.setText("");
        jtfTranslate.setText("");
    }
}
