package br.to.gov.ssp.cautela.utils;

import br.to.gov.ssp.cautela.dto.request.ArmaDTO;
import br.to.gov.ssp.cautela.entity.Arma;

public class ArmaUtils {

    private static final String ARMA_SERIAL = "111111111";
    private static final long ARMA_ID = 1L;

    public static ArmaDTO createFakeDTO() {
        return ArmaDTO.builder()
                .serial(ARMA_SERIAL)
                .build();
    }

    public static Arma createFakeEntity() {
        return Arma.builder()
                .id(ARMA_ID)
                .serial(ARMA_SERIAL)
                .build();
    }
}
