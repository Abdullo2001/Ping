package com.example.TestApi.controller;


import com.example.TestApi.dto.PingDto;
import com.example.TestApi.entity.PingEntity;
import com.example.TestApi.service.PingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ping")
@RequiredArgsConstructor
public class PingController {
    private final PingService service;

    @GetMapping("/check/")
    public List<PingDto> getPingCheckDate(@RequestBody PingDto dto) {
        return service.getPingCheckDate(dto.checkDate);
    }

    @GetMapping("/{ipOrDomen}")
    public List<PingDto> getPingIpOrDomen(@PathVariable String ipOrDomen) {
        return service.getPingIpOrDomen(ipOrDomen);
    }

    @GetMapping
    public List<PingDto> getAllPing() {
        return service.getAllPing();
    }

    @PostMapping
    public void addPing(@RequestBody PingDto dto){
        service.add(dto);
    }


    @DeleteMapping("/id")
    public void deletePing(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<PingEntity> getPingWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<PingEntity> pingWithPagination = service.getPingPagination(offset,pageSize);
        return pingWithPagination;
    }
}
