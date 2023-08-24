package views;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPChooseDictionary extends JPanel {

    private JLabel jlDescription;
    private ButtonGroup bgLanguage;
    private JRadioButton jrbEnglish;
    private JRadioButton jrbFrench;

    public JPChooseDictionary(ActionListener listener) {
        this.initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        this.setBorder(new TitledBorder("Diccionario"));
        GridBagConstraints gbcLanguage = new GridBagConstraints();

        gbcLanguage.insets = new Insets(0,5,10,5);

        gbcLanguage.ipadx = 0;
        gbcLanguage.ipady = 0;
        gbcLanguage.gridwidth = GridBagConstraints.REMAINDER;
        jlDescription = new JLabel("SELECCIONE EL IDIOMA (Diccionario a usar)");
        this.add(jlDescription,gbcLanguage);

        gbcLanguage.gridwidth = GridBagConstraints.RELATIVE;
        bgLanguage = new ButtonGroup();
        jrbEnglish = new JRadioButton("Ingles (EN)");
        jrbEnglish.setActionCommand("EnglishDictionary");
        jrbEnglish.addActionListener(listener);
        jrbFrench = new JRadioButton("Frances (FR)");
        jrbFrench.setActionCommand("FrenchDictionary");
        jrbFrench.addActionListener(listener);
        bgLanguage.add(jrbEnglish);
        bgLanguage.add(jrbFrench);

        gbcLanguage.ipadx = 0;
        gbcLanguage.ipady = 1;
        this.add(jrbEnglish,gbcLanguage);

        gbcLanguage.ipadx = 1;
        gbcLanguage.ipady = 1;
        this.add(jrbFrench,gbcLanguage);
    }

    public void setDictionary(int dictionary){
        switch (dictionary) {
            case 1:
                jrbEnglish.setSelected(true);
                break;
            case 2:
                jrbEnglish.setSelected(false);
                break;
        }
    }


}
