package ec.voto.api.v1;

import ec.voto.api.dto.ApiResponseDTO;
import ec.voto.api.dto.CursoDTO;
import ec.voto.api.dto.EstudianteDTO;
import ec.voto.api.dto.Lista_De_VotosDTO;
import ec.voto.api.service.Lista_De_VotosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = { "/api/v1.0/lista_de_votos" })
public class Lista_De_VotosController {

	@Autowired
	private Lista_De_VotosService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<Lista_De_VotosDTO> list = service.findAll(new Lista_De_VotosDTO());
		ApiResponseDTO<List<Lista_De_VotosDTO>> response = new ApiResponseDTO<>(true, list);
		return (new ResponseEntity<Object>(response, HttpStatus.OK));
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody Lista_De_VotosDTO Lista_De_VotosDTO) {
		Lista_De_VotosDTO Lista_De_VotosDTOResult = service.save(Lista_De_VotosDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, Lista_De_VotosDTOResult), HttpStatus.CREATED);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody Lista_De_VotosDTO Lista_De_VotosDTO) {
		Lista_De_VotosDTO resultDTO = service.update(Lista_De_VotosDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> eliminar(@RequestBody Lista_De_VotosDTO Lista_De_VotosDTO) {
		Lista_De_VotosDTO resultDTO = service.delete(Lista_De_VotosDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}


	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		Lista_De_VotosDTO dto = new Lista_De_VotosDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}

}
