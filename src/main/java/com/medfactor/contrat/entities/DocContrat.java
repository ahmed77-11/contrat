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
@Table(name = "DocContrat")
public class DocContrat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "yDocContratId", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "yContratIdFk", nullable = false)
    private Contrat contratId;  

    @ManyToOne
    @JoinColumn(name = "xTypeDocContratIdFk",nullable = false)
    private TypeDocContrat typeDocContrat;  

    @Column(name = "yDocContratNo", length = 20,nullable = false)
    private String docContratNo;

    @Column(name = "yDocContratDelivDate", length = 8)
    private String docContratDelivDate;

    @Column(name = "yDocContratExpireDate", length = 8)
    private String docContratExpireDate;

    @Column(name = "yDocContratScanPath", length = 255)
    private String docContratScanPath;

    @Column(name = "yDocContratScanFileName", length = 64)
    private String docContratScanFileName;

    @Column(name = "yDocContratApprobationDate", length = 8)
    private String docContratApprobationDate;

    @Column(name = "yDocContratEffetDate", length = 8)
    private String docContratEffetDate;

    @Column(name = "yDocContratRelanceDate", length = 8)
    private String docContratRelanceDate;


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
