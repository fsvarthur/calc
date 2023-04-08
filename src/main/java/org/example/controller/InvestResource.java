package org.example.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.models.Invest;
import org.example.models.dto.InvestDTO;
import org.example.services.InvestServiceImpl;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

@Path("/invests")
public class InvestResource {

    private final static Logger LOG = LoggerFactory.getLogger(InvestResource.class);

    @Inject
    private InvestServiceImpl investService;

    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public List<Invest> getInvestments(){
        return investService.getAllInvestments();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public InvestDTO getInvestment(@PathParam("invest") InvestDTO invest){
        return investService.getInvestment(invest);
    }
}
