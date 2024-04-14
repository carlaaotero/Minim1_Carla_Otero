package edu.upc.dsa;


import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Pilot;
import edu.upc.dsa.models.PlanDeVuelo;


import java.util.List;

public interface VuelosManager {
    public void afegirDron(String idDron, String nomDron, String fabricant, String model, int horesDron);
    public void afegirPilot(String idPilot, String nomPilot, String cognomPilot, int horesPilot);
    public List<Dron> ordenarLlistaDrones(List<Dron> llistaDrones);
    public List<Pilot> ordenarLlistaPilots(List<Pilot> llistaPilots);
    public void afegirReserva(String idDron, String dia, String hora, String horesReserva, String posicioInici, String posicioDesti, String idPilot, String idPlanDeVuelo);
    public List<PlanDeVuelo> llistaReservesPilot(String idPilot);
    public List<PlanDeVuelo> llistaReservasDron (String idDron);

}
