package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.domain.dto.ProyeccionesEstadisticas.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EstadisticasService {
    List<RankingProductos> bestProducts(Date initialDate, Date endDate);
    List<IngresosDiarios> ingresosDiarios(LocalDate initialDate, LocalDate endDate);
    List<IngresosMenusales> ingresosMensuales(LocalDate initialDate, LocalDate endDate);
    GananciasNetas findCostosGananciasByFecha(LocalDate initialDate, LocalDate endDate);
    List<PedidosCliente> findCantidadPedidosPorCliente(LocalDate startDate, LocalDate endDate);
    byte[] rankingExcel(Date fechaDesde, Date fechaHasta) throws IOException;
    byte[] ingresosDiariosExcel(LocalDate fechaDesde, LocalDate fechaHasta) throws IOException;
    byte[] ingresosMensualesExcel(LocalDate fechaDesde, LocalDate fechaHasta) throws IOException;
    byte[] gananciasNetasExcel(LocalDate fechaDesde, LocalDate fechaHasta) throws IOException;
    byte[] cantidadPedidosPorClienteExcel(LocalDate fechaDesde, LocalDate fechaHasta) throws IOException;
}
