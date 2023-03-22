package org.example.Controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.Util.Calc;

import java.awt.*;

@Path("/calc")
public class CalcController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Calc getInvestments(){
        return null;
    }

}
