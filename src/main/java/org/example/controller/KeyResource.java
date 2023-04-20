package org.example.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.models.KeyAnalyzers;
import org.example.services.KeyAServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("/keys")
public class KeyResource {

    private final static Logger LOG = LoggerFactory.getLogger(KeyResource.class);


    @Inject
    KeyAServiceImpl keyAService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<KeyAnalyzers> getKeysAnalyzers(){
        LOG.info("Got all the investments");
        return keyAService.getAllKeysAnalyzers();
    }
}