package ec.voto.api.service;

import java.util.List;
import java.util.Optional;

import ec.voto.api.repository.VotoPersistence;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.voto.api.domain.Voto;
import ec.voto.api.dto.VotoDTO;


@Service
public class VotoService extends GenericCrudServiceImpl<Voto, VotoDTO> {

	@Autowired
	private VotoPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();

    public VotoService(VotoPersistence repository) {
        this.repository = repository;
    }

    @Override
	public Optional<Voto> find(VotoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Voto mapToDomain(VotoDTO dto) {
		return modelMapper.map(dto, Voto.class);
	}

	@Override
	public VotoDTO mapToDto(Voto domain) {
		return modelMapper.map(domain, VotoDTO.class);
	}
	public List<Voto> buscarCandidato(String candidato) {
		List<Voto> entidad = repository.findByCandidato_NombreCandidato(candidato);
		return entidad;
	}

	public List<Voto> buscarMesa(Long id) {
		List<Voto> entidad = repository.findByMesa_Id(id);
		return entidad;
	}





}

