package models;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class DictionaryManagerJSON {
    private String pathESEN = "data/ES_EN_Dictionary.json";
    private String pathESFR = "data/ES_FR_Dictionary.json";
    private Map<String, String> dictionaryES_EN;
    private Map<String, String> dictionaryES_FR;
    private int actualDictionary;

    public DictionaryManagerJSON() {
        dictionaryES_EN = new HashMap<String, String>();
        dictionaryES_FR = new HashMap<String, String>();
        loadData_fromArchive();
    }

    //Métodos de Lectura de Diccionarios Json
    private void loadData_fromArchive() {
        Word[] dicESEN = this.getDictionaryVector(pathESEN);
        Word[] dicESFR = this.getDictionaryVector(pathESFR);
        loadDictionaries(dicESEN, dicESFR);
    }

    private Word[] getDictionaryVector(String file) {
        JsonReader reader = null;
        Word[] dictionary = null;
        try {
            reader = new Gson().newJsonReader(new FileReader(file));
            dictionary = new Gson().fromJson(reader, Word[].class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return dictionary;
    }

    private void loadDictionaries(Word[] dicESEN, Word[] dicESFR) {
        for (int i = 0; i < dicESEN.length; i++) {
            Word word = dicESEN[i];
            addToEnglishDictionary(word.getPalabra(), word.getTranslation());
        }
        for (int i = 0; i < dicESFR.length; i++) {
            Word word = dicESFR[i];
            addToFrenchDictionary(word.getPalabra(), word.getTranslation());
        }
    }

    //Métodos de Escritura de Diccionarios Json
    public void WriteDictionary() {
        this.writeDictionaryFile(dictionaryES_EN, pathESEN);
        this.writeDictionaryFile(dictionaryES_FR, pathESFR);
    }

    private void writeDictionaryFile(Map<String, String> dictionary, String fileOut) {
        try {
            Word[] dictionaryOut = this.createNewDictionary(dictionary);
            String json = new Gson().toJson(dictionaryOut);
            System.out.println(json);

            PrintWriter print = new PrintWriter(fileOut);
            print.write(json);
            print.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Word[] createNewDictionary( Map<String, String> dictionaryIn) {
       Word[] dictionary= new Word[dictionaryIn.size()];int i = 0;
        for (Map.Entry<String, String> dic : dictionaryIn.entrySet()) {
            Word word = new Word(dic.getKey(),dic.getValue());
            dictionary[i++] = word;
        }
        return dictionary;
    }

    //Métodos de Manipulación de diccionarios
    public int getDictionarySize(int dictionary) {
        int sizeDictionary = 0;
        switch (dictionary) {
            case 1:
                sizeDictionary = dictionaryES_EN.size();
                break;
            case 2:
                sizeDictionary = dictionaryES_FR.size();
                break;
        }
        return sizeDictionary;
    }

    public void addToFrenchDictionary(String spanishWord, String translation) {
        dictionaryES_FR.put(spanishWord, translation);
    }

    public void addToEnglishDictionary(String spanishWord, String translation) {
        dictionaryES_EN.put(spanishWord, translation);
    }

    public String searchWordEnglishMeaning(String wordSpanish) throws Exception {
        Object[] keys = dictionaryES_EN.keySet().toArray();
        for (int i = 0; i < dictionaryES_EN.size(); i++) {
            if (((String) keys[i]).equalsIgnoreCase(wordSpanish))
                return dictionaryES_EN.get(keys[i]);
        }
        throw new Exception("Palabra no encontrada");
    }

    public String searchWordFrenchMeaning(String wordSpanish) throws Exception {
        Object[] keys = dictionaryES_FR.keySet().toArray();
        for (int i = 0; i < dictionaryES_FR.size(); i++) {
            if (((String) keys[i]).equalsIgnoreCase(wordSpanish))
                return dictionaryES_FR.get(keys[i]);
        }
        throw new Exception("Palabra no encontrada");
    }

    public int getActualDictionary() {
        return actualDictionary;
    }

    public void setActualDictionary(int actualDictionary) {
        this.actualDictionary = actualDictionary;
    }
}
