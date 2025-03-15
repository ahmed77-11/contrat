package com.medfactor.contrat.entities;

import com.medfactor.contrat.entities.Contrat;
import com.medfactor.contrat.entities.TypeDocContrat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="DocContrat" ,uniqueConstraints = @UniqueConstraint(columnNames = {"yContratIdFk","xTypeDocContratIdFk","yDocContratNo"}))
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

    @Column(name = "yDocContratDelivDate")
    private Date docContratDelivDate;

    @Column(name = "yDocContratExpireDate")
    private Date docContratExpireDate;

    @Column(name = "yDocContratScanPath", length = 255)
    private String docContratScanPath;

    @Column(name = "yDocContratScanFileName", length = 64)
    private String docContratScanFileName;

    @Column(name = "yDocContratApprobationDate")
    private Date docContratApprobationDate;

    @Column(name = "yDocContratEffetDate")
    private Date docContratEffetDate;

    @Column(name = "yDocContratRelanceDate")
    private Date docContratRelanceDate;


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
