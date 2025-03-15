package com.medfactor.contrat.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "StatutContrat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatutContrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "xStatutContratIdFk")
    private Long StatutContratId;

    @Column(name = "xStatutContratCode", length = 8, nullable = false,unique=true)
    private String codeContrat;

    @Column(name = "xStatutContratDsg", length = 64, nullable = false)
    private String designation;
    @Column(name="sysUserId", nullable = false)
    private Long sysUserId;
    @Column(name = "sysUser", length = 32, nullable = false)
    private String sysUser;

    @Column(name = "sysAction", length = 32, nullable = false)
    private String sysAction;

    @Column(name = "sysAdresseIp", length = 32, nullable = false)
    private String sysAdresseIp;

    @Column(name = "sysDate", nullable = false)
    private java.util.Date sysDate=new Date();
}