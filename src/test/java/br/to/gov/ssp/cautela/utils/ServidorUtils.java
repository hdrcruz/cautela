package br.to.gov.ssp.cautela.utils;

import br.to.gov.ssp.cautela.dto.request.ServidorDTO;
import br.to.gov.ssp.cautela.entity.Servidor;
import java.util.Collections;

public class ServidorUtils {
	
	private static final String NOME = "Helder";
    private static final String SOBRENOME = "Cruz";
    private static final String CPF_NUMBER = "017.662.993-93";
    private static final long ID = 1L;

    public static ServidorDTO createFakeDTO() {
        return ServidorDTO.builder()
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .cpf(CPF_NUMBER)
                .armas(Collections.singletonList(ArmaUtils.createFakeDTO()))
                .build();
    }

    public static Servidor createFakeEntity() {
        return Servidor.builder()
                .id(ID)
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .cpf(CPF_NUMBER)
                .armas(Collections.singletonList(ArmaUtils.createFakeEntity()))
                .build();
    }

}
