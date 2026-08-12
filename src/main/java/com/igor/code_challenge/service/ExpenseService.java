package com.igor.code_challenge.service;

import com.igor.code_challenge.dto.ExpenseDto;
import com.igor.code_challenge.model.Expense;
import com.igor.code_challenge.repository.ExpenseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public ExpenseDto createExpense(ExpenseDto dto) {
        Expense e = ExpenseDto.toEntity(dto);
        e.setValue(dto.value() + applyTax(dto.value()));
        return ExpenseDto.toDto(expenseRepository.save(e));
    }

    public List<ExpenseDto> findAll() {
        return ExpenseDto.toDto(expenseRepository.findAll());
    }

    public ExpenseDto findById(Long id) {
        return ExpenseDto.toDto(expenseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Expense not found")));
    }

    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }

    private Double applyTax(Double value) {
        return value * 0.2;
    }
}
