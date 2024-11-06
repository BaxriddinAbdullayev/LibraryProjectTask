package dasturlash.uz.controller;

import dasturlash.uz.dto.StudentBookDTO;
import dasturlash.uz.service.StudentBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student-book")
@RestController
public class StudentBookController {

    @Autowired
    private StudentBookService studentBookService;

    @PostMapping("")
    public ResponseEntity<StudentBookDTO> create(@Valid @RequestBody StudentBookDTO dto){
        StudentBookDTO result = studentBookService.create(dto);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("")
    public ResponseEntity<StudentBookDTO> put(@Valid @RequestBody StudentBookDTO dto){
        StudentBookDTO result = studentBookService.returnBook(dto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("")
    public ResponseEntity<List<StudentBookDTO>> all(){
        List<StudentBookDTO> result = studentBookService.studentBookList();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentBookDTO> getById(@PathVariable("id") String id){
        StudentBookDTO result = studentBookService.getStudentBookById(id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StudentBookDTO>> allByStudentId(@PathVariable("studentId") String studentId){
        List<StudentBookDTO> result = studentBookService.allByStudentId(studentId);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<StudentBookDTO>> allByBookId(@PathVariable("bookId") String bookId){
        List<StudentBookDTO> result = studentBookService.allByBookId(bookId);
        return ResponseEntity.ok().body(result);
    }



}
