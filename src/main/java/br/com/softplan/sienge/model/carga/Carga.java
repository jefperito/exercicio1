package br.com.softplan.sienge.model.carga;

import java.math.BigDecimal;

public enum Carga implements CustoCarga {
    SEM_CUSTO {
        @Override
        public BigDecimal getCustoPorKilometro() {
            return BigDecimal.ZERO;
        }
    },
    CUSTO_EXCEDENTE {
        @Override
        public BigDecimal getCustoPorKilometro() {
            return new BigDecimal("0.02");
        }
    };

    public static final int VALOR_TONELADAS_MAXIMO_SEM_EXCEDENCIA = 5;

    public static BigDecimal getValorAcrescimo(int toneladasCarga, long kilometroRodado) {
        if (toneladasCarga <= VALOR_TONELADAS_MAXIMO_SEM_EXCEDENCIA) {
            return BigDecimal.ZERO;
        }

        int diferenca = toneladasCarga - VALOR_TONELADAS_MAXIMO_SEM_EXCEDENCIA;
        return CUSTO_EXCEDENTE.getCustoPorKilometro()
                .multiply(BigDecimal.valueOf(diferenca))
                .multiply(BigDecimal.valueOf(kilometroRodado));
    }
}
