package com.example.TestApi.dto;

import com.example.TestApi.TestStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PingDto {

    public Long id;

    public String ipOrDomen;

    public String checkDate;

    public TestStatus status;

    public String result;
}
