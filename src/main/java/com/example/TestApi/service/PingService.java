package com.example.TestApi.service;

import com.example.TestApi.dto.PingDto;
import com.example.TestApi.entity.PingEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PingService {

    void delete(Long id);

    void add(PingDto dto);

    List<PingDto> getPingIpOrDomen(String ipOrDomen);

    List<PingDto> getPingCheckDate(String checkDate);

    Page<PingEntity> getPingPagination(int offset, int pageSize);

    List<PingDto> getAllPing();
}
