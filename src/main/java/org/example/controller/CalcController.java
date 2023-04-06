package org.example.controller;

import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.models.Invest;
import org.example.services.InvestServiceImpl;

import java.util.List;

@Path("/calc")
public class CalcController {
    private InvestServiceImpl investService;

    @Inject
    public CalcController(InvestServiceImpl investService) {
        this.investService = investService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Invest> getInvestments(){
        return investService.getAllInvestments();
    }
}
