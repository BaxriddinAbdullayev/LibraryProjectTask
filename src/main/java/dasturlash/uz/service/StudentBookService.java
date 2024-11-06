package dasturlash.uz.service;

import dasturlash.uz.dto.BookDTO;
import dasturlash.uz.dto.StudentBookDTO;
import dasturlash.uz.dto.StudentDTO;
import dasturlash.uz.enums.StudentBookStatus;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentBookService {

    @Autowired
    private StudentService studentService;
    @Autowired
    private BookService bookService;

    private List<StudentBookDTO> studentBookList =new LinkedList<>();

    public StudentBookDTO create(StudentBookDTO dto){
        StudentDTO student = studentService.get(dto.getStudentId());
        if(student == null){
            throw new IllegalArgumentException("Student not found");
        }

        BookDTO book = bookService.get(dto.getBookId());
        if(book == null){
            throw new IllegalArgumentException("Book not found");
        }

        StudentBookDTO studentBook=new StudentBookDTO();
        studentBook.setId(UUID.randomUUID().toString());
        studentBook.setStudentId(dto.getStudentId());
        studentBook.setBookId(dto.getBookId());
        studentBook.setStatus(StudentBookStatus.TAKEN);
        studentBook.setCreatedDate(LocalDateTime.now());
        studentBookList.add(studentBook);
        return studentBook;
    }

    public StudentBookDTO returnBook(StudentBookDTO dto){
        for (StudentBookDTO studentBookDTO: studentBookList){
            if(studentBookDTO.getStudentId().equals(dto.getStudentId()) &&
            studentBookDTO.getBookId().equals(dto.getBookId()) &&
            studentBookDTO.getStatus().equals(StudentBookStatus.TAKEN)){
                studentBookDTO.setStatus(StudentBookStatus.RETURNED);
                studentBookDTO.setReturnedDate(LocalDateTime.now());
                return studentBookDTO;
            }
        }
        throw new IllegalArgumentException("StudentBook not found");
    }

    public List<StudentBookDTO> studentBookList() {
        return studentBookList;
    }

    public StudentBookDTO getStudentBookById(String id){
        for (StudentBookDTO studentBook: studentBookList){
            if(studentBook.getId().equals(id)){
                StudentDTO student = studentService.get(studentBook.getStudentId());
                studentBook.setStudent(student);

                BookDTO book = bookService.get(studentBook.getBookId());
                studentBook.setBook(book);

                return studentBook;
            }
        }
        throw new IllegalArgumentException("StudentBook not found");
    }

    public List<StudentBookDTO> allByStudentId(String studentId){
        List<StudentBookDTO> dtoList = new LinkedList<>();
        for (StudentBookDTO studentBook: studentBookList){
            if(studentBook.getStudentId().equals(studentId)){
                dtoList.add(studentBook);
            }
        }
        return dtoList;
    }

    public List<StudentBookDTO> allByBookId(String bookId){
        List<StudentBookDTO> dtoList = new LinkedList<>();
        for (StudentBookDTO studentBook: studentBookList){
            if(studentBook.getBookId().equals(bookId)){
                dtoList.add(studentBook);
            }
        }
        return dtoList;
    }
}
