package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.UnidadMedidaFacadeImpl;
import com.entidades.buenSabor.business.facade.UnidadMedidaFacade;
import com.entidades.buenSabor.domain.dto.UnidadMedidaDto;
import com.entidades.buenSabor.domain.entities.UnidadMedida;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unidadMedida")
@CrossOrigin(origins="*")
public class UnidadMedidaController extends BaseControllerImp<UnidadMedida, UnidadMedidaDto, Long, UnidadMedidaFacadeImpl> {
    private static final Logger logger = LoggerFactory.getLogger(BaseControllerImp.class);

    @Autowired
    private UnidadMedidaFacade unidadMedidaFacade;

    public UnidadMedidaController(UnidadMedidaFacadeImpl facade) {
        super(facade);
    }

    @PostMapping
    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<UnidadMedidaDto> create(UnidadMedidaDto entity){
        return super.create(entity);
    }

    @PutMapping("/{id}")
    @Override
    @PreAuthorize("hasAnyAuthority('EMPLEADO','ADMIN')")
    public ResponseEntity<UnidadMedidaDto> edit(UnidadMedidaDto edit, Long id){
        return super.edit(edit,id);
    }
}
