package com.medfactor.contrat.entities;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Contrat", uniqueConstraints = {@UniqueConstraint(columnNames = "yContratNo")})
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "yContratId", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "xStatutContratIdFk", nullable = false)
    private StatutContrat statutContrat;

    @Column(name = "yContratNo", length = 16, unique = true)
    private String contratNo;

    @Column(name = "yAdherPmIdFk")
    private Long adherPmIdFk;

    @Column(name = "yContratOldNo", length = 10)
    private String contratOldNo;

    @ManyToOne
    @JoinColumn(name = "xTypeFactoringIdFk")
    private TypeFactoring typeFactoring;

    @Column(name = "yContratBoolRecours", length = 1)
    private String contratBoolRecours;

    @Column(name = "yContratComiteRisqueTexte", length = 64)
    private String contratComiteRisqueTexte;

    @Column(name = "yContratComiteDerogTexte", length = 64)
    private String contratComiteDerogTexte;

    @Column(name = "yContratPrevChiffreTotal", precision = 19, scale = 0)
    private BigDecimal contratPrevChiffreTotal;

    @Column(name = "yContratPrevChiffreLocal", precision = 19, scale = 0)
    private BigDecimal contratPrevChiffreLocal;

    @Column(name = "yContratPrevChiffreExport", precision = 19, scale = 0)
    private BigDecimal contratPrevChiffreExport;

    @Column(name = "yContratPrevNbrAchet")
    private Integer contratPrevNbrAchet;

    @Column(name = "yContratPrevNbrRemise")
    private Integer contratPrevNbrRemise;

    @Column(name = "yContratPrevNbrDocRemise")
    private Integer contratPrevNbrDocRemise;

    @Column(name = "yContratPrevNbrAvoir")
    private Integer contratPrevNbrAvoir;

    @Column(name = "yContratTauxConcentration", precision = 7, scale = 5)
    private BigDecimal contratTauxConcentration;

    @Column(name = "yContratDelaiMaxPai")
    private Integer contratDelaiMaxPai;

    @Column(name = "yContratBoolLettrage", length = 1)
    private String contratBoolLettrage;

    @Column(name = "yContratLimiteFinAuto", precision = 19, scale = 0)
    private BigDecimal contratLimiteFinAuto;

    @ManyToOne
    @JoinColumn(name = "xDeviseIdFk")
    private Devise devise;

    @Column(name = "yContratTmm", precision = 7, scale = 5)
    private BigDecimal contratTmm;

    @Column(name = "yContratMargeFin", precision = 7, scale = 5)
    private BigDecimal contratMargeFin;

    @Column(name = "yContratMargeRet", precision = 7, scale = 5)
    private BigDecimal contratMargeRet;

    @Column(name = "yContratScanPath", length = 255)
    private String contratScanPath;

    @Column(name = "yContratScanFileName", length = 64)
    private String contratScanFileName;

    @Column(name = "yContratAcceptRemiseDate", length = 8)
    private String contratAcceptRemiseDate;

    @Column(name = "yContratResiliationTexte", length = 64)
    private String contratResiliationTexte;

    @Column(name = "yContratResiliationDate", length = 8)
    private String contratResiliationDate;

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