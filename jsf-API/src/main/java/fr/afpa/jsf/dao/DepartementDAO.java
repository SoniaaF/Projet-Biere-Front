package fr.afpa.jsf.dao;


import com.fasterxml.jackson.core.JsonParser;
import com.sun.faces.util.Json;
import fr.afpa.jsf.metier.Departement;
import fr.afpa.jsf.metier.Region;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartementDAO extends DAO<Departement> {


    public DepartementDAO(WebTarget webTarget) {
        super(webTarget);
    }

    @Override
    public void getByID(Departement object) {

    }


    public ArrayList<Departement> getAll() {
        ArrayList<Departement> liste = new ArrayList<>();
        String json = webTarget.path("departements").request(MediaType.APPLICATION_JSON).get().readEntity(String.class);

        try {
          liste.addAll(Arrays.asList(objectMapper.readValue(json, Departement[].class)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return liste;
    }
    public ArrayList<Departement> getByRegion(Region region) {
        ArrayList<Departement> liste = new ArrayList<>();
        String json = webTarget.path("regions").path(region.getCode()).path("departements").request(MediaType.APPLICATION_JSON).get().readEntity(String.class);

        try {
            liste.addAll(Arrays.asList(objectMapper.readValue(json, Departement[].class)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return liste;
    }



}