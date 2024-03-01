package com.example.paperonthefloor.web;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaperForm {
    private String author;
    private String text;

}
