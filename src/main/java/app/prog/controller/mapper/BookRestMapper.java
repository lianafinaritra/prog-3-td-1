package app.prog.controller.mapper;

import app.prog.controller.model.CreateBook;
import app.prog.controller.model.UpdateBook;
import app.prog.controller.response.BookResponse;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.model.CategoryEntity;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
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
        List<CategoryEntity> categories = new ArrayList<>();
        if (optional.isPresent()) {
            return BookEntity.builder()
                    .author(optional.get())
                    .title(rest.getTitle())
                    .categories(categories)
                    .pageNumber(0)
                    .build();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, rest.getAuthorName() + " Not found");
        }
    }

    public BookEntity toDomain(UpdateBook rest) {
        Optional<AuthorEntity> optional = service.searchByName(rest.getAuthorName());
        if (optional.isPresent()) {
            return BookEntity.builder()
                    .id(rest.getId())
                    .author(optional.get())
                    .title(rest.getTitle())
                    .build();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, rest.getAuthorName() + " Not found");
        }
    }
}
