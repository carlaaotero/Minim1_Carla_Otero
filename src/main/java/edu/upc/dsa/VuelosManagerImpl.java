package edu.upc.dsa;

import edu.upc.dsa.models.PlanDeVuelo;
import org.apache.log4j.Logger;
import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Pilot;


import java.util.ArrayList;
import java.util.List;


public class VuelosManagerImpl implements VuelosManager {

    /*Declaració de variables*/
    final static Logger logger = Logger.getLogger(VuelosManagerImpl.class);
    protected List<Dron> llistaDrones;
    protected List<Pilot> llistaPilots;
    private List<PlanDeVuelo> reservas;
    private List<Dron> dronesAlmacenats;
    private static VuelosManager instance;

    /*Constructor*/
    public VuelosManagerImpl (){
        this.llistaDrones = new ArrayList<>();
        this.llistaPilots = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public static VuelosManager getInstance() {
        if(instance==null)
            instance = new VuelosManagerImpl();
        return instance;
    }

    /*Mètode per afegir un Dron*/
    public void afegirDron(String idDron, String nomDron, String fabricant, String model, int horesDron){
        logger.info("Afegim un dron");
        boolean existeix = false;
        //Mirem si ja existeix aquest dron amb el mateix ID
        for(Dron dron : llistaDrones){
            if(dron.getIdDron() == null && idDron == null){
                existeix = true;
                break;
            } else if(dron.getIdDron() != null && dron.getIdDron().equals(idDron)){
                existeix = true;
                break;
            }
        }
        if(existeix){
            logger.error("El dron amb l'id:" + idDron + "ja existeix");
        } else{
            //creem un nou dron i l'afegim a la llista
            Dron nouDron = new Dron(idDron, nomDron, fabricant, model, horesDron);
            llistaDrones.add(nouDron);
            logger.info("Dron afegit");
        }
    }
    /*Mètode per afegir un Pilot*/
    public void afegirPilot(String idPilot, String nomPilot, String cognomPilot, int horesPilot) {
        logger.info("Afegim un Pilot");
        boolean existeix = false;
        //Mirem si ja existeix aquest pilot amb el mateix ID
        for (Pilot pilot : llistaPilots) {
            if (pilot.getIdPilot() == null && idPilot == null) {
                existeix = true;
                break;
            } else if (pilot.getIdPilot() != null && pilot.getIdPilot().equals(idPilot)) {
                existeix = true;
                break;
            }
        }
        if (existeix) {
            logger.error("El pilot amb l'ID:" + idPilot + "ja existeix");
        } else {
            //creem un nou pilot i l'afegim a la llista
            Pilot nouPilot = new Pilot(idPilot, nomPilot, cognomPilot, horesPilot);
            llistaPilots.add(nouPilot);
            logger.info("Pilot afegit");
        }
    }


    /*Mètode per llistar els drons ordenats descendentment per hores de vol*/
    public List<Dron> ordenarLlistaDrones(List<Dron> llistaDrones) {
        logger.info("Llistat dels Drons per hores de vol");
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



    /*Mètode per llistar els pilots ordenats descendentment per hores de vol*/
    public List<Pilot> ordenarLlistaPilots(List<Pilot> llistaPilots){
        logger.info("Llistat dels Pilots per hores de vol");
        int n= llistaPilots.size();
        for (int i = 0; i<n-1; i++){
            for (int j =0; j<n-i-1; j++){
                if (llistaPilots.get(j).getHoresPilot() < llistaPilots.get(j+1).getHoresPilot()){
                    Pilot a = llistaPilots.get(j);
                    llistaPilots.set(j, llistaPilots.get(j+1));
                    llistaPilots.set(j+1, a);
                }
            }
        }
        return llistaPilots;
    }

    /*Mètode per guardar un dron al almacen*/
    public void guardarDron (String idDron){
        //mirem si el dron ja està al almacen
        for (Dron dron : dronesAlmacenats) {
            if ((dron.getIdDron() == null && idDron == null) || (dron.getIdDron() != null && dron.getIdDron().equals(idDron))) {
                // Si l'ID coincideix ho notifiquem i sortim
                logger.error("El dron amb l'ID " + idDron + " ja està al magatzem.");
                return;
            }
        }

        logger.info("es guarda el dron amb id:" + idDron + "al magatzem");
        for (Dron dron : llistaDrones){
            if(dron.getIdDron().equals(idDron)){
                this.dronesAlmacenats.add(dron);
            }
        }
    }

    /*Mètode per realitzar manteniment sobre un dron que està al almacen*/
    public void realitzarManteniment(){
        //si l'almacen està buit, no es pot realitzar el manteniment i es surt
        if (dronesAlmacenats.isEmpty()){
            logger.info("No hi ha cap dron al almacen per realitzar el manteniment");
            return;
        }

        //Selecciona el dron més a prop per realitzar el manteniment
        Dron dronMantenimiento = dronesAlmacenats.remove(0); //es treu de la llista de l'almacen
        logger.info("Ja es pot fer servir aquest Dron amb id" + dronMantenimiento.getIdDron());

    }

    /*Mètode per llistar les reserves que té un pilot*/
    public List<PlanDeVuelo> llistaReservesPilot(String idPilot){
        List<PlanDeVuelo> volsPilot = new ArrayList<>();
        int i=0;
        while (i<reservas.size()){
            PlanDeVuelo reserva = reservas.get(i);
            if(reserva.getIdPilot().equals(i)){
                volsPilot.add(reserva);
            }
            i++;
        }
        //mirem si el pilot té vols
        if(volsPilot.isEmpty()){
            logger.info("El pilot no te cap reserva assignada");
        } else{
            int j=0;
            while (j<volsPilot.size()){
                logger.info("Reservas del Pilot" + volsPilot.get(j));
                j++;
            }
        }
        return volsPilot;
    }


    /*Mètode per llistar les reserves que té un dron*/
    public List<PlanDeVuelo> llistaReservasDron (String idDron){
        List<PlanDeVuelo> volsDron = new ArrayList<>();
        int i=0;
        while (i<reservas.size()){
            PlanDeVuelo reserva = reservas.get(i);
            if(reserva.getIdDron().equals(i)){
                volsDron.add(reserva);
            }
            i++;
        }
        //mirem si el dron té vols
        if(volsDron.isEmpty()){
            logger.info("El dron no te cap reserva assignada");
        } else{
            int j=0;
            while (j<volsDron.size()){
                logger.info("Reservas del Dron" + volsDron.get(j));
                j++;
            }
        }
        return volsDron;
    }

    /*Mètode per afegir una reserva de Plan de vuelo*/
    public void afegirReserva(String idDron, String dia, String hora, String horesReserva, String posicioInici, String posicioDesti, String idPilot, String idPlanDeVuelo){
        logger.info("Afegim un Plan de Vuelo");
        boolean existeix = false;
        //Mirem si ja existeix aquest plan de vuelo amb el mateix ID
        for(PlanDeVuelo reserva : reservas){
            if(reserva.getIdPlanDeVuelo() == null && idPlanDeVuelo == null){
                existeix = true;
                break;
            } else if(reserva.getIdPlanDeVuelo() != null && reserva.getIdPlanDeVuelo().equals(idPlanDeVuelo)){
                existeix = true;
                break;
            }
        }
        if(existeix){
            logger.error("El plan de vuelo amb l'ID:" + idPlanDeVuelo + "ja existeix");
        } else{
            //creem un nou plan de vuelo i l'afegim a la llista de reservas
            PlanDeVuelo nouReserva = new PlanDeVuelo(idDron, dia, hora, horesReserva, posicioInici, posicioDesti, idPilot, idPlanDeVuelo);
            reservas.add(nouReserva);
            logger.info("Reserva afegida");
        }
    }
}


