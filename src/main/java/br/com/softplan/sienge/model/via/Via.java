package br.com.softplan.sienge.model.via;

import java.math.BigDecimal;

public enum Via implements CustoVia {
    PAVIMENTADA {
        @Override
        public BigDecimal geCustoKilometroRodado() {
            return new BigDecimal("0.54");
        }
    },
    NAO_PAVIMENTADA {
        @Override
        public BigDecimal geCustoKilometroRodado() {
            return new BigDecimal("0.62");
        }
    }
}
