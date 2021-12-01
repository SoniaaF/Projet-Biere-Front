
package fr.afpa.jsf.bean;


import fr.afpa.jsf.metier.Departement;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;


/**
 * Created by François on 30/03/2017.
 */
@FacesConverter(value = "departementConverter", managed = true)
public class DepartementConverter implements Converter {

    @Inject
    private MyBean myBean;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

        Departement departement = new Departement(value, "");

        return myBean.getAllDepartements().get(myBean.getAllDepartements().indexOf(departement));
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
            Departement departement = (Departement) object;
           return departement.getCode();
    }
}