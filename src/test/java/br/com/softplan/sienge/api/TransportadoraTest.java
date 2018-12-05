package br.com.softplan.sienge.api;

import br.com.softplan.sienge.service.CalculadoraTransporte;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class TransportadoraTest {

    @Test
    public void deveExecutarServicoDeCalculoDeCustoDeTransporte() {
        String nomeVeiculo = "CAMINHAO_BAU";
        int toneladasCarga = 3;
        int distanciaPavimentada = 10;
        int distanciaNaoPavimentada = 20;
        BigDecimal valorCustoTransporte = BigDecimal.TEN;

        CalculadoraTransporte calculadoraTransporte = mock(CalculadoraTransporte.class);
        when(calculadoraTransporte.calcula(nomeVeiculo, toneladasCarga, distanciaPavimentada, distanciaNaoPavimentada)).thenReturn(valorCustoTransporte);

        Response response = new Transportadora(calculadoraTransporte).calcula(nomeVeiculo, toneladasCarga, distanciaPavimentada, distanciaNaoPavimentada);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(valorCustoTransporte, response.getEntity());
        verify(calculadoraTransporte).calcula(nomeVeiculo, toneladasCarga, distanciaPavimentada, distanciaNaoPavimentada);
    }
}