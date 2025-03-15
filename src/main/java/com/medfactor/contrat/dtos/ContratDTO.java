package com.medfactor.contrat.dtos;

import com.medfactor.contrat.entities.Commission;
import com.medfactor.contrat.entities.ContratFonds;
import com.medfactor.contrat.entities.Devise;
import com.medfactor.contrat.entities.TypeFactoring;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContratDTO {
    private Long id;
    private Long statusContrat;
    private String contratNo;
    private Long adhrent;
    private String contratOldNo;
    private TypeFactoring typeFactoring;
    private boolean contratBoolRecours;
    private String contratComiteRisqueTexte;
    private String contratComiteDerogTexte;
    private BigDecimal contratPrevChiffreTotal;
    private BigDecimal contratPrevChiffreLocal;
    private BigDecimal contratPrevChiffreExport;
    private int contratPrevAchet;
    private int contratPrevNbrRemise;
    private int contratPrevNbrDocRemise;
    private int contratPrevNbrAvoir;
    private BigDecimal contratTauxConcentration;
    private int contratDelaiMaxPai;
    private boolean contratBoolLettrage;
    private BigDecimal contratLimiteFinAuto;
    private Devise devise;
    private Long tmm;
    private BigDecimal contratTmm;
    private BigDecimal contratMargeFin;
    private BigDecimal contratMargeRet;
    private Date contratAcceptRemiseDate;
    private String contratResiliationTexte;
    private Date contratResiliationDate;
    private Date contratRevisionDate;
    private List<ContratFonds> contratFonds;
    private List<Commission> commissions;
    private Long sysUserId;
    private String sysUser;
    private String sysAction;
    private String sysAdresseIp;

    public List<ContratFonds> getContratFonds() {
        return contratFonds;
    }
    public List<Commission> getCommissions() {
        return commissions;
    }
}
