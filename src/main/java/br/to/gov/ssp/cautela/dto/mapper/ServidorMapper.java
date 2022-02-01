package br.to.gov.ssp.cautela.dto.mapper;

import org.mapstruct.Mapper;

import br.to.gov.ssp.cautela.dto.request.ServidorDTO;
import br.to.gov.ssp.cautela.entity.Servidor;

@Mapper(componentModel = "spring")
public interface ServidorMapper {
	
    Servidor toModel(ServidorDTO dto);

    ServidorDTO toDTO(Servidor dto);

}
