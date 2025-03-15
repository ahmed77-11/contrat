package com.medfactor.contrat.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "xTypeComm")
public class TypeComm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "xTypeCommId", nullable = false)
    private Long id;

    @Column(name = "xTypeCommCode", unique = true,length = 8)
    private String code;

    @Column(name = "xTypeCommDsg", nullable = false, length = 64)
    private String dsg;

    @Column(name="sysUserId", nullable = false)
    private Long sysUserId;
    @Column(name = "sysUser", nullable = false, length = 32)
    private String sysUser;

    @Column(name = "sysAction", nullable = false, length = 32)
    private String sysAction;

    @Column(name = "sysAdresseIp", nullable = false, length = 32)
    private String sysAdresseIp;

    @Column(name = "sysDate", nullable = false)
    private Date sysDate=new Date();
}
