package com.finan.orcamento.model.enums;

import com.finan.orcamento.service.ICMSOrcamento.IcmsMG;
import com.finan.orcamento.service.ICMSOrcamento.IcmsRJ;
import com.finan.orcamento.service.ICMSOrcamento.IcmsSP;
import com.finan.orcamento.service.ICMSOrcamento.IcmsStrategy;

public enum IcmsEstados {
    ICMS_MG(new IcmsMG()),
    ICMS_SP(new IcmsSP()),
    ICMS_RJ(new IcmsRJ());

    private final IcmsStrategy strategy;

    IcmsEstados(IcmsStrategy strategy) {
        this.strategy = strategy;
    }

    public IcmsStrategy getStrategy() {
        return this.strategy;
    }

}