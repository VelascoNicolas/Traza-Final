package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.UnidadMedidaDto;

public interface UnidadMedidaFacade extends BaseFacade<UnidadMedidaDto, Long> {
    UnidadMedidaDto createUnidadMedida(UnidadMedidaDto dto);

    UnidadMedidaDto updateUnidadMedida(Long id, UnidadMedidaDto dto);
}
