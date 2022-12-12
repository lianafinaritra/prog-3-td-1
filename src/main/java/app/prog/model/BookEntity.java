package app.prog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    //TODO-6: join BookEntity with AuthorEntity and make the correct change so that the API does not change
    // Must know : a book can have only one author but an author can have many books
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    private int pageNumber;
    private LocalDate releaseDate;

    @ManyToMany
    @JoinTable(
            name = "book_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryEntity> categories;

    public boolean hasAuthor() {
        return author != null;
    }

}
