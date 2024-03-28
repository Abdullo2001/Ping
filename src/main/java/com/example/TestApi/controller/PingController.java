package com.example.TestApi.controller;


import com.example.TestApi.dto.PingDto;
import com.example.TestApi.entity.PingEntity;
import com.example.TestApi.exceptions.PingEntityException;
import com.example.TestApi.exceptions.PingFailStatusException;
import com.example.TestApi.service.PingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ping")
@RequiredArgsConstructor


public class PingController {



    private final PingService service;

    @Operation(summary = "Ping data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PingDto.class))))
    })
    @GetMapping("/check")
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
    public void addPing( @RequestBody PingDto dto) throws  PingFailStatusException {
            service.add(dto);


    }



    @DeleteMapping("/delete/{id}")
    public void deletePing(@PathVariable Long id) throws PingEntityException {
        service.delete(id);
    }


    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<PingEntity> getPingWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<PingEntity> pingWithPagination = service.getPingPagination(offset,pageSize);
        return pingWithPagination;
    }
}
