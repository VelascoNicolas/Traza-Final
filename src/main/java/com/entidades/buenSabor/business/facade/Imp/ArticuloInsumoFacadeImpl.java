package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.ArticuloInsumoFacade;
import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.mapper.ArticuloMapper;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.ArticuloInsumoService;
import com.entidades.buenSabor.business.service.Base.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.entidades.buenSabor.business.service.Imp.ArticuloInsumoServiceImpl;
import com.entidades.buenSabor.domain.dto.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.dto.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.repositories.ArticuloInsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticuloInsumoFacadeImpl  implements ArticuloInsumoFacade {
    @Autowired
    private ArticuloInsumoService articuloInsumoService;
    @Autowired
    private ArticuloMapper articuloMapper;


    @Override
    public ArticuloInsumoDto createNew(ArticuloInsumoDto request) {
        ArticuloInsumo articuloInsumo = articuloMapper.toEntity(request);
        ArticuloInsumo savedEntity = articuloInsumoService.create(articuloInsumo);
        return (ArticuloInsumoDto) articuloMapper.toDTO(savedEntity);
    }

    @Override
    public ArticuloInsumoDto getById(Long id) {
        ArticuloInsumo articuloInsumo = articuloInsumoService.getById(id);
        return (ArticuloInsumoDto) articuloMapper.toDTO(articuloInsumo);
    }

    @Override
    public List<ArticuloInsumoDto> getAll() {
        List<ArticuloInsumo> articulosInsumos = articuloInsumoService.getAll();
        return articuloMapper.toDtoListInsumo(articulosInsumos);
    }

    @Override
    public String deleteById(Long id) {
        return articuloInsumoService.deleteLogico(id);
    }

    @Override
    public ArticuloInsumoDto update(ArticuloInsumoDto request, Long id) {
        ArticuloInsumo articuloInsumo = articuloMapper.toEntity(request);
         // Asegúrate de configurar el ID correctamente
        ArticuloInsumo updatedEntity = articuloInsumoService.update(articuloInsumo,id);
        return (ArticuloInsumoDto) articuloMapper.toDTO(updatedEntity);
    }

    @Override
    public List<ArticuloInsumoDto> getArticuloInsumoBySucursal(Long idSucursal) {
        List<ArticuloInsumo> articulosInsumos = articuloInsumoService.getArticuloInsumoBySucursal(idSucursal);
        return articuloMapper.toDtoListInsumo(articulosInsumos);
    }

    @Override
    public ResponseEntity<List<Map<String, Object>>> getAllImagesByArticuloId(Long id) {
        return articuloInsumoService.getAllImagesByArticuloId(id);
    }

    @Override
    public ResponseEntity<String> uploadImages(MultipartFile[] files, Long id) {
        return articuloInsumoService.uploadImages(files,id);
    }

    @Override
    public ResponseEntity<String> deleteImage(String publicId, Long id) {
        return articuloInsumoService.deleteImage(publicId, id);
    }

    @Override
    public List<ArticuloInsumoDto> getElaborados() {
        List<ArticuloInsumo> articulosInsumos = articuloInsumoService.getElaborados();
        return articuloMapper.toDtoListInsumo(articulosInsumos);
    }

    @Override
    public List<ArticuloInsumoDto> getNoElaborados() {
        List<ArticuloInsumo> articulosInsumos = articuloInsumoService.getNoElaborados();
        return articuloMapper.toDtoListInsumo(articulosInsumos);
    }
}
