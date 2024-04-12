package edu.upc.dsa;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import edu.upc.dsa.models.Dron;



public class AlmacenDrones {

    private List<Dron> dronesAlmacenats;
    final static Logger logger = Logger.getLogger(AlmacenDrones.class);

    public AlmacenDrones(){
        this.dronesAlmacenats = new ArrayList<>();
    }

    /*Mètode per guardar un dron al almacen*/
    public Dron guardarDron (Dron Dron){
        logger.info("es guarda el dron amb id:" + Dron.getIdDron() + "al almacen");
        this.dronesAlmacenats.add(Dron);
        logger.info("guardat");
        return Dron.getIdDron();
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
        logger.info("Ja es pot fer servir aquest Dron amb id" + Dron.getIdDron());

    }


}
