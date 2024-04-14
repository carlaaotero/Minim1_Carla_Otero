package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Dron {
    /*Atributs de la classe*/
    String idDron;
    String nomDron;
    String fabricant;
    String model;
    public int horesDron;


    public Dron() {

    }

    /*Constructor amb paràmetres per inicialitzar el nom del dron, el fabricant i el model*/
    public Dron(String idDron, String nomDron, String fabricant, String model, int horesDron){
        this.setIdDron(idDron);
        this.setNomDron(nomDron);
        this.setFabricant(fabricant);
        this.setModel(model);
        this.setHoresDron(horesDron);
    }

    /*Mètodes de setters i getters dels atributs*/
    public String getIdDron() {
        return idDron;
    }

    public void setIdDron(String idDron) {
        this.idDron = idDron;
    }

    public String getNomDron() {
        return nomDron;
    }

    public void setNomDron(String nomDron) {
        this.nomDron = nomDron;
    }

    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHoresDron() {
        return horesDron;
    }

    public void setHoresDron(int horesDron) {
        this.horesDron = 0;
    }

}
