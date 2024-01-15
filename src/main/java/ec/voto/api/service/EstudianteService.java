package ec.voto.api.service;

import java.util.List;
import java.util.Optional;

import ec.voto.api.domain.Voto;
import ec.voto.api.repository.EstudiantePersistence;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.voto.api.domain.Estudiante;
import ec.voto.api.dto.EstudianteDTO;


@Service
public class EstudianteService extends GenericCrudServiceImpl<Estudiante, EstudianteDTO> {

	@Autowired
	private EstudiantePersistence repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Estudiante> find(EstudianteDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Estudiante mapToDomain(EstudianteDTO dto) {
		return modelMapper.map(dto, Estudiante.class);
	}

	@Override
	public EstudianteDTO mapToDto(Estudiante domain) {
		return modelMapper.map(domain, EstudianteDTO.class);
	}

	public List<Estudiante> buscarAsistencia(Boolean asistencia) {
		List<Estudiante> entidad = repository.findByAsistencia(asistencia);
		return entidad;
	}



}
