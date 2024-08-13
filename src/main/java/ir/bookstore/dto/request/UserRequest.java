package ir.bookstore.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserRequest {
    @NotNull
    @NotBlank
    private final String username;

    @NotNull
    @NotBlank
    private final String password;
}
