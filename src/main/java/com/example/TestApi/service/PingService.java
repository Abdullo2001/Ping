package com.example.TestApi.service;

import com.example.TestApi.dto.PingDto;
import com.example.TestApi.entity.PingEntity;
import com.example.TestApi.exceptions.PingEntityException;
import com.example.TestApi.exceptions.PingFailStatusException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PingService {

    void delete(Long id) throws PingEntityException;


    void add(PingDto dto) throws PingFailStatusException;

    List<PingDto> getPingIpOrDomen(String ipOrDomen);

    List<PingDto> getPingCheckDate(String checkDate);

    Page<PingEntity> getPingPagination(int offset, int pageSize);

    List<PingDto> getAllPing();
}
