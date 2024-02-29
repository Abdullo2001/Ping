package com.example.TestApi.entity;

import com.example.TestApi.TestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "ip")
    public String ipOrDomen;

    @Column(name = "check_date")
    public String checkDate;

    @Column(name = "status")
    public TestStatus status;

    @Column(name = "result")
    public String result;





}
