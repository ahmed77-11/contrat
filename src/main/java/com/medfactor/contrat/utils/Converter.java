package com.medfactor.contrat.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medfactor.contrat.dtos.ContratDTO;
import com.medfactor.contrat.entities.Contrat;
import com.medfactor.contrat.repos.ContratRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Component
public class Converter {

    private static final Logger logger = LoggerFactory.getLogger(Converter.class);

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private ContratRepository contratRepository;

    public ContratDTO convertJsonToContractData(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ContratDTO.class);
    }

    public String generatePdf(ContratDTO contratDTO) {
        try {
            // ✅ Ensure the PDF directory exists
            String pdfDirectory = new File("src/main/resources/static/Contract_PDF/").getAbsolutePath();
            Path path = Paths.get(pdfDirectory);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            // ✅ Fix file path formatting (cross-platform)
            String pdfFileName = "contract_" + contratDTO.getContratNo() + ".pdf";
            String pdfFilePath = pdfDirectory + File.separator + pdfFileName;

            // ✅ Update contract entity with PDF file details
            Contrat contrat = contratRepository.findByContratNo(contratDTO.getContratNo())
                    .orElseThrow(() -> new RuntimeException("Contract not found"));
            contrat.setContratScanPath(pdfFilePath);
            contrat.setContratScanFileName(pdfFileName);
            contratRepository.save(contrat);

            // ✅ Generate HTML content using Thymeleaf
            Context context = new Context();
            context.setVariable("contractData", contratDTO);
            String htmlContent = renderTemplate(context);

            // ✅ Convert HTML to PDF
            ITextRenderer renderer = new ITextRenderer();
            // Set base URL to resolve static files (CSS, images)
            String baseUrl = new File("src/main/resources/static/").toURI().toString();
            renderer.setDocumentFromString(htmlContent, baseUrl);
            renderer.layout();

            // ✅ Write PDF to the filesystem
            try (FileOutputStream os = new FileOutputStream(pdfFilePath)) {
                renderer.createPDF(os);
            }

            File pdfFile = new File(pdfFilePath);
            if (pdfFile.exists()) {
                logger.info("✅ PDF successfully generated: " + pdfFilePath);
                return pdfFilePath;
            } else {
                logger.error("⚠️ Error: PDF file was not created!");
                return null;
            }
        } catch (Exception e) {
            logger.error("Error generating PDF", e);
            return null;
        }
    }

    private String renderTemplate(Context context) {
        return templateEngine.process("contratTemplate", context);
    }
}
