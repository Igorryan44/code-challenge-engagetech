package com.igor.code_challenge.dto;

import com.igor.code_challenge.model.Expense;

import java.time.LocalDateTime;
import java.util.List;

public record ExpenseDto(
        LocalDateTime date,
        String reason,
        Double value,
        Double vat
) {
    public static ExpenseDto toDto(Expense expense) {
        if (expense == null){return null;}
        return new ExpenseDto(expense.getDate(), expense.getReason(), expense.getValue(), 20d);
    }

    public static List<ExpenseDto> toDto(List<Expense> expenses) {
        if (expenses.isEmpty()) {return List.of();}
        return expenses.stream().map(ExpenseDto::toDto).toList();
    }

    public static Expense toEntity(ExpenseDto dto) {
        if (dto == null) {return null;}
        return new Expense(null, dto.date(), dto.reason(), dto.value(), 20d);
    }

    public static List<Expense> toEntity(List<ExpenseDto> dtos) {
        if (dtos.isEmpty()) {return List.of();}
        return dtos.stream().map(ExpenseDto::toEntity).toList();
    }
}
