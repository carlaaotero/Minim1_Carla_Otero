package edu.upc.dsa;


import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Pilot;


import java.util.List;

public interface VuelosManager {
    public List<Dron> ordenarLlistaDrones(List<Dron> llistaDrones);
    public List<Dron> LListatLlistaDrones();
    public List<Pilot> ordenarLlistaPilots(List<Pilot> llistaPilots);
    public List<Pilot> LListatLlistaPilots();
    public void afegirReserva(Dron dron, String data, String hora, String horesReserva, String posicioInici, String posicioDesti, Pilot pilot);
}
