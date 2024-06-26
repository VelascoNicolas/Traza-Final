package com.entidades.buenSabor.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ArticuloInsumoDto extends ArticuloDto{
    private Double precioCompra;
    private Double stockActual;
    private Double stockMaximo;
    private Double stockMinimo;
    private Boolean esParaElaborar;

}
