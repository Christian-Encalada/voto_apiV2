package ec.voto.api.service;

import ec.voto.api.domain.Lista_De_Votos;
import ec.voto.api.dto.Lista_De_VotosDTO;
import ec.voto.api.repository.Lista_De_VotosPersistence;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Lista_De_VotosService extends GenericCrudServiceImpl<Lista_De_Votos, Lista_De_VotosDTO> {

	@Autowired
	private Lista_De_VotosPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Lista_De_Votos> find(Lista_De_VotosDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Lista_De_Votos mapToDomain(Lista_De_VotosDTO dto) {
		return modelMapper.map(dto, Lista_De_Votos.class);
	}

	@Override
	public Lista_De_VotosDTO mapToDto(Lista_De_Votos domain) {
		return modelMapper.map(domain, Lista_De_VotosDTO.class);
	}

}
