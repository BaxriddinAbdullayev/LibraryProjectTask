package dasturlash.uz.controller;

import dasturlash.uz.dto.BookDTO;
import dasturlash.uz.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody BookDTO dto) {
        BookDTO responseDTO = bookService.create(dto);
        return ResponseEntity.ok().body(responseDTO);
    }

    @GetMapping({"/",""})
    public ResponseEntity<List<BookDTO>> all(){
        return ResponseEntity.ok(bookService.getBookList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> byId(@PathVariable("id") String id){
        return ResponseEntity.ok(bookService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        return ResponseEntity.ok(bookService.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id,
                                    @RequestBody BookDTO dto){
        return ResponseEntity.ok(bookService.update(id,dto));
    }


}
