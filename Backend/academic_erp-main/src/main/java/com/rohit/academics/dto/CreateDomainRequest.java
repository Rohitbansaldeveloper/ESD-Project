package com.rohit.academics.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record CreateDomainRequest(
    @NotNull(message = "program should be present")
    @NotEmpty(message = "program should be present")
    @NotBlank(message = "program should be present")
    @JsonProperty("program")
    String program,

    @NotNull(message="batch is required")
    @JsonProperty("batch")
    String batch,

    @NotNull(message = "capacity should be present")
    @NotEmpty(message = "capacity should be present")
    @NotBlank(message = "capacity should be present")
    @JsonProperty("capacity")
    int capacity,

    @NotNull(message = "qualification should be present")
    @JsonProperty("qualification")
    String qualification
)
{
}
