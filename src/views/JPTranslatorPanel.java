package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class JPTranslatorPanel extends JPanel {
    private JLabel jlWordES;
    private JLabel jlTranslated;
    private JLabel jlWordTranslated;
    private JButton jbTranslate;
    private JTextField jtfWordES;

    public JPTranslatorPanel(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        this.setBorder(new TitledBorder("Traductor"));
        GridBagConstraints gbcTrans = new GridBagConstraints();

        gbcTrans.anchor = GridBagConstraints.WEST;
        gbcTrans.insets = new Insets(0,5,10,5);

        gbcTrans.gridx = 0;
        gbcTrans.gridy = 0;
        gbcTrans.gridwidth = 2;
        jlWordES = new JLabel("PALABRA EN ESPAÑOL (ES): ");
        add(jlWordES,gbcTrans);

        gbcTrans.gridx = 0;
        gbcTrans.gridy = 1;
        gbcTrans.gridwidth = 1;
        gbcTrans.fill = GridBagConstraints.BOTH;
        jtfWordES = new JTextField(15);
        add(jtfWordES,gbcTrans);

        gbcTrans.fill = GridBagConstraints.NONE;
        gbcTrans.insets = new Insets(0,0,10,5);

        gbcTrans.gridx = 1;
        gbcTrans.gridy = 1;
        gbcTrans.gridwidth = 1;
        jbTranslate = new JButton("TRADUCIR");
        jbTranslate.setActionCommand("Translate");
        jbTranslate.addActionListener(listener);
        add(jbTranslate,gbcTrans);

        gbcTrans.insets = new Insets(0,5,10,5);
        gbcTrans.gridx = 0;
        gbcTrans.gridy = 2;
        gbcTrans.gridwidth = 2;
        jlTranslated = new JLabel("TRADUCCIÓN: ");
        add(jlTranslated,gbcTrans);

        gbcTrans.gridx = 0;
        gbcTrans.gridy = 3;
        gbcTrans.gridwidth = 2;
        jlWordTranslated = new JLabel("Aqui va la traducción");
        add(jlWordTranslated,gbcTrans);

    }

    //COMPLEMENTAR por el metodo que acxtiva el boton solo cuando la casilla esta llena
    public String getText() throws Exception {
        if (jtfWordES.getText().equals(""))
            throw new Exception("Campo de palabra vacio, por favor introduzca una palabra");
        else
            return jtfWordES.getText();
    }

    public void setText(String word) {
        jlWordTranslated.setText(word);
    }

}
