package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/greetings")
public class Application
{
    @GET
    @Path("/hi")
    public String getHiGreeting()
    {
        return "hi";
    }
}