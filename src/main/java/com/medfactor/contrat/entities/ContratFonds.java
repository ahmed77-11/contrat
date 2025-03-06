package com.medfactor.contrat.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ContratFonds")
public class ContratFonds {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name = "yContratFondsId", nullable = false)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "yContratIdFk", nullable = false)
    private Contrat contratId;
    
    @ManyToOne
    @JoinColumn(name = "xTypeDocRemiseIdFk", nullable = false)
    private TypeDocRemise typeDocRemiseId;
    
    
    @Column(name = "yContratFondsGarantieTaux", precision = 7, scale = 5)
    private BigDecimal garantieTaux;

    @Column(name = "yContratFondsReserveTaux", precision = 7, scale = 5)
    private BigDecimal reserveTaux;


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
