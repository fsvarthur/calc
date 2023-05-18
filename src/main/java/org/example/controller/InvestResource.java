package org.example.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.models.Invest;
import org.example.models.KeyAnalyzers;
import org.example.models.dto.InvestDTO;
import org.example.models.mapper.InvestMapper;
import org.example.services.InvestServiceImpl;
import org.example.services.KeyAServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Path("/invests")
public class InvestResource {

    private final static Logger LOG = LoggerFactory.getLogger(InvestResource.class);

    @Inject
    private InvestServiceImpl investService;

    @Inject
    private KeyAServiceImpl keyAService;

    @Inject
    private InvestMapper mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Invest> getInvestments(){
        LOG.info("Getting all investments");
        return investService.getAllInvestments();
    }

    @GET @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<InvestDTO> getInvestmentByID(@PathParam("id") Long Id){
        //public Response
        LOG.info("Got invest for Id " + Id);
        return mapper.investToInvestDTO(investService.getInvestmentsById(Id));
    }

    @POST @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateInvestment(@PathParam("id") Long id, InvestDTO investDTO){
        try{
            investService.updateInvestment(mapper.investDTOtoInvest(investDTO), id);
            LOG.info("Updated investment with id"+ id);
        }catch (Exception ex){
            LOG.warn("Exception " + ex);
        }finally {
            LOG.warn("Exception when tried to update investment with " + id);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createInvestment(InvestDTO invest) throws Exception{
        investService.createInvestment(mapper.investDTOtoInvest(invest));
        LOG.info("Created investment with id ", invest.getId());
    }

    @DELETE @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteInvestment(@PathParam("id")Long Id){
        investService.deleteInvestment(Id);
    }


    @GET @Path("/{month}")
    public Map<Invest, List<Double>> getInvestmentAndKeysByMonth(InvestDTO investDTO, KeyAnalyzers keyAnalyzers){
        List<Invest> investList = investService.getInvestmentByMonth(mapper.investDTOtoInvest(investDTO));
        List<KeyAnalyzers> keyAnalyzersList = keyAService.getKeystByMonth(keyAnalyzers);
        return investService.getInvestmentAndKeysByMonth(investList, keyAnalyzersList);
    }
}
