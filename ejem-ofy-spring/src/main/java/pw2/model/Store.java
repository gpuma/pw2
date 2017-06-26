package pw2.model;

import pw2.domain.*;

import java.util.List;
import java.util.Date;
import com.googlecode.objectify.Key;
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

  public static void AgregarReview(Conductor cond, String review){

    Review nuevoReview = new Review(null, review, new Date());
    ofy().save().entity(nuevoReview).now();
    //TODO: probablemente no es la manera más eficiente
    nuevoReview = ofy().load().entity(nuevoReview).now();
    System.out.println("********************"+nuevoReview.getId());
    Key<Review> llave = Key.create(Review.class, nuevoReview.getId());
    cond.getReviews().add(llave);
    ofy().save().entity(cond).now();
  }
}
