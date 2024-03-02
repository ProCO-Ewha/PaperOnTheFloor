package com.example.paperonthefloor.web;

import com.example.paperonthefloor.domain.Paper;
import com.example.paperonthefloor.service.PaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping
@RequiredArgsConstructor
public class FloorController {
    private final PaperService paperService;

    @GetMapping("/home")
    public Paper showFloor (){
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();
        System.out.println(paperService.getPapersByDate(year, month, day));
        return paperService.getPapersByDate(year, month, day);
    }
}
