package models;

public class Word {

    private String palabra;
    private String translation;

    public Word(){}

    public Word(String palabra, String translation){
        this.palabra = palabra;
        this.translation = translation;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("***** Word *****\n");
        sb.append("Palabra en ES = " +getPalabra()+"\n");
        sb.append("Traduccion = " +getTranslation()+"\n");
        return sb.toString();
    }
}
