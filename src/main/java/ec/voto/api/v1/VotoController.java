package ec.voto.api.v1;

import ec.voto.api.dto.CursoDTO;
import ec.voto.api.repository.VotoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.voto.api.dto.ApiResponseDTO;
import ec.voto.api.dto.VotoDTO;
import ec.voto.api.service.VotoService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = { "/api/v1.0/voto" })
public class VotoController {

    @Autowired
    private VotoService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listar() {
        List<VotoDTO> list = service.findAll(new VotoDTO());
        ApiResponseDTO<List<VotoDTO>> response = new ApiResponseDTO<>(true, list);
        return (new ResponseEntity<>(response, HttpStatus.OK));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardar(@RequestBody VotoDTO votoDTO) {
        VotoDTO votoDTOResult = service.save(votoDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, votoDTOResult), HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody VotoDTO votoDTO) {
        VotoDTO resultDTO = service.update(votoDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminar(@RequestBody VotoDTO votoDTO) {
        VotoDTO resultDTO = service.delete(votoDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
        VotoDTO dto = new VotoDTO();
        dto.setId(id);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
    }


}
