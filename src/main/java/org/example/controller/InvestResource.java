package org.example.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.models.Invest;
import org.example.models.dto.InvestDTO;
import org.example.services.InvestServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

@Path("/invests")
public class InvestResource {

    private final static Logger LOG = LoggerFactory.getLogger(InvestResource.class);

    @Inject
    private InvestServiceImpl investService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Invest> getInvestments(){
        LOG.info("Getting all investments");
        return investService.getAllInvestments();
    }

    @GET @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public InvestDTO getInvestmentByID(@PathParam("id") Long Id){
        LOG.info("Get invest by Id " + Id);
        return investService.getInvestmentById(Id);
    }

    @POST @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateInvestment(@PathParam("id") Long id, InvestDTO invest){
        try{
            investService.updateInvestment(invest, id);
            LOG.info("Updated investment with id"+ id);
        }catch (Exception ex){
            LOG.warn("Exception when tried to update investment with " + id);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createInvestment(InvestDTO invest) throws Exception{
        investService.createInvestment(invest);
        LOG.info("Create investment");
    }

    @DELETE @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteInvestment(@PathParam("id")Long Id){
        investService.deleteInvestment(Id);
    }
}
