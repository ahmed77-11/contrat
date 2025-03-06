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
@Table(name = "xTypeEvent")
public class TypeEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "xTypeEventId", nullable = false)
    private Long id;

    @Column(name = "xTypeEventCode", unique = true, length = 8)
    private String code;

    @Column(name = "xTypeEventDsg", nullable = false, length = 64)
    private String dsg;

    @Column(name = "xTypeEventNbrJourOuvValeur", nullable = false)
    private Integer nbrJourOuvValeur;
    @Column(name="sysUserId", nullable = false)
    private Long sysUserId;

    @Column(name = "sysUser", nullable = false, length = 32)
    private String sysUser;

    @Column(name = "sysAction", nullable = false, length = 32)
    private String sysAction;

    @Column(name = "sysAdresseIp", nullable = false, length = 32)
    private String sysAdresseIp;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sysDate", nullable = false)
    private Date sysDate;
}
