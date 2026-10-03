package com.example.demo.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Đại diện một bản ghi người chơi trong bảng Player.
 * <p>
 * Dùng Java Record: các field tự động có getter, equals, hashCode, toString.
 * Annotation validate sẽ kích hoạt khi nhận request POST.
 * </p>
 *
 * @param name Tên người chơi (bắt buộc, không rỗng)
 * @param mode Chế độ chơi (bắt buộc, không rỗng)
 * @param time Thời gian (giây hoặc ms – tùy thiết kế game, >= 0)
 */
public record Player(

        @NotBlank(message = "Tên người chơi (name) không được để trống")
        String name,

        @NotBlank(message = "Chế độ chơi (mode) không được để trống")
        String mode,

        @NotNull(message = "Thời gian (time) không được để trống")
        @Min(value = 0, message = "Thời gian (time) phải >= 0")
        Integer time

) {}
