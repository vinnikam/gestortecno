package edu.ucentral.vinni.infraestructura.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PortatilPayLoad (
    @NotBlank(message = "El serial es requerido")
    String serial,
    @NotBlank(message = "La  marca es requerido")
    String marca,
    @NotNull(message = "La memoria es requerida")
    @Positive(message = "La memoria debe ser un número mayor a cero")
    Integer memoria)
{
}
