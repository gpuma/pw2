package pw2.model;

import pw2.domain.*;

import com.googlecode.objectify.ObjectifyService;

public class Store{
  public static void GuardarConductor(Conductor cond){
    ObjectifyService.ofy().save().entity(cond).now();
  }
}
