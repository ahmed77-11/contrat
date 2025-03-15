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
@Table(name = "xTypeDocRemise")
public class TypeDocRemise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "xTypeDocRemiseId", nullable = false)
    private Long id;

    @Column(name = "xTypeDocRemiseCode", unique = true, nullable = false, length = 8)
    private String code;

    @Column(name = "xTypeDocRemiseDsg", nullable = false, length = 64)
    private String dsg;

    @Column(name = "xTypeDocRemiseBoolMaitre", nullable = false)
    private boolean boolMaitre;

    @Column(name = "xTypeDocRemiseBoolDetail", nullable = false)
    private boolean boolDetail;
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
