package dasturlash.uz.service;

import dasturlash.uz.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private List<StudentDTO> studentList = new LinkedList<>();

    public StudentService() {
        StudentDTO dto1 = new StudentDTO();
        dto1.setId("7c9c085f-0fc5-479a-bfde-f921613b8981");
        dto1.setName("Alish");
        dto1.setSurname("Aliyev");
        dto1.setPhone("123456789");
        dto1.setCreatedDate(LocalDate.of(1990, 1, 1));
        studentList.add(dto1);
        //-------------------------
        StudentDTO dto2 = new StudentDTO();
        dto2.setId("1dff8f59-82b1-443e-9475-e1f6b16d89f6");
        dto2.setName("Valish");
        dto2.setSurname("Valiyev");
        dto2.setPhone("987654321");
        dto2.setCreatedDate(LocalDate.of(1995, 2, 1));
        studentList.add(dto2);
        //-------------------------
        StudentDTO dto3 = new StudentDTO();
        dto3.setId(UUID.randomUUID().toString());
        dto3.setName("Eshmat");
        dto3.setSurname("Eshmatov");
        dto3.setPhone("987654321");
        dto3.setCreatedDate(LocalDate.of(2016, 2, 1));
        studentList.add(dto3);
        //-------------------------
        StudentDTO dto4 = new StudentDTO();
        dto4.setId(UUID.randomUUID().toString());
        dto4.setName("Toshmat");
        dto4.setSurname("Toshmatov");
        dto4.setPhone("987654321");
        dto4.setCreatedDate(LocalDate.of(2005, 2, 1));
        studentList.add(dto4);
    }

    public List<StudentDTO> getStudentList() {
        return studentList;
    }

    public StudentDTO getById(String id) {
        StudentDTO exist = get(id);
        if (exist == null) {
            throw new IllegalArgumentException("Student not found");
        }
        return exist;
    }

    public StudentDTO create(StudentDTO dto) {
        dto.setId(UUID.randomUUID().toString());
        dto.setCreatedDate(LocalDate.now());
        studentList.add(dto);
        return dto;
    }

    public boolean update(String id, StudentDTO dto) {
        StudentDTO exist = get(id);
        if(exist == null) {
            throw new IllegalArgumentException("Student not found");
        }
        exist.setName(dto.getName());
        exist.setSurname(dto.getSurname());
        exist.setPhone(dto.getPhone());
        return true;
    }

    public boolean delete(String id) {
        StudentDTO exist = get(id);
        if (exist == null) {
            throw new IllegalArgumentException("Student not found");
        }
        studentList.remove(exist);
        return true;
    }

    public StudentDTO get(String id) {
        for (StudentDTO exist : studentList) {
            if (exist.getId().equals(id)) {
                return exist;
            }
        }
        return null;
    }

}
