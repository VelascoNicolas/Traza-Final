package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.service.EstadisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/estadisticas")
public class EstadisticasController {

    @Autowired
    private EstadisticasService service;

    @GetMapping("/ranking")
  //  @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> rankin (
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta){
        return ResponseEntity.ok(service.bestProducts(fechaDesde, fechaHasta));
    }

    @GetMapping("/recaudacionesDiarias")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> recaudacionesDiarias (
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaHasta){
        return ResponseEntity.ok(service.ingresosDiarios(fechaDesde, fechaHasta));
    }

    @GetMapping("/recaudacionesMensuales")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> recaudacionesMensuales (
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaHasta){
        return ResponseEntity.ok(service.ingresosMensuales(fechaDesde, fechaHasta));
    }

    @GetMapping("/costosGanancias")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> costosGanancias (
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaHasta){
        return ResponseEntity.ok(service.findCostosGananciasByFecha(fechaDesde, fechaHasta));
    }

    @GetMapping("/pedidosCliente")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> pedidosCliente (
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaHasta){
        return ResponseEntity.ok(service.findCantidadPedidosPorCliente(fechaDesde, fechaHasta));
    }

    @GetMapping("/excelRanking")
    public ResponseEntity<?> excelRanking (
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta) throws IOException {
        byte[] excelContent = service.rankingExcel(fechaDesde, fechaHasta);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.set(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=estadisticasRanking.xls");
        headers.setContentLength(excelContent.length);

        return ResponseEntity.ok()
                .headers(headers)
                .body(excelContent);
    }

    @GetMapping("/excelIDiario")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> excelDiario (
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaHasta) throws IOException {
        byte[] excelContent = service.ingresosDiariosExcel(fechaDesde, fechaHasta);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.set(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=estadisticasIDiario.xls");
        headers.setContentLength(excelContent.length);

        return ResponseEntity.ok()
                .headers(headers)
                .body(excelContent);
    }

    @GetMapping("/excelIMensual")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> excelMensual (
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaHasta) throws IOException {
        byte[] excelContent = service.ingresosMensualesExcel(fechaDesde, fechaHasta);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.set(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=estadisticasIMensual.xls");
        headers.setContentLength(excelContent.length);

        return ResponseEntity.ok()
                .headers(headers)
                .body(excelContent);
    }

    @GetMapping("/excelGanancias")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> excelGanancias (
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaHasta) throws IOException {
        byte[] excelContent = service.gananciasNetasExcel(fechaDesde, fechaHasta);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.set(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=estadisticasGanancias.xls");
        headers.setContentLength(excelContent.length);

        return ResponseEntity.ok()
                .headers(headers)
                .body(excelContent);
    }

    @GetMapping("/excelPedidos")
    public ResponseEntity<?> excel (
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaHasta) throws IOException {
        byte[] excelContent = service.cantidadPedidosPorClienteExcel(fechaDesde, fechaHasta);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.set(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=estadisticasPedidos.xls");
        headers.setContentLength(excelContent.length);

        return ResponseEntity.ok()
                .headers(headers)
                .body(excelContent);
    }
}
