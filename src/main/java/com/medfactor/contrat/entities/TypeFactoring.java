package com.medfactor.contrat.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "xTypeFactoring")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeFactoring {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "xTypeFactoringId")
    private Long id;

    @Column(name = "xTypeFactoringCode", length = 8,unique=true, nullable = false)
    private String code;

    @Column(name = "xTypeFactoringDsg", length = 64, nullable = false)
    private String dsg;

    @Column(name = "xTypeFactoringBoolRecours", nullable = false)
    private boolean boolExigeAssur;


    @Column(name="sysUserId", nullable = false)
    private Long sysUserId;
    @Column(name = "sysUser", length = 32, nullable = false)
    private String sysUser;

    @Column(name = "sysAction", length = 32, nullable = false)
    private String sysAction;

    @Column(name = "sysAdresseIp", length = 32, nullable = false)
    private String sysAdresseIp;


    @Column(name = "sysDate", nullable = false)
    private Date sysDate=new Date();




}
