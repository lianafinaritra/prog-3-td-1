package app.prog.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UpdateBook {
    private int id;
    private String authorName;
    private String title;
}
