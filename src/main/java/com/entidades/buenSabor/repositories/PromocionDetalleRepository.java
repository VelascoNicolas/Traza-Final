package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.PromocionDetalle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocionDetalleRepository extends BaseRepository<PromocionDetalle,Long>{
    @Query(value = "SELECT * FROM PROMOCION_DETALLE WHERE ID = :id", nativeQuery = true)
    PromocionDetalle getById2(@Param("id") Long id);
}
