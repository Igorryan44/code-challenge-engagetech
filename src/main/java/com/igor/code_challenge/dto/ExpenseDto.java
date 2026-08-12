package com.igor.code_challenge.dto;

import com.igor.code_challenge.model.Expense;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

public record ExpenseDto(

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime date,
        String reason,
        Double value,
        Double vat,
        Long userId
) {
    public static ExpenseDto toDto(Expense expense) {
        if (expense == null){return null;}
        return new ExpenseDto(expense.getDate(), expense.getReason(), expense.getValue(), 20d, expense.getUser().getId());
    }

    public static List<ExpenseDto> toDto(List<Expense> expenses) {
        if (expenses.isEmpty()) {return List.of();}
        return expenses.stream().map(ExpenseDto::toDto).toList();
    }

    public static Expense toEntity(ExpenseDto dto) {
        if (dto == null) {return null;}
        return new Expense(null, dto.date(), dto.reason(), dto.value(), 20d, null);
    }

    public static List<Expense> toEntity(List<ExpenseDto> dtos) {
        if (dtos.isEmpty()) {return List.of();}
        return dtos.stream().map(ExpenseDto::toEntity).toList();
    }
}
