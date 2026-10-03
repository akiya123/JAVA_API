package com.dacn.domin.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Một bản ghi người chơi. Dùng chung cho request (POST) và response (GET).
 */
public record Player(
        @NotBlank(message = "name không được để trống")
        String name,

        @NotBlank(message = "mode không được để trống")
        String mode,

        @NotNull(message = "time không được để trống")
        @Min(value = 0, message = "time phải lớn hơn hoặc bằng 0")
        Integer time
) {
}
