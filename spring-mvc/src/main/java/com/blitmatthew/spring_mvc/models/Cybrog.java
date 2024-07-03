package com.blitmatthew.spring_mvc.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Cybrog {
    private Integer id;
    @NotNull
    @Size(min = 5, max = 75, message = "Name has to be 5 to 75 characters long")
    private String name;
    @NotNull
    @Size(min = 2, max = 15, message = "Alloy has to be in between 2 to 15 characters long")
    private String alloy;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Must alphanumeric serial number only")
    private String serialNumber;
    private Integer noOfWeapons;
    @NotNull
    private Integer noOfCpus;
    @NotNull
    private Integer storage;
}
