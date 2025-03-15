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
@Table(
        name = "Contrat",
        uniqueConstraints = {@UniqueConstraint(columnNames = "yContratNo")}
)
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "yContratId", nullable = false)
    private Long id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "xStatutContratIdFk", nullable = true)
    private StatutContrat statutContrat;

    @Column(name = "yContratNo", length = 16, nullable = true)
    private String contratNo;

    @Column(name = "yAdherPmIdFk", nullable = true)
    private Long adherent;

    @Column(name = "yContratOldNo", length = 10, nullable = true)
    private String contratOldNo;

    @ManyToOne(optional = true)
    @JoinColumn(name = "xTypeFactoringIdFk", nullable = true)
    private TypeFactoring typeFactoring;

    // Use Boolean (object) instead of boolean so it can be null.
    @Column(name = "yContratBoolRecours", nullable = true)
    private boolean contratBoolRecours;

    @Column(name = "yContratComiteRisqueTexte", length = 64, nullable = true)
    private String contratComiteRisqueTexte;

    @Column(name = "yContratComiteDerogTexte", length = 64, nullable = true)
    private String contratComiteDerogTexte;

    @Column(name = "yContratPrevChiffreTotal", precision = 19, scale = 0, nullable = true)
    private BigDecimal contratPrevChiffreTotal;

    @Column(name = "yContratPrevChiffreLocal", precision = 19, scale = 0, nullable = true)
    private BigDecimal contratPrevChiffreLocal;

    @Column(name = "yContratPrevChiffreExport", precision = 19, scale = 0, nullable = true)
    private BigDecimal contratPrevChiffreExport;

    @Column(name = "yContratPrevNbrAchet", nullable = true)
    private Integer contratPrevNbrAchet;

    @Column(name = "yContratPrevNbrRemise", nullable = true)
    private Integer contratPrevNbrRemise;

    @Column(name = "yContratPrevNbrDocRemise", nullable = true)
    private Integer contratPrevNbrDocRemise;

    @Column(name = "yContratPrevNbrAvoir", nullable = true)
    private Integer contratPrevNbrAvoir;

    @Column(name = "yContratTauxConcentration", precision = 7, scale = 5, nullable = true)
    private BigDecimal contratTauxConcentration;

    @Column(name = "yContratDelaiMaxPai", nullable = true)
    private Integer contratDelaiMaxPai;

    @Column(name = "yContratBoolLettrage", nullable = true)
    private Boolean contratBoolLettrage;

    @Column(name = "yContratLimiteFinAuto", precision = 19, scale = 0, nullable = true)
    private BigDecimal contratLimiteFinAuto;

    @ManyToOne(optional = true)
    @JoinColumn(name = "xDeviseIdFk", nullable = true)
    private Devise devise;

    @Column(name = "yTmmIdFk", nullable = true)
    private Long tmm;

    @Column(name = "yContratTmm", precision = 7, scale = 5, nullable = true)
    private BigDecimal contratTmm;

    @Column(name = "yContratMargeFin", precision = 7, scale = 5, nullable = true)
    private BigDecimal contratMargeFin;

    @Column(name = "yContratMargeRet", precision = 7, scale = 5, nullable = true)
    private BigDecimal contratMargeRet;

    @Column(name = "yContratScanPath", length = 255, nullable = true)
    private String contratScanPath;

    @Column(name = "yContratScanFileName", length = 64, nullable = true)
    private String contratScanFileName;

    @Column(name = "yContratAcceptRemiseDate", nullable = true)
    private Date contratAcceptRemiseDate;

    @Column(name = "yContratResiliationTexte", length = 64, nullable = true)
    private String contratResiliationTexte;

    @Column(name = "yContratResiliationDate", nullable = true)
    private Date contratResiliationDate;

    @Column(name = "yContratEtape1RedacteurDate", nullable = true)
    private Date contratEtape1RedacteurDate;

    @Column(name = "yContratEtape1RedacteurNom", length = 64, nullable = true)
    private String contratEtape1RedacteurNom;

    @Column(name = "yContratEtape2ValidateurDate", nullable = true)
    private Date contratEtape2ValidateurDate;

    @Column(name = "yContratEtape2ValidateurNom", length = 64, nullable = true)
    private String contratEtape2ValidateurNom;

    @Column(name = "yContratEtape3JuristeDate", nullable = true)
    private Date contratEtape3JuristeDate;

    @Column(name = "yContratEtape3JuristeNom", length = 64, nullable = true)
    private String contratEtape3JuristeNom;

    @Column(name = "yContratEtape4SignataireDate", nullable = true)
    private Date contratEtape4SignataireDate;

    @Column(name = "yContratEtape4SignataireNom", length = 64, nullable = true)
    private String contratEtape4SignataireNom;

    @Column(name = "yContratEtape5CautionPpIdFk", nullable = true)
    private Long cautionPp;

    @Column(name = "yContratEtape5CautionPmIdFk", nullable = true)
    private Long cautionPm;

    @Column(name = "yContratEtape5CautionNom", length = 64, nullable = true)
    private String contratEtape5CautionNom;

    @Column(name = "yContratEtape5CautionTypeCode", length = 8, nullable = true)
    private String contratEtape5CautionTypeCode;

    @Column(name = "yContratEtape5CautionTypeNo", length = 20, nullable = true)
    private String contratEtape5CautionTypeNo;

    @Column(name = "yContratEtape5CautionMontant", precision = 19, scale = 0, nullable = true)
    private BigDecimal contratEtape5CautionMontant;

    @Column(name = "yContratRevisionDate", nullable = true)
    private Date contratRevisionDate;

    @Column(name = "yContratValider", nullable = true)
    private Boolean contratValider=false;
    @Column(name = "yContratSigner", nullable = true)
    private Boolean contratSigner=false;

    @Column(name="sysUserId", nullable = false)
    private Long sysUserId;

    @Column(name = "sysUser", length = 32, nullable = true)
    private String sysUser;

    @Column(name = "sysAction", length = 32, nullable = true)
    private String sysAction;

    @Column(name = "sysAdresseIp", length = 32, nullable = true)
    private String sysAdresseIp;

    @Column(name = "sysDate", nullable = false)
    private Date sysDate = new Date();
}
