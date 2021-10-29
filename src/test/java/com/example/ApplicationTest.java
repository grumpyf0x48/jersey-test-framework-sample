package com.example;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTest extends JerseyTest
{
    @Override
    protected Application configure()
    {
        return new ResourceConfig(Application.class);
    }

    @Test
    public void givenGetHiGreeting_whenCorrectRequest_thenResponseIsOkAndContainsHi()
    {
        final Response response = target("/greetings/hi").request().get();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(), "Http Response should be 200");
        assertEquals(MediaType.TEXT_HTML, response.getHeaderString(HttpHeaders.CONTENT_TYPE), "Incorrect Http Content-Type");

        final String content = response.readEntity(String.class);
        assertEquals("hi", content, "Content of response is: ");
    }
}
