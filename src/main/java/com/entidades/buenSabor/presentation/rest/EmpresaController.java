package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.EmpresaFacadeImpl;

import com.entidades.buenSabor.domain.dto.EmpresaDto;

import com.entidades.buenSabor.domain.dto.EmpresaLargeDto;
import com.entidades.buenSabor.domain.entities.Empresa;

import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/empresa")
@CrossOrigin("*")
public class EmpresaController extends BaseControllerImp<Empresa, EmpresaDto, Long, EmpresaFacadeImpl> {
    public EmpresaController(EmpresaFacadeImpl facade) {
        super(facade);
    }

    @Override
    @PostMapping
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<EmpresaDto> create(@RequestBody EmpresaDto entity) {
        return super.create(entity);
    }

    @Override
    @PutMapping("/{id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<EmpresaDto> edit (EmpresaDto entity, Long id){
        return super.edit(entity,id);
    }
}
