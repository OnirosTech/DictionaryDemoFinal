package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JFDictionaryMain extends JFrame {

    private JPChooseDictionary jpChooseDictionary;
    private JPTranslatorPanel jpTranslatorPanel;
    private JDAddTranslate jdAddTranslate;
    private JPNumberWords jpNumberWords;
    private JPAddWord jpAddWord;

    public JFDictionaryMain(ActionListener listener) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Diccionario ES -> EN/FR");
        this.setLayout(new GridBagLayout());
        this.setSize(350,410);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        GridBagConstraints gbcMain = new GridBagConstraints();

        gbcMain.insets = new Insets(15,3,0,3);

        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        jpChooseDictionary = new JPChooseDictionary(listener);
        add(jpChooseDictionary,gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 1;
        jpTranslatorPanel = new JPTranslatorPanel(listener);
        add(jpTranslatorPanel,gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 2;
        jpNumberWords = new JPNumberWords();
        add(jpNumberWords,gbcMain);

        gbcMain.gridx = 0;
        gbcMain.gridy = 3;
        jpAddWord = new JPAddWord(listener);
        add(jpAddWord,gbcMain);

        jdAddTranslate = new JDAddTranslate(listener);
    }

    public void setDictionary(int dictionary){
        jpChooseDictionary.setDictionary(dictionary);
    }

    public String getWordES() throws Exception {
        return jdAddTranslate.getSpanishWord();
    }

    public String getTranslation() throws Exception {
        return jdAddTranslate.getTranslationWord();
    }

    public void setNumberWords(int dictionarySize) {
        jpNumberWords.setJlWordTotal(dictionarySize);
    }

    public void setAddWord(boolean state){//listener dedicado para JDialog
        jdAddTranslate.dispose();
        jdAddTranslate.setVisible(state);
    }

    public void cancelAction(){//Cierra el JDialog y cancela cualquier accion
        jdAddTranslate.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jdAddTranslate.dispose();
    }

    public String getSpanishWord() throws Exception {
        return jpTranslatorPanel.getText();
    }

    public void setTranslate(String translatedWord) {
        jpTranslatorPanel.setText(translatedWord);
    }

    public void showError(String message) {
        Object[] options = {"OK"};
        JOptionPane.showOptionDialog(null, message, "Error",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
                null, options, options[0]);
    }

    public void showConfirmation() {
        Object[] options = {"OK"};
        JOptionPane.showOptionDialog(null, "Palabra agregada correctamente", "Agregado",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
    }

}
