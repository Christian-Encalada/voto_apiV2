package ec.voto.api.v1;

import ec.voto.api.dto.CursoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.voto.api.dto.ApiResponseDTO;
import ec.voto.api.dto.EstudianteDTO;
import ec.voto.api.service.EstudianteService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = { "/api/v1.0/estudiante" })
public class EstudianteController {

	@Autowired
	private EstudianteService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<EstudianteDTO> list = service.findAll(new EstudianteDTO());
		ApiResponseDTO<List<EstudianteDTO>> response = new ApiResponseDTO<>(true, list);
		return (new ResponseEntity<>(response, HttpStatus.OK));
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody EstudianteDTO estudianteDTO) {
		EstudianteDTO estudianteDTOResult = service.save(estudianteDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, estudianteDTOResult), HttpStatus.CREATED);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody EstudianteDTO estudianteDTO) {
		EstudianteDTO resultDTO = service.update(estudianteDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> eliminar(@RequestBody EstudianteDTO estudianteDTO) {
		EstudianteDTO resultDTO = service.delete(estudianteDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		EstudianteDTO dto = new EstudianteDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}



}
