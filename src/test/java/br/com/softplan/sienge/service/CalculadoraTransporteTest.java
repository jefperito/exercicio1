package br.com.softplan.sienge.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class CalculadoraTransporteTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void deveCalcularCorretamenteDeAcordoPlanilhaExercicio() {
        CalculadoraTransporte calculadora = new CalculadoraTransporte();
        assertEquals(new BigDecimal("62.70"), calculadora.calcula("CAMINHAO_CACAMBA", 8, 100, 0));
        assertEquals(new BigDecimal("37.20"), calculadora.calcula("CAMINHAO_BAU", 4, 0, 60));
        assertEquals(new BigDecimal("150.19"), calculadora.calcula("CARRETA", 12, 0, 180));
        assertEquals(new BigDecimal("57.60"), calculadora.calcula("CAMINHAO_BAU", 6, 80, 20));
        assertEquals(new BigDecimal("47.88"), calculadora.calcula("CAMINHAO_CACAMBA", 5, 50, 30));
    }

    @Test
    public void deveLancarNullPointerExceptionCasoNomeVeiculoSejaNulo() {
        expectedException.expect(NullPointerException.class);

        new CalculadoraTransporte().calcula(null, 0, 0, 0);
    }

    @Test
    public void deveLancarIllegalArgumentExceptionCasoToneladasCargaSejaMenorQueZero() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Valor inválido, utilize valores maior ou igual a zero");

        new CalculadoraTransporte().calcula("CAMINHAO_CACAMBA", -1, 0, 0);
    }

    @Test
    public void deveLancarIllegalArgumentExceptionCasoDistanciaPavimentadaSejaMenorQueZero() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Valor inválido, utilize valores maior ou igual a zero");

        new CalculadoraTransporte().calcula("CAMINHAO_CACAMBA", 0, -1, 0);
    }

    @Test
    public void deveLancarIllegalArgumentExceptionCasoDistanciaNaoPavimentadaSejaMenorQueZero() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Valor inválido, utilize valores maior ou igual a zero");

        new CalculadoraTransporte().calcula("CAMINHAO_CACAMBA", 0, 0, -1);
    }
}