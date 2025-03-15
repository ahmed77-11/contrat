package com.medfactor.contrat.utils;

import com.medfactor.contrat.entities.*;
import com.medfactor.contrat.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private TypeFactoringRepository typeFactoringRepository;

    @Autowired
    private TypeEventRepository typeEventRepository;

    @Autowired
    private TypeDocRemiseRepository typeDocRemiseRepository;

    @Autowired
    private TypeDocContratRepository typeDocContratRepository;

    @Autowired
    private TypeCommRepository typeCommRepository;

    @Autowired
    private DeviseRepository deviseRepository;

    @Autowired
    private StatutTypeEventRepository statutTypeEventRepository;

    @Autowired
    private StatutDocRemiseRepository statutDocRemiseRepository;

    @Autowired
    private StatutContratRepository statutContratRepository;

    @Override
    public void run(String... args) throws Exception {
        // Insert TypeFactoring
//        TypeFactoring typeFactoring = new TypeFactoring();
//        typeFactoring.setCode("TF123");
//        typeFactoring.setDsg("Factoring");
//        typeFactoring.setBoolExigeAssur(true);
//        typeFactoring.setSysUserId(1L);
//        typeFactoring.setSysUser("admin");
//        typeFactoring.setSysAction("CREATE");
//        typeFactoring.setSysAdresseIp("127.0.0.1");
//        typeFactoring.setSysDate(new Date());
//        typeFactoringRepository.save(typeFactoring);
//
//        // Insert TypeEvent
//        TypeEvent typeEvent = new TypeEvent();
//        typeEvent.setCode("EV001");
//        typeEvent.setDsg("Event Desc");
//        typeEvent.setNbrJourOuvValeur(5);
//        typeEvent.setSysUserId(1L);
//        typeEvent.setSysUser("admin");
//        typeEvent.setSysAction("CREATE");
//        typeEvent.setSysAdresseIp("127.0.0.1");
//        typeEvent.setSysDate(new Date());
//        typeEventRepository.save(typeEvent);
//
//        // Insert TypeDocRemise
//        TypeDocRemise typeDocRemise = new TypeDocRemise();
//        typeDocRemise.setCode("DR001");
//        typeDocRemise.setDsg("Doc Remise");
//        typeDocRemise.setBoolMaitre(true);
//        typeDocRemise.setBoolDetail(false);
//        typeDocRemise.setSysUserId(1L);
//        typeDocRemise.setSysUser("admin");
//        typeDocRemise.setSysAction("CREATE");
//        typeDocRemise.setSysAdresseIp("127.0.0.1");
//        typeDocRemise.setSysDate(new Date());
//        typeDocRemiseRepository.save(typeDocRemise);
//
//        // Insert TypeDocContrat
//        TypeDocContrat typeDocContrat = new TypeDocContrat();
//        typeDocContrat.setCode("DC001");
//        typeDocContrat.setDsg("Doc Contrat");
//        typeDocContrat.setDelaiRelance(10);
//        typeDocContrat.setSysUserId(1L);
//        typeDocContrat.setSysUser("admin");
//        typeDocContrat.setSysAction("CREATE");
//        typeDocContrat.setSysAdresseIp("127.0.0.1");
//        typeDocContrat.setSysDate(new Date());
//        typeDocContratRepository.save(typeDocContrat);
//
//        // Insert TypeComm
//        TypeComm typeComm = new TypeComm();
//        typeComm.setCode("TC001");
//        typeComm.setDsg("Type Comm");
//        typeComm.setSysUserId(1L);
//        typeComm.setSysUser("admin");
//        typeComm.setSysAction("CREATE");
//        typeComm.setSysAdresseIp("127.0.0.1");
//        typeComm.setSysDate(new Date());
//        typeCommRepository.save(typeComm);
//
//        // Insert Devise
//        Devise devise = new Devise();
//        devise.setCodeNum("840");
//        devise.setCodeAlpha("USD");
//        devise.setDsg("US Dollar");
//        devise.setSysUserId(1L);
//        devise.setSysUser("admin");
//        devise.setSysAction("CREATE");
//        devise.setSysAdresseIp("127.0.0.1");
//        devise.setSysDate(new Date());
//        deviseRepository.save(devise);
//
//        // Insert StatutTypeEvent
//        StatutTypeEvent statutTypeEvent = new StatutTypeEvent();
//        statutTypeEvent.setCode("SE001");
//        statutTypeEvent.setDsg("Statut Event");
//        statutTypeEvent.setSysUserId(1L);
//        statutTypeEvent.setSysUser("admin");
//        statutTypeEvent.setSysAction("CREATE");
//        statutTypeEvent.setSysAdresseIp("127.0.0.1");
//        statutTypeEvent.setSysDate(new Date());
//        statutTypeEventRepository.save(statutTypeEvent);
//
//        // Insert StatutDocRemise
//        StatutDocRemise statutDocRemise = new StatutDocRemise();
//        statutDocRemise.setCode("SR001");
//        statutDocRemise.setDsg("Statut Doc Remise");
//        statutDocRemise.setSysUserId(1L);
//        statutDocRemise.setSysUser("admin");
//        statutDocRemise.setSysAction("CREATE");
//        statutDocRemise.setSysAdresseIp("127.0.0.1");
//        statutDocRemise.setSysDate(new Date());
//        statutDocRemiseRepository.save(statutDocRemise);
//
//        // Insert StatutContrat
//        StatutContrat statutContrat = new StatutContrat();
//        statutContrat.setCodeContrat("SC001");
//        statutContrat.setDesignation("Statut Contrat");
//        statutContrat.setSysUserId(1L);
//        statutContrat.setSysUser("admin");
//        statutContrat.setSysAction("CREATE");
//        statutContrat.setSysAdresseIp("127.0.0.1");
//        statutContrat.setSysDate(new Date());
//        statutContratRepository.save(statutContrat);
    }
}
