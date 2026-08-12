package com.igor.code_challenge.service;

import com.igor.code_challenge.dto.ExpenseDto;
import com.igor.code_challenge.model.Expense;
import com.igor.code_challenge.model.User;
import com.igor.code_challenge.repository.ExpenseRepository;
import com.igor.code_challenge.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public ExpenseDto createExpense(ExpenseDto dto, Long userId) {
        User u = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));

        Expense e = ExpenseDto.toEntity(dto);
        e.setValue(dto.value() + applyTax(dto.value()));
        e.setUser(u);

        return ExpenseDto.toDto(expenseRepository.save(e));
    }

    public List<ExpenseDto> findAllByUser(Long userId) {
        return ExpenseDto.toDto(expenseRepository.findAllExpensesByUserId(userId).orElseThrow(RuntimeException::new));
    }

    public ExpenseDto findExpenseByIdAndUserId(Long id, Long userId) {
        return ExpenseDto.toDto(expenseRepository.findExpenseByIdAndUserId(id, userId).orElseThrow(() -> new EntityNotFoundException("Expense not found")));
    }

    public void deleteExpenseByIdAndUserId(Long id, Long userId) {
        expenseRepository.deleteExpenseByIdAndUserId(id, userId);
    }

    private Double applyTax(Double value) {
        return value * 0.2;
    }
}
