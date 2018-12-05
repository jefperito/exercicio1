package br.com.softplan.sienge.model;

import br.com.softplan.sienge.model.via.Via;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ViaTest {

    @Test
    public void deveObterCustoCorretoDaViaPavimentada() {
        assertEquals(new BigDecimal("0.54"), Via.PAVIMENTADA.geCustoKilometroRodado());
    }

    @Test
    public void deveObterCustoCorretoDaViaNaoPavimentada() {
        assertEquals(new BigDecimal("0.62"), Via.NAO_PAVIMENTADA.geCustoKilometroRodado());
    }
}