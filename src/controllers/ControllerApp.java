package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.DictionaryManagerJSON;
import views.JFDictionaryMain;

public class ControllerApp implements ActionListener {
    private DictionaryManagerJSON dictionary;
    private JFDictionaryMain jfDictionaryMain;

    public ControllerApp() {
        initApp();
    }

    private void initApp(){
        jfDictionaryMain = new JFDictionaryMain(this);
        dictionary = new DictionaryManagerJSON();
        dictionary.setActualDictionary(1);
        jfDictionaryMain.setDictionary(1);
        jfDictionaryMain.setNumberWords(dictionary.getDictionarySize(1));
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        String source = event.getActionCommand();
        switch (source) {
            case "EnglishDictionary":
                englishTranslate();
                break;
            case "FrenchDictionary":
                frenchTranslate();
                break;
            case "Translate":
                setTranslate();
                break;
            //Listener para Agregar Palabra
            case "AddWordIntermediary":
                addWord();
                break;
            case "AddWordToDictionary":
                addWordToDictionary();
                break;
            case "CancelAction":
                cancelAction();
                break;
        }
    }

    private void setTranslate() {
        try {
            String translation = "";
            String wordSearch = jfDictionaryMain.getSpanishWord();
            switch (dictionary.getActualDictionary()) {
                case 1:
                    translation = dictionary.searchWordEnglishMeaning(wordSearch);
                    jfDictionaryMain.setTranslate(translation);
                    break;
                case 2:
                    translation = dictionary.searchWordFrenchMeaning(wordSearch);
                    jfDictionaryMain.setTranslate(translation);
                    break;
            }
        } catch (Exception e) {
            jfDictionaryMain.showError(e.getMessage());
        }
    }

    private void englishTranslate() {
        try {
            dictionary.setActualDictionary(1);
            this.setDictionary(1);
            jfDictionaryMain.setNumberWords(dictionary.getDictionarySize(1));
        } catch (Exception e) {
            jfDictionaryMain.showError(e.getMessage());
        }
    }

    private void frenchTranslate() {
        try {
            dictionary.setActualDictionary(2);
            this.setDictionary(2);
            jfDictionaryMain.setNumberWords(dictionary.getDictionarySize(2));
        } catch (Exception e) {
            jfDictionaryMain.showError(e.getMessage());
        }
    }

    private void addWord() {//Metodo Intermediario (Clase Boton) que activa los listeners del JDialog y lo abre
        jfDictionaryMain.setAddWord(true);
    }

    private void addWordToDictionary() {
        int actualDictionary = dictionary.getActualDictionary();
        try {
            if(actualDictionary == 1)
                dictionary.addToEnglishDictionary(jfDictionaryMain.getWordES(), jfDictionaryMain.getTranslation());
            if(actualDictionary == 2)
                dictionary.addToFrenchDictionary(jfDictionaryMain.getWordES(), jfDictionaryMain.getTranslation());
            dictionary.WriteDictionary();
        } catch (Exception e1) {
            jfDictionaryMain.showError(e1.getMessage());
        }
        jfDictionaryMain.setNumberWords(dictionary.getDictionarySize(actualDictionary));
        jfDictionaryMain.setAddWord(false);
        showConfirmation();
    }

    private void showConfirmation() {
        jfDictionaryMain.showConfirmation();
    }

    private void cancelAction(){
        jfDictionaryMain.cancelAction();
    }

    private void setDictionary(int dictionary){
        jfDictionaryMain.setDictionary(dictionary);
    }
}
