package com.example.TestApi.service.serviceImpl;

import com.example.TestApi.TestStatus;
import com.example.TestApi.dto.PingDto;
import com.example.TestApi.exceptions.PingEntityException;
import com.example.TestApi.exceptions.PingFailStatusException;
import org.junit.jupiter.api.Test;

class PingServiceImplTest {

    private final PingServiceImpl service;

    PingServiceImplTest(PingServiceImpl service) {
        this.service = service;
    }

    @Test
    void delete() throws PingEntityException {
        service.delete(1L);
    }

    @Test
    void add() throws PingFailStatusException {
        PingDto dto=new PingDto();
        dto.setIpOrDomen("www.com");
        dto.setCheckDate("08.08.2024");
        dto.setStatus(TestStatus.FINISHED);
        dto.setResult("ok");
        service.add(dto);
    }

    @Test
    void getPingIpOrDomen() {

    }

    @Test
    void getPingCheckDate() {
    }

    @Test
    void getPingPagination() {
    }

    @Test
    void getAllPing() {
    }
}