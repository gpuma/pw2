package pw2.model;

import pw2.domain.*;

import java.util.List;
import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;

public class Store{
  public static void GuardarConductor(Conductor cond){
    ofy().save().entity(cond).now();
  }

  public static List<Conductor> TraerConductores(){
    return ofy().load().type(Conductor.class).list();
  }

  public static void EliminarConductor(String nomusu){
    Conductor cond = ofy().load().type(Conductor.class).id(nomusu).now();
    ofy().delete().entity(cond);
  }
}
