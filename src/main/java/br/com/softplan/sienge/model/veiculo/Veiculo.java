package br.com.softplan.sienge.model.veiculo;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Veiculo implements CustoVeiculo {
    CAMINHAO_BAU {
        @Override
        public BigDecimal getFatorMultiplicadorCusto() {
            return BigDecimal.ONE;
        }
    },
    CAMINHAO_CACAMBA {
        @Override
        public BigDecimal getFatorMultiplicadorCusto() {
            return new BigDecimal("1.05");
        }
    },
    CARRETA {
        @Override
        public BigDecimal getFatorMultiplicadorCusto() {
            return new BigDecimal("1.12");
        }
    };

    public static Veiculo of(String nomeVeiculo) {
        return Arrays.stream(Veiculo.values())
                .filter(item -> item.name().equals(nomeVeiculo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Nome de vecíulo não mapeado: %s", nomeVeiculo)));
    }
}
