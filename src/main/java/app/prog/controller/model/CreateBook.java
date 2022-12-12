package app.prog.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class CreateBook {
    private String authorName;
    private String title;
}
