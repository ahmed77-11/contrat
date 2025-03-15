package com.medfactor.contrat.service;

import com.medfactor.contrat.dtos.ContratDTO;
import com.medfactor.contrat.utils.Converter;
import com.medfactor.contrat.utils.IpLoggingFilter;
import com.medfactor.contrat.utils.PathUtil;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.spin.Spin;
import org.camunda.spin.json.SpinJsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("generatePDFDelegate")
public class GeneratePdfService implements JavaDelegate {

    @Autowired
    private Converter converter;



    private static final Logger logger = LoggerFactory.getLogger(GeneratePdfService.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Object contratObj = execution.getVariable("contractData");
        ContratDTO contratDTO;

        if (contratObj instanceof String) {
            // Deserialize JSON to Java Object
            SpinJsonNode jsonNode = Spin.JSON((String) contratObj);
            contratDTO = jsonNode.mapTo(ContratDTO.class);
        } else if (contratObj instanceof ContratDTO) {
            contratDTO = (ContratDTO) contratObj;
        } else {
            throw new IllegalArgumentException("contractData is not of type ContratDTO");
        }

        logger.info("Generating PDF for contract: {}", contratDTO.getContratNo());

        // Call the generatePdf method and capture the file path.
        String pdfFilePath = converter.generatePdf(contratDTO);
        if (pdfFilePath != null) {
            // Save the file path in a process variable for later use.
            execution.setVariable("pdfFilePath", PathUtil.splitPdfFilePath(pdfFilePath));
            logger.info("PDF file path saved in process variables: {}", pdfFilePath);

        } else {
            logger.error("PDF generation failed; no file path to store in process variables.");
        }
    }
}
