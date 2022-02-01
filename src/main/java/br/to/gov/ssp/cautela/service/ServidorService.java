package br.to.gov.ssp.cautela.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.to.gov.ssp.cautela.dto.mapper.ServidorMapper;
import br.to.gov.ssp.cautela.dto.request.ServidorDTO;
import br.to.gov.ssp.cautela.dto.response.MessageResponseDTO;
import br.to.gov.ssp.cautela.entity.Servidor;
import br.to.gov.ssp.cautela.exception.ServidorNaoEncontradoException;
import br.to.gov.ssp.cautela.repository.ServidorRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ServidorService {
	
	private final ServidorRepository servidorRepository;
	
	private final ServidorMapper servidorMapper;
	
	public MessageResponseDTO criar(ServidorDTO servidorDTO) {
		Servidor servidor = servidorMapper.toModel(servidorDTO);
		Servidor novoServidor = servidorRepository.save(null);
		MessageResponseDTO messageResponse = createMessageResponse("Servidor criado com ID ", novoServidor.getId());
		return messageResponse;
	}
	
	public ServidorDTO findById(Long id) throws ServidorNaoEncontradoException {
        Servidor servidor = servidorRepository.findById(id)
                .orElseThrow(() -> new ServidorNaoEncontradoException(id));

        return servidorMapper.toDTO(servidor);
    }

    public List<ServidorDTO> listAll() {
        List<Servidor> servidores = servidorRepository.findAll();
        return servidores.stream()
                .map(servidorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, ServidorDTO personDTO) throws ServidorNaoEncontradoException {
        servidorRepository.findById(id)
                .orElseThrow(() -> new ServidorNaoEncontradoException(id));

        Servidor servidorAtualizado = servidorMapper.toModel(personDTO);
        Servidor servidorSalvo = servidorRepository.save(servidorAtualizado);

        MessageResponseDTO messageResponse = createMessageResponse("Servidor atualizado com ID ", servidorSalvo.getId());

        return messageResponse;
    }

    public void delete(Long id) throws ServidorNaoEncontradoException {
        servidorRepository.findById(id)
                .orElseThrow(() -> new ServidorNaoEncontradoException(id));

        servidorRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }
	
	

}
