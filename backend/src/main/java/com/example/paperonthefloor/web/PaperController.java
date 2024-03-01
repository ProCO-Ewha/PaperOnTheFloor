package com.example.paperonthefloor.web;

import com.example.paperonthefloor.domain.Paper;
import com.example.paperonthefloor.service.PaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/papers")
@RequiredArgsConstructor
public class PaperController {
    private final PaperService paperService;
    @PostMapping("/new")
    public ResponseEntity<Long> write (@RequestBody PaperForm paperForm,  BindingResult result){
        if (result.hasErrors()) { return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
        Paper paper = new Paper();
        paper.setAuthor(paperForm.getAuthor());
        paper.setText(paperForm.getText());
        paper.setDate(LocalDateTime.now());
        Long paperId = paperService.write(paper);
        return new ResponseEntity<>(paperId, HttpStatus.CREATED);
    }
}
