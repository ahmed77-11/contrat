package com.medfactor.contrat.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "yComm")
public class Commission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "yCommId", nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "yContratIdFk", nullable = false)
    private Contrat contrat;

    @ManyToOne
    @JoinColumn(name = "xTypeEventIdFk", referencedColumnName = "xTypeEventId", nullable = false)
    private TypeEvent typeEvent;

    @ManyToOne
    @JoinColumn(name = "xTypeDocRemiseIdFk", referencedColumnName = "xTypeDocRemiseId", nullable = false)
    private TypeDocRemise typeDocRemise;

    @ManyToOne
    @JoinColumn(name = "xTypeCommIdFk", referencedColumnName = "xTypeCommId", nullable = false)
    private TypeComm typeComm;

    @Column(name = "yCommPeriodicite", precision = 2)
    private Integer periodicite;

    @Column(name = "yCommMinB", precision = 19, scale = 0)
    private BigDecimal commMinorant;

    @Column(name = "yCommA", precision = 7, scale = 5)
    private BigDecimal commA;

    @Column(name = "yCommX", precision = 19, scale = 0)
    private BigDecimal commX;

    @Column(name = "yCommB", precision = 19, scale = 0)
    private BigDecimal commB;

    @Column(name = "yCommMaxB", precision = 19, scale = 0)
    private BigDecimal commMajorant;

    @Column(name = "yCommValidDateDeb", length = 8)
    private String validDateDeb;

    @Column(name = "yCommValidDateFin", length = 8)
    private String validDateFin;

    @Column(name="sysUserId", nullable = false)
    private Long sysUserId;

    @Column(name = "sysUser", length = 32)
    private String sysUser;

    @Column(name = "sysAction", length = 32)
    private String sysAction;

    @Column(name = "sysAdresseIp", length = 32)
    private String sysAdresseIp;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sysDate", nullable = false)
    private Date sysDate;
}
