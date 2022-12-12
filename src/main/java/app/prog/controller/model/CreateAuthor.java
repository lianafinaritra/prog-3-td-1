package app.prog.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class CreateAuthor {
    private String name;
    private String particularity;
}
