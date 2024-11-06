package dasturlash.uz.service;

import dasturlash.uz.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    private List<BookDTO> bookList = new LinkedList<>();

    public BookService() {
        BookDTO book1 = new BookDTO();
        book1.setId("98f07c52-9c7b-4164-ab90-ac495be9c676");
        book1.setTitle("Book 1");
        book1.setAuthor("Author 1");
        book1.setPublishYear(LocalDate.of(1991, 1, 1));
        bookList.add(book1);

        BookDTO book2 = new BookDTO();
        book2.setId("64575125-efec-4ceb-a89e-10af854b0419");
        book2.setTitle("Book 2");
        book2.setAuthor("Author 2");
        book2.setPublishYear(LocalDate.of(2004, 1, 2));
        bookList.add(book2);

        BookDTO book3 = new BookDTO();
        book3.setId(UUID.randomUUID().toString());
        book3.setTitle("Book 3");
        book3.setAuthor("Author 3");
        book3.setPublishYear(LocalDate.of(2013, 1, 3));
        bookList.add(book3);

        BookDTO book4 = new BookDTO();
        book4.setId(UUID.randomUUID().toString());
        book4.setTitle("Book 4");
        book4.setAuthor("Author 4");
        book4.setPublishYear(LocalDate.of(2024, 1, 4));
        bookList.add(book4);
    }

    public BookDTO create(BookDTO dto) {
        dto.setId(UUID.randomUUID().toString());
        bookList.add(dto);
        return dto;
    }

    public List<BookDTO> getBookList() {
        return bookList;
    }

    public BookDTO getById(String id) {
        BookDTO exist = get(id);
        if (exist == null) {
            throw new IllegalArgumentException("Book not found");
        }
        return exist;
    }

    public boolean delete(String id) {
        BookDTO exist = get(id);
        if (exist == null) {
            throw new IllegalArgumentException("Book not found");
        }
        bookList.remove(exist);
        return true;
    }

    public boolean update(String id, BookDTO dto) {
        BookDTO exist = get(id);
        if (exist == null) {
            throw new IllegalArgumentException("Book not found");
        }

        exist.setTitle(dto.getTitle());
        exist.setAuthor(dto.getAuthor());
        exist.setPublishYear(dto.getPublishYear());

        return true;
    }

    public BookDTO get(String id) {
        for (BookDTO exist : bookList) {
            if (exist.getId().equals(id)) {
                return exist;
            }
        }
        return null;
    }
}
