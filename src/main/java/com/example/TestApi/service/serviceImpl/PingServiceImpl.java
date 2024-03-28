package com.example.TestApi.service.serviceImpl;


import com.example.TestApi.TestStatus;
import com.example.TestApi.dto.PingDto;
import com.example.TestApi.entity.PingEntity;
import com.example.TestApi.exceptions.PingEntityException;
import com.example.TestApi.exceptions.PingFailStatusException;
import com.example.TestApi.repository.PingRepository;
import com.example.TestApi.service.PingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PingServiceImpl implements PingService {


    private final PingRepository repository;

    @Override
    public void delete(Long id) throws PingEntityException {
        Optional<PingEntity> entity = repository.findById(id);
        if(entity.isEmpty()){
            throw new PingEntityException("No such ping with the id: "+id);
        }
        repository.delete(entity.get());
    }


    @Override
    public void add(PingDto dto) throws PingFailStatusException {

            PingEntity entity = new PingEntity();
            entity.setCheckDate(dto.checkDate);
            entity.setIpOrDomen(dto.ipOrDomen);
            entity.setResult(dto.result);
            if (checkStatus(dto.getStatus().toString())){
                entity.setStatus(dto.getStatus());
            }else{
                throw new PingFailStatusException("status not  found!");
            }
            
            repository.save(entity);


    }

    private boolean checkStatus(String status) {
        for (TestStatus status1:TestStatus.values()) {
            if(status1.name().equals(status)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<PingDto> getPingIpOrDomen(String ipOrDomen) {
        List<PingEntity> entities = repository.findAll();
        List<PingDto> dtos = new ArrayList<>();

        for (PingEntity entity : entities) {
            if (ipOrDomen.equals(entity.ipOrDomen)) {
                PingDto dto = new PingDto();
                dto.setId(entity.getId());
                dto.setIpOrDomen(entity.ipOrDomen);
                dto.setCheckDate(entity.checkDate);
                dto.setResult(entity.result);
                dto.setStatus(entity.status);
                dtos.add(dto);
            }
        }
        return dtos;


    }

    @Override
    public List<PingDto> getPingCheckDate(String checkDate){
        List<PingEntity> entities = repository.findAll();
        List<PingDto> dtos = new ArrayList<>();

        for(PingEntity entity:entities){
            if(checkDate.equals(entity.checkDate)){
                PingDto dto = new PingDto();
                dto.setId(entity.getId());
                dto.setIpOrDomen(entity.ipOrDomen);
                dto.setCheckDate(entity.checkDate);
                dto.setResult(entity.result);
                dto.setStatus(entity.status);
                dtos.add(dto);
            }
        }
        return dtos;
    }

    @Override
    public Page<PingEntity> getPingPagination(int offset, int pageSize) {
        Page<PingEntity> entities= repository.findAll(PageRequest.of(offset,pageSize));
        return entities;
    }

    @Override
    public List<PingDto> getAllPing() {
        List<PingEntity> entities = repository.findAll();

        return convertEntityToDto(entities);
    }

    public List<PingDto> convertEntityToDto(List<PingEntity> entities){
        List<PingDto> dtos = new ArrayList<>();
        for(PingEntity entity:entities){
            PingDto dto = new PingDto();
            dto.setId(entity.getId());
            dto.setIpOrDomen(entity.ipOrDomen);
            dto.setCheckDate(entity.checkDate);
            dto.setResult(entity.result);
            dto.setStatus(entity.status);
            dtos.add(dto);
        }
        return dtos;
    }
}
