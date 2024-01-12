package ec.voto.api.service;

import ec.voto.api.domain.Votacion;
import ec.voto.api.dto.VotacionDTO;
import ec.voto.api.repository.VotacionPersistence;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VotacionService extends GenericCrudServiceImpl<Votacion, VotacionDTO> {

	@Autowired
	private VotacionPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Votacion> find(VotacionDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Votacion mapToDomain(VotacionDTO dto) {
		return modelMapper.map(dto, Votacion.class);
	}

	@Override
	public VotacionDTO mapToDto(Votacion domain) {
		return modelMapper.map(domain, VotacionDTO.class);
	}

}
