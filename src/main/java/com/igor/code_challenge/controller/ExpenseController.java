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

    @PostMapping("/{userId}")
    public ResponseEntity<ExpenseDto> createUser(@RequestBody ExpenseDto dto, @PathVariable Long userId) {
        return ResponseEntity.ok(expenseService.createExpense(dto, userId));
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<List<ExpenseDto>> findAllByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(expenseService.findAllByUser(userId));
    }

    @GetMapping("/{userId}/{id}")
    public ResponseEntity<ExpenseDto> findExpenseByIdAndUserId(@PathVariable Long id, @PathVariable Long userId) {
        return ResponseEntity.ok(expenseService.findExpenseByIdAndUserId(id, userId));
    }

    @DeleteMapping("/{userId}/delete/{id}")
    public ResponseEntity<Void> deleteExpenseByIdAndUserId(@PathVariable Long id, @PathVariable Long userId) {
        expenseService.deleteExpenseByIdAndUserId(id, userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
