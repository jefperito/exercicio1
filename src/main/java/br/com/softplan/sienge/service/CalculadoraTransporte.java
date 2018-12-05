package br.com.softplan.sienge.service;

import br.com.softplan.sienge.model.carga.Carga;
import br.com.softplan.sienge.model.veiculo.Veiculo;
import br.com.softplan.sienge.model.via.Via;

import javax.ejb.Stateless;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Stateless
public class CalculadoraTransporte {

    private static final int DEFAULT_SCALE = 2;

    public BigDecimal calcula(String nomeVeiculo, int toneladasCarga, long distanciaPavimentada, long distanciaNaoPavimentada) {
        Objects.requireNonNull(nomeVeiculo);
        if (toneladasCarga < 0 || distanciaPavimentada < 0 || distanciaNaoPavimentada < 0) {
            throw new IllegalArgumentException("Valor inválido, utilize valores maior ou igual a zero");
        }
        Veiculo veiculo = Veiculo.of(nomeVeiculo);

        BigDecimal custoNaoPavimentado = Via.NAO_PAVIMENTADA.geCustoKilometroRodado().multiply(BigDecimal.valueOf(distanciaNaoPavimentada));
        BigDecimal custoPavimento = Via.PAVIMENTADA.geCustoKilometroRodado().multiply(BigDecimal.valueOf(distanciaPavimentada));
        BigDecimal valorAcrescimo = Carga.getValorAcrescimo(toneladasCarga, distanciaNaoPavimentada + distanciaPavimentada);

        return valorAcrescimo.add(veiculo.getFatorMultiplicadorCusto().multiply(custoPavimento.add(custoNaoPavimentado)))
                .setScale(DEFAULT_SCALE, RoundingMode.HALF_DOWN);
    }
}
