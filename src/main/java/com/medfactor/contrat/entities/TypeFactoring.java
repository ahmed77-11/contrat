package com.medfactor.contrat.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "xTypeFactoring")
public class TypeFactoring {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "xTypeFactoringId")
    private Long id;

    @Column(name = "xTypeFactoringCode", length = 8, nullable = false)
    private String code;

    @Column(name = "xTypeFactoringDsg", length = 8, nullable = false)
    private String dsg;

    @Column(name = "xTypeFactoringBoolRecours", length = 1, nullable = false)
    private char boolExigeAssur;


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
