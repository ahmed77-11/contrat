package com.medfactor.contrat.entities;

import com.medfactor.contrat.entities.Contrat;
import com.medfactor.contrat.entities.TypeComm;
import com.medfactor.contrat.entities.TypeDocRemise;
import com.medfactor.contrat.entities.TypeEvent;
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
        name = "yComm",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"yContratIdFk"}),
                @UniqueConstraint(columnNames = {"xTypeEventIdFk"}),
                @UniqueConstraint(columnNames = {"xTypeDocRemiseIdFk"}),
                @UniqueConstraint(columnNames = {"xTypeCommIdFk"})
        }
)
public class Commission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "yCommId", nullable = false)
    private Long commId;

    @ManyToOne
    @JoinColumn(name = "yContratIdFk", nullable = true)
    private Contrat contrat;

    @ManyToOne
    @JoinColumn(name = "xTypeEventIdFk", referencedColumnName = "xTypeEventId", nullable = true)
    private TypeEvent typeEvent;

    @ManyToOne
    @JoinColumn(name = "xTypeDocRemiseIdFk", referencedColumnName = "xTypeDocRemiseId", nullable = true)
    private TypeDocRemise typeDocRemise;

    @ManyToOne
    @JoinColumn(name = "xTypeCommIdFk", referencedColumnName = "xTypeCommId", nullable = true)
    private TypeComm typeComm;

    @Column(name = "yCommPeriodicite", nullable = true)
    private Integer periodicite;

    @Column(name = "yCommMinB", precision = 19, scale = 0, nullable = true)
    private BigDecimal commMinorant;

    @Column(name = "yCommA", precision = 7, scale = 5, nullable = true)
    private BigDecimal commA;

    @Column(name = "yCommX", precision = 19, scale = 0, nullable = true)
    private BigDecimal commX;

    @Column(name = "yCommB", precision = 19, scale = 0, nullable = true)
    private BigDecimal commB;

    @Column(name = "yCommMaxB", precision = 19, scale = 0, nullable = true)
    private BigDecimal commMajorant;

    @Column(name = "yCommValidDateDeb", length = 8, nullable = true)
    private Date validDateDeb;

    @Column(name = "yCommValidDateFin", length = 8, nullable = true)
    private Date validDateFin;

    @Column(name="sysUserId", nullable = true)
    private Long sysUserId;

    @Column(name = "sysUser", length = 32, nullable = true)
    private String sysUser;

    @Column(name = "sysAction", length = 32, nullable = true)
    private String sysAction;

    @Column(name = "sysAdresseIp", length = 32, nullable = true)
    private String sysAdresseIp;

    @Column(name = "sysDate", nullable = true)
    private Date sysDate=new Date();
}
