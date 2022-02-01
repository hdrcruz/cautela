package br.to.gov.ssp.cautela.services;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.to.gov.ssp.cautela.dto.mapper.ServidorMapper;
import br.to.gov.ssp.cautela.dto.request.ServidorDTO;
import br.to.gov.ssp.cautela.dto.response.MessageResponseDTO;
import br.to.gov.ssp.cautela.entity.Servidor;
import br.to.gov.ssp.cautela.repository.ServidorRepository;
import br.to.gov.ssp.cautela.service.ServidorService;
import br.to.gov.ssp.cautela.utils.ServidorUtils;

@ExtendWith(MockitoExtension.class)
public class ServidorServiceTest {

    @Mock
    private ServidorRepository servidorRespository;

    @Mock
    private ServidorMapper servidorMapper;

    @InjectMocks
    private ServidorService servidorService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        ServidorDTO servidorDTO = ServidorUtils.createFakeDTO();
        Servidor servidorSalvoEsperado = ServidorUtils.createFakeEntity();

        when(servidorMapper.toModel(servidorDTO)).thenReturn(servidorSalvoEsperado);
        when(servidorRespository.save(any(Servidor.class))).thenReturn(servidorSalvoEsperado);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(servidorSalvoEsperado.getId());
        MessageResponseDTO successMessage = servidorService.criar(servidorDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long servidorSalvo) {
        return MessageResponseDTO.builder()
                .message("Servidor criado com ID " + servidorSalvo)
                .build();
    }

}