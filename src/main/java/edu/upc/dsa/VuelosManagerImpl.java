package edu.upc.dsa;

import edu.upc.dsa.models.PlanDeVuelo;
import org.apache.log4j.Logger;
import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Pilot;


import java.util.List;


public class VuelosManagerImpl implements VuelosManager {

    /*Declaració de variables*/
    final static Logger logger = Logger.getLogger(VuelosManagerImpl.class);
    protected List<Dron> llistaDrones;
    protected List<Pilot> llistaPilots;
    private List<PlanDeVuelo> reservas;

    /*Mètodes per llistar els drons ordenats descendentment per hores de vol*/
    public List<Dron> ordenarLlistaDrones(List<Dron> llistaDrones) {
    int n= llistaDrones.size();
    for (int i = 0; i<n-1; i++){
        for (int j =0; j<n-i-1; j++){
            if (llistaDrones.get(j).getHoresDron() < llistaDrones.get(j+1).getHoresDron()){
                Dron a = llistaDrones.get(j);
                llistaDrones.set(j, llistaDrones.get(j+1));
                llistaDrones.set(j+1, a);
            }
        }
    }
        return llistaDrones;
    }
    public List<Dron> LListatLlistaDrones() {
        List<Dron> dronsOrdenats = ordenarLlistaDrones(llistaDrones);
        return dronsOrdenats;
    }


    /*Mètodes per llistar els pilots ordenats descendentment per hores de vol*/
    public List<Pilot> ordenarLlistaPilots(List<Pilot> llistaPilots){
        int n= llistaPilots.size();
        for (int i = 0; i<n-1; i++){
            for (int j =0; j<n-i-1; j++){
                if (llistaPilots.get(j).getHoresPilot() < llistaPilots.get(j+1).getHoresPilot()){
                    Pilot a = llistaPilots.get(j);
                    llistaDrones.set(j, llistaPilots.get(j+1));
                    llistaDrones.set(j+1, a);
                }
            }
        }
        return llistaPilots;
    }
    public List<Pilot> LListatLlistaPilots() {
        List<Pilot> pilotsOrdenats = ordenarLlistaPilots(llistaPilots);
        return pilotsOrdenats;
    }

    public void afegirReserva(Dron dron, String data, String hora, String horesReserva, String posicioInici, String posicioDesti, Pilot pilot){

    }
}

