package br.com.softplan.sienge.model;

import br.com.softplan.sienge.model.carga.Carga;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CargaTest {

    @Test
    public void deveTerCustoZeroCasoCargaForSemCusto() {
        assertEquals(BigDecimal.ZERO, Carga.SEM_CUSTO.getCustoPorKilometro());
    }

    @Test
    public void deveTerCustoDefinidioCorretoCasoPossuirCargaExcedente() {
        assertEquals(new BigDecimal("0.02"), Carga.CUSTO_EXCEDENTE.getCustoPorKilometro());
    }

    @Test
    public void deveObterValorAcrescimoZeroCasoForIgualAQuantidadeToneladasExcedentes() {
        BigDecimal valorAcrescimo = Carga.getValorAcrescimo(5, 100);
        assertEquals(BigDecimal.ZERO, valorAcrescimo);
    }

    @Test
    public void deveObterValorAcrescimoZeroCasoForMenorAQuantidadeToneladasExcedentes() {
        BigDecimal valorAcrescimo = Carga.getValorAcrescimo(4, 100);
        assertEquals(BigDecimal.ZERO, valorAcrescimo);
    }

    @Test
    public void deveObterCustoExcedenteCasoForMaiorQueAQuantidadeToneladasExcedentes() {
        BigDecimal valorAcrescimo = Carga.getValorAcrescimo(6, 100);
        assertEquals(new BigDecimal("2.00"), valorAcrescimo);
    }
}