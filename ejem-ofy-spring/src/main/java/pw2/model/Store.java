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

  public static Conductor TraerConductor(String nomusu){
    return ofy().load().type(Conductor.class).id(nomusu).now();
  }

  public static boolean EliminarConductor(String nomusu){
    Conductor cond = TraerConductor(nomusu);
    //si no existe
    if(cond==null)
      return false;

    ofy().delete().entity(cond);
    return true;
  }
}
