package com.example.TestApi.dto;

import com.example.TestApi.TestStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PingDto {

    public Long id;

    @NotBlank
    public String ipOrDomen;

    public String checkDate;

    public Set<TestStatus> status;

    public String result;


}
