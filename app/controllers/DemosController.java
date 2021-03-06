package controllers;

import models.User;

import models.Widget;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import server.ApplicationContext;
import views.html.widgets.demos.userDemoIndex;
import views.html.widgets.demos.userDemoIndexEmbeddable;

/**
 * User: guym
 * Date: 2/10/13
 * Time: 3:23 PM
 */
public class DemosController extends Controller {

    public static Result getDemoPageForUser( String email ){
        return ok( userDemoIndex.render( email ) );
    }

    public static Result getEmbeddedDemoPage( String email ){
        if ( email.endsWith( ApplicationContext.get().conf().demoUserEmailSuffix ) ) {
            User user = User.find.where().eq( "email", email ).findUnique();
            if ( user != null ) {
                return ok( userDemoIndexEmbeddable.render( user.getId() ) );
            }
        }

        return ok(  );
    }

    public static Result listWidgetForDemoUser( Long userId ){
        return ok(Json.toJson(User.findById(userId).getWidgets()));
    }

    public static Result getDemoPageForWidget( Long userId, String apiKey ){
        Widget widget = Widget.getWidget(apiKey);
        if ( widget == null ){
            return badRequest("could not find widget : " + apiKey );
        }
        return ok(views.html.widgets.demos.widgetDemo.render(widget, request().host()));
    }
}
