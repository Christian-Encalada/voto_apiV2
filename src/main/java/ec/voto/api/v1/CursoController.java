package ec.voto.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.voto.api.dto.ApiResponseDTO;
import ec.voto.api.dto.CursoDTO;
import ec.voto.api.service.CursoService;

import jakarta.validation.Valid;
import java.util.List;
import ec.voto.api.domain.Estudiante;
@RestController
@RequestMapping(value = { "/api/v1.0/curso" })
public class CursoController {

	@Autowired
	private CursoService service;

	@GetMapping("/{cursoId}/estudiantes")
	public List<Estudiante> getEstudiantesPorCurso(@PathVariable Long cursoId) {
		return service.getEstudiantesPorCurso(cursoId);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<CursoDTO> list = service.findAll(new CursoDTO());
		ApiResponseDTO<List<CursoDTO>> response = new ApiResponseDTO<>(true, list);
		return (new ResponseEntity<>(response, HttpStatus.OK));
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody CursoDTO cursoDTO) {
		CursoDTO cursoDTOResult = service.save(cursoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, cursoDTOResult), HttpStatus.CREATED);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody CursoDTO cursoDTO) {
		CursoDTO resultDTO = service.update(cursoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> eliminar(@RequestBody CursoDTO cursoDTO) {
		CursoDTO resultDTO = service.delete(cursoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		CursoDTO dto = new CursoDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}


}
