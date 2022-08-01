package sella.democsv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sella.democsv.config.ApplicationProperties;
import sella.democsv.servcie.CsvService;
import sella.democsv.servcie.impl.CsvServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoCsvApplication {
    private static CsvService csvService;
    private static ApplicationProperties applicationProperties;
    static {
        csvService = new CsvServiceImpl();
    }

    @Autowired
    public void setApplicationProperties(ApplicationProperties applicationProperties){
        DemoCsvApplication.applicationProperties = applicationProperties;
    }
    public static void main(String[] args) throws IOException {
        SpringApplication.run(DemoCsvApplication.class, args);
        args = new String[] {"/Users/arditmete/Desktop/temp.csv", "/Users/arditmete/Desktop/temp2.csv" };
        csvService.createPojoFromCsvHeader(args);
        csvService.createNewCsv(args);
    }
}
