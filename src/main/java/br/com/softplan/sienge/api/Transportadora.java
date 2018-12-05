package br.com.softplan.sienge.api;

import br.com.softplan.sienge.service.CalculadoraTransporte;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("transportadora")
public class Transportadora {

    private CalculadoraTransporte calculadoraTransporte;

    public Transportadora() {
    }

    @Inject
    public Transportadora(CalculadoraTransporte calculadoraTransporte) {
        this.calculadoraTransporte = calculadoraTransporte;
    }

    @POST
    @Path("calcularTransporte")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response calcula(@FormParam("nomeVeiculo") String nomeVeiculo, @FormParam("toneladasCarga") int toneladasCarga,
                            @FormParam("distanciaPavimentada") long distanciaPavimentada,
                            @FormParam("distanciaNaoPavimentada") long distanciaNaoPavimentada) {
        return Response.ok(calculadoraTransporte.calcula(nomeVeiculo, toneladasCarga, distanciaPavimentada, distanciaNaoPavimentada)).build();
    }
}
