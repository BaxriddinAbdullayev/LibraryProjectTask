package dasturlash.uz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {
    private String id;

    @NotBlank(message = "Name required")
    @Size(min = 2, max = 255, message = "Name length must be between 2 and 255")
    private String name;

    @NotBlank(message = "Surname required")
    @Size(min = 2, max = 255, message = "Surname length must be between 2 and 255")
    private String surname;

    @NotBlank(message = "Phone required")
    @Size(min = 12, max = 12, message = "Enter current phone number")
    private String phone;

    @NotNull(message = "CreatedDate required")
    @Past(message = "Must be back before the current date")
    private LocalDate createdDate;
}
