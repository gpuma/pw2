package pw2.model;

import pw2.domain.*;

import java.util.List;
import java.util.Date;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Load;
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

  public static Review TraerReview(Long idReview){
    return ofy().load().type(Review.class).id(idReview).now();
  }

  public static boolean EliminarConductor(String nomusu){
    Conductor cond = TraerConductor(nomusu);
    //si no existe
    if(cond==null)
      return false;

    ofy().delete().entity(cond);
    return true;
  }

  public static void ModificarReview(Long reviewId, String review){
    Review r = ofy().load().type(Review.class).id(reviewId).now();
    r.setComentario(review);
    ofy().save().entity(r).now();
  }

  public static void AgregarReview(Conductor cond, String review){
    Review nuevoReview = new Review(null, review, new Date());
    ofy().save().entity(nuevoReview).now();
    //TODO: probablemente no es la manera más eficiente
    nuevoReview = ofy().load().entity(nuevoReview).now();
    Key<Review> llaveReview = Key.create(Review.class, nuevoReview.getId());
    Ref<Review> reviewRef = Ref.create(llaveReview);
    cond.addReviewRef(reviewRef);
    ofy().save().entity(cond).now();
  }
}
