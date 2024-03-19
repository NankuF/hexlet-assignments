package exercise.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
public class GuestCreateDTO {
    @NotBlank
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @Pattern(regexp = "^(\\+[\\d]{11,13})$")
    private String phoneNumber;
    @Size(min = 4, max = 4, message = "Club Card must have 4 charaters")
    private String clubCard;
    @FutureOrPresent
    private LocalDate cardValidUntil;

}
// END
