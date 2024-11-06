package dasturlash.uz.controller;

import dasturlash.uz.dto.StudentDTO;
import dasturlash.uz.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping({"/",""})
    public ResponseEntity<List<StudentDTO>> all() {
        return ResponseEntity.ok(studentService.getStudentList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> byId(@PathVariable("id") String id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody StudentDTO dto) {
        StudentDTO studentDTO = studentService.create(dto);
        ResponseEntity<StudentDTO> responseEntity = new ResponseEntity<>(studentDTO, HttpStatusCode.valueOf(200));
        return responseEntity;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable("id") String id, @RequestBody StudentDTO dto) {
        boolean result = studentService.update(id, dto);
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>(result, HttpStatusCode.valueOf(200));
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        boolean result = studentService.delete(id);
        return ResponseEntity.ok().body(result);
    }
}
