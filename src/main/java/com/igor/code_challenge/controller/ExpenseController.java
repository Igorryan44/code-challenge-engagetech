package com.igor.code_challenge.controller;

import com.igor.code_challenge.dto.ExpenseDto;
import com.igor.code_challenge.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<ExpenseDto> createUser(@RequestBody ExpenseDto dto) {
        return ResponseEntity.ok(expenseService.createExpense(dto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ExpenseDto>> findAll() {
        return ResponseEntity.ok(expenseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        expenseService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
