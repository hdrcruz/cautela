package br.to.gov.ssp.cautela.mapper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.to.gov.ssp.cautela.dto.mapper.ServidorMapper;
import br.to.gov.ssp.cautela.dto.request.ArmaDTO;
import br.to.gov.ssp.cautela.dto.request.ServidorDTO;
import br.to.gov.ssp.cautela.entity.Arma;
import br.to.gov.ssp.cautela.entity.Servidor;
import br.to.gov.ssp.cautela.utils.ServidorUtils;

@SpringBootTest
public class ServidorMapperTest {

    @Autowired
    private ServidorMapper servidorMapper;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity() {
        ServidorDTO servidorDTO = ServidorUtils.createFakeDTO();
        Servidor servidor = servidorMapper.toModel(servidorDTO);

        assertEquals(servidorDTO.getNome(), servidor.getNome());
        assertEquals(servidorDTO.getSobrenome(), servidor.getSobrenome());
        assertEquals(servidorDTO.getCpf(), servidor.getCpf());

        Arma arma = servidor.getArmas().get(0);
        ArmaDTO armaDTO = servidorDTO.getArmas().get(0);

        assertEquals(armaDTO.getSerial(), arma.getSerial());
    }

    @Test
    void testGivenPersonEntityThenReturnPersonDTO() {
        Servidor servidor = ServidorUtils.createFakeEntity();
        ServidorDTO servidorDTO = servidorMapper.toDTO(servidor);

        assertEquals(servidor.getNome(), servidorDTO.getNome());
        assertEquals(servidor.getSobrenome(), servidorDTO.getSobrenome());
        assertEquals(servidor.getCpf(), servidorDTO.getCpf());

        Arma arma = servidor.getArmas().get(0);
        ArmaDTO phoneDTO = servidorDTO.getArmas().get(0);

        assertEquals(arma.getSerial(), phoneDTO.getSerial());
    }
}
