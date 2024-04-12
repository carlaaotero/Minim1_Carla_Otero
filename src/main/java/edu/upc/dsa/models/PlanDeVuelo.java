package edu.upc.dsa.models;
import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Pilot;

public class PlanDeVuelo {
    /*Atributs de la classe*/
    String idDron;
    String dia;
    String hora;
    String horesReserva;
    String posicioInici;
    String posicioDesti;
    String nomPilot;

    /*Constructor amb paràmetres per inicialitzar*/
    public PlanDeVuelo(String idDron, String dia, String hora, String horesReserva, String posicioInici, String posicioDesti, String nomPilot){
        this.setIdDron(idDron);
        this.setDia(dia);
        this.setHora(hora);
        this.setHoresReserva(horesReserva);
        this.setPosicioInici(posicioInici);
        this.setPosicioDesti(posicioDesti);
        this.setNomPilot(nomPilot);
    }

    /*Mètodes de setters i getters dels atributs*/

    public String getIdDron() {
        return idDron;
    }

    public void setIdDron(String idDron) {
        this.idDron = idDron;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getHoresReserva() {
        return horesReserva;
    }

    public void setHoresReserva(String horesReserva) {
        this.horesReserva = horesReserva;
    }

    public String getPosicioInici() {
        return posicioInici;
    }

    public void setPosicioInici(String posicioInici) {
        this.posicioInici = posicioInici;
    }

    public String getPosicioDesti() {
        return posicioDesti;
    }

    public void setPosicioDesti(String posicioDesti) {
        this.posicioDesti = posicioDesti;
    }

    public String getNomPilot() {
        return nomPilot;
    }

    public void setNomPilot(String nomPilot) {
        this.nomPilot = nomPilot;
    }
}
