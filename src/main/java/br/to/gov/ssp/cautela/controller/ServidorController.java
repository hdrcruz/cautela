package br.to.gov.ssp.cautela.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.to.gov.ssp.cautela.dto.request.ServidorDTO;
import br.to.gov.ssp.cautela.dto.response.MessageResponseDTO;
import br.to.gov.ssp.cautela.exception.ServidorNaoEncontradoException;
import br.to.gov.ssp.cautela.service.ServidorService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/servidor")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ServidorController {
	
	private final ServidorService servidorService;
	
	@PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid ServidorDTO servidorDTO) {
        return servidorService.criar(servidorDTO);
    }
	
	@GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ServidorDTO findById(@PathVariable Long id) throws ServidorNaoEncontradoException {
        return servidorService.findById(id);
    }

    @GetMapping
    public List<ServidorDTO> listAll() {
        return servidorService.listAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid ServidorDTO servidorDTO) throws ServidorNaoEncontradoException {
        return servidorService.update(id, servidorDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ServidorNaoEncontradoException {
        servidorService.delete(id);
    }

}
