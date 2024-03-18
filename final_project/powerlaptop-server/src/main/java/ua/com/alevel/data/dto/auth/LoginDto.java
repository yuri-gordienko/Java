package ua.com.alevel.data.dto.auth;

import jakarta.validation.constraints.NotNull;

public record LoginDto(@NotNull String username, @NotNull String password) { }
