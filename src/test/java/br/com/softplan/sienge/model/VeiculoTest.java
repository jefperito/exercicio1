package br.com.softplan.sienge.model;


import br.com.softplan.sienge.model.veiculo.Veiculo;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class VeiculoTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void deveObterFatorMultiplicadorCustoCorretoDoCaminhaoBau() {
        assertEquals(BigDecimal.ONE, Veiculo.CAMINHAO_BAU.getFatorMultiplicadorCusto());
    }

    @Test
    public void deveObterFatorMultiplicadorCustoCorretoDoCaminhaoCacamba() {
        assertEquals(new BigDecimal("1.05"), Veiculo.CAMINHAO_CACAMBA.getFatorMultiplicadorCusto());
    }

    @Test
    public void deveObterFatorMultiplicadorCustoCorretoDaCarreta() {
        assertEquals(new BigDecimal("1.12"), Veiculo.CARRETA.getFatorMultiplicadorCusto());
    }

    @Test
    public void deveLancarIllegalArgumentExceptionCasoNaoEncontreVeiculoPeloSeuNome() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Nome de vecíulo não mapeado: xxxx");

        Veiculo.of("xxxx");
    }

    @Test
    public void deveObterVeiculosPeloSeusNomes() {
        assertEquals(Veiculo.CAMINHAO_BAU, Veiculo.of("CAMINHAO_BAU"));
        assertEquals(Veiculo.CAMINHAO_CACAMBA, Veiculo.of("CAMINHAO_CACAMBA"));
        assertEquals(Veiculo.CARRETA, Veiculo.of("CARRETA"));
    }
}