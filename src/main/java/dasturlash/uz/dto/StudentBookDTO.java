package dasturlash.uz.dto;

import dasturlash.uz.enums.StudentBookStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudentBookDTO {
    private String id;

    @NotNull(message = "StudentId required")
    private String studentId;

    @NotNull(message = "BookId required")
    private String bookId;

    private LocalDateTime createdDate;
    private StudentBookStatus status;
    private LocalDateTime returnedDate;

    private StudentDTO student;
    private BookDTO book;
}
