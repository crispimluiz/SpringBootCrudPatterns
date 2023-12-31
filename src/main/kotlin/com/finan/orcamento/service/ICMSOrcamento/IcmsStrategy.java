package com.finan.orcamento.service.ICMSOrcamento;

import java.math.BigDecimal;

public interface IcmsStrategy {
    BigDecimal calcular(BigDecimal valorOrcamento);
}
