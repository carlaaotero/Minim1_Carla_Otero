package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Track {

/*Atributs de la classe*/
    String id;
    String title;
    String singer;
    static int lastId; //variable estàtica per emmagatzemar l'últim ID generat

/*Constructor que genera un ID únic utilitzant la classe RandomUtils*/
    public Track() {

        this.id = RandomUtils.getId();
    }

/*Constructor amb paràmetres per inicialitzar el títol i el cantant de la pista*/
    public Track(String title, String singer) {
        this(); //crida al primer constructor per inicialitzar l'ID
        this.setSinger(singer); //estableix el cantant a la pista
        this.setTitle(title); //estableix el títol a la pista
    }

/*Mètodes getter i setter*/
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id=id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

/*Mètode toString per obtenir una representació de cadena de la pista*/
    @Override
    public String toString() {
        return "Track [id="+id+", title=" + title + ", singer=" + singer +"]";
    }

}