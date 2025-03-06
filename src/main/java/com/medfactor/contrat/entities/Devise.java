package com.medfactor.contrat.entities;


import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "xDevise")
public class Devise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "xDeviseId")
    private Long id;

    @Column(name = "xDeviseCodeNum", length = 8, nullable = false)
    private String codeNum;

    @Column(name = "xDeviseCodeAlpha", length = 8, nullable = false)
    private String codeAlpha;

    @Column(name = "xDeviseDsg", length = 64, nullable = false)
    private String dsg;

    @Column(name="sysUserId", nullable = false)
    private Long sysUserId;

    @Column(name = "sysUser", length = 32, nullable = false)
    private String sysUser;

    @Column(name = "sysAction", length = 32, nullable = false)
    private String sysAction;

    @Column(name = "sysAdresseIp", length = 32, nullable = false)
    private String sysAdresseIp;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sysDate", nullable = false)
    private Date sysDate;



}
