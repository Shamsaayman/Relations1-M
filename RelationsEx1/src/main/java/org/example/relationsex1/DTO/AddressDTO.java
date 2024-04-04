package org.example.relationsex1.DTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacher_id;
    @NotEmpty(message = "area should be not empty")
    private String area;
    @NotEmpty(message = "street should be not empty")
    private String street;
    @NotNull(message = "buildingNumber should be not empty")
    private Integer buildingNumber;
}
