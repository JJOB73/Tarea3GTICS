package com.example.tareaclase3.controller;

import com.example.tareaclase3.repository.JobHistoryRepository;
import com.example.tareaclase3.entity.JobHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private JobHistoryRepository historyRepo;

    @GetMapping
    public String viewHistory(@RequestParam(value = "search", required = false) String search, Model model) {
        List<JobHistory> history = (search == null || search.isEmpty())
                ? historyRepo.findAll()
                : historyRepo.findBySearch(search.toLowerCase());
        model.addAttribute("history", history);
        return "history/list";
    }
}

