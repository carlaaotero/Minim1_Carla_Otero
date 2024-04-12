package edu.upc.dsa;

import edu.upc.dsa.models.Track;

import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
/*Aquesta classe és la implementació de la interfície TracksManager
S'encarrega de gestionar la llista d'objectes "Track", que representen cançons.*/

public class TracksManagerImpl implements TracksManager {

/*Declaració de variables*/
    private static TracksManager instance; //instància única de TracksManager
    protected List<Track> tracks; //llista de pistes de cançons
    final static Logger logger = Logger.getLogger(TracksManagerImpl.class); //Logger per registres

/*Constructor privat per assegurar la implementació del patró Singleton*/
    private TracksManagerImpl() {
        this.tracks = new LinkedList<>(); //inicialització de la llista de pistes
    }

/*Mètode estàtic per obtenir la instància única de TracksManager*/
    public static TracksManager getInstance() {
        if (instance==null) instance = new TracksManagerImpl(); //si la instància no existeix, es crea
        return instance;
    }

/*Mètode per obtenir el tamany de la llista de pistes*/
    public int size() {
        int ret = this.tracks.size(); //s'obté el tamany de la llista
        logger.info("size " + ret); //es registra l'operació realitzada
        return ret;
    }

/*Mètode per agregar una pista a la llista*/
    public Track addTrack(Track t) {
        logger.info("new Track " + t); //es registra l'operació d'agregar una nova pista

        this.tracks.add (t); //s'agrega la pista a la llista
        logger.info("new Track added"); //es registra l'operació realitzada
        return t;
    }

/*Mètode per agregar una nova pista a partir del títol i el cantant*/
    public Track addTrack(String title, String singer) {
        return this.addTrack(new Track(title, singer)); //es crida al mètode addTrack(Track t) per agregar la pista
    }

/*Mètode per obtenir una pista de la llista pel seu ID*/
    public Track getTrack(String id) {
        logger.info("getTrack("+id+")"); //es registra l'operació realitzada

        for (Track t: this.tracks) { //recorre la llista de pistes
            if (t.getId().equals(id)) { //si es troba una pista amb l'ID especificat
                logger.info("getTrack("+id+"): "+t); //es registra l'operació realitzada

                return t;
            }
        }

        logger.warn("not found " + id); //si no s'ha trobat la pista, es notifica una advertència
        return null;
    }

/*Mètode per obtenir totes les pistas de la llista*/
    public List<Track> findAll() {
        return this.tracks;
    }

/*Mètode per eliminar una pista de la llista pel seu ID*/
    @Override
    public void deleteTrack(String id) {

        Track t = this.getTrack(id);//S'obté la pista pel seu ID
        if (t==null) { //si la pista no existeix es registra una advertència
            logger.warn("not found " + t);
        }
        else logger.info(t+" deleted "); //si existeix es registra l'operació realitzada

        this.tracks.remove(t); //s'elimina

    }

/*Mètode per actualitzar una pista de la llista*/
    @Override
    public Track updateTrack(Track p) {
        Track t = this.getTrack(p.getId());//s'obtè la pista pel seu ID

        if (t!=null) { //si existeix
            logger.info(p+" rebut!!!! ");

            t.setSinger(p.getSinger());//s'actualitza el cantant
            t.setTitle(p.getTitle());//s'actualitza el títol

            logger.info(t+" updated ");
        }
        else {
            logger.warn("not found "+p);
        }

        return t;
    }
}