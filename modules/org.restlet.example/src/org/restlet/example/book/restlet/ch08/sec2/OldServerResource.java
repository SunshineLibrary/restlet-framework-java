package org.restlet.example.book.restlet.ch08.sec2;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Resource that simply redirects to the port 8182.
 */
public class OldServerResource extends ServerResource {

    @Get
    public String redirect() {
        // Redirects the client to another location.
        redirectPermanent("http://localhost:8182/");

        System.out.println("Redirecting client to new location...");

        // Add an optional message for the client.
        return "Resource moved... \n";
    }
}
