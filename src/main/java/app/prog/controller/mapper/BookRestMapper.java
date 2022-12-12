package app.prog.controller.mapper;

import app.prog.controller.model.CreateBook;
import app.prog.controller.model.UpdateBook;
import app.prog.controller.response.BookResponse;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.repository.AuthorRepository;
import app.prog.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Component
public class BookRestMapper {
    private AuthorService service;
    public BookResponse toRest(BookEntity domain) {
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .authorName(domain.getAuthor().getName())
                .hasAuthor(domain.hasAuthor())
                .categories(domain.getCategories())
                .build();
    }

    public BookEntity toDomain(CreateBook rest) {
        Optional<AuthorEntity> optional = service.searchByName(rest.getAuthorName());
        if (optional.isPresent()) {
            return BookEntity.builder()
                    .author(optional.get())
                    .title(rest.getTitle())
                    .pageNumber(0) //Constraint not null in database, default value is 0
                    .build();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, rest.getAuthorName() + " Not found");
        }
    }

    public BookEntity toDomain(UpdateBook rest) {
        Optional<AuthorEntity> optional = service.searchByName(rest.getAuthorName());
        if (optional.isPresent()) {
            return BookEntity.builder()
                    .author(optional.get())
                    .title(rest.getTitle())
                    .pageNumber(0) //Constraint not null in database, default value is 0
                    .build();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, rest.getAuthorName() + " Not found");
        }
    }
}
