package edu.upc.dsa.models;
import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Pilot;
import edu.upc.dsa.util.RandomUtils;

public class PlanDeVuelo {
    /*Atributs de la classe*/
    String idDron;
    String dia;
    String hora;
    String horesReserva;
    String posicioInici;
    String posicioDesti;
    String idPilot;
    String idPlanDeVuelo;


    public PlanDeVuelo() {

    }

    /*Constructor amb paràmetres per inicialitzar*/
    public PlanDeVuelo(String idPlanDeVuelo, String idDron, String dia, String hora, String horesReserva, String posicioInici, String posicioDesti, String idPilot){
        this.setIdPlanDeVuelo(idPlanDeVuelo);
        this.setIdDron(idDron);
        this.setDia(dia);
        this.setHora(hora);
        this.setHoresReserva(horesReserva);
        this.setPosicioInici(posicioInici);
        this.setPosicioDesti(posicioDesti);
        this.setIdPilot(idPilot);

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

    public String getIdPilot() {
        return idPilot;
    }

    public void setIdPilot(String idPilot) {
        this.idPilot = idPilot;
    }

    public String getIdPlanDeVuelo() {
        return idPlanDeVuelo;
    }

    public void setIdPlanDeVuelo(String idPlanDeVuelo) {
        this.idPlanDeVuelo = idPlanDeVuelo;
    }
}
