package com.igor.code_challenge.repository;

import com.igor.code_challenge.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    Optional<List<Expense>> findAllExpensesByUserId(Long userId);
    Optional<Expense> findExpenseByIdAndUserId(Long id,Long userId);
    void deleteExpenseByIdAndUserId(Long id,Long userId);
}
