package com.example.TestApi.entity;

import com.example.TestApi.TestStatus;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Type;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="find")
public class PingEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ipOrDomen")
    public String ipOrDomen;

    @Column(name = "check_date")
    public String checkDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @NotNull
    public TestStatus status;

    @Column(name = "result")
    public String result;






}
