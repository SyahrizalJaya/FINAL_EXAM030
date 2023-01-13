/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FInal_Exam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@CrossOrigin
public class ExamController {
    Surat data = new Surat();
    SuratJpaController control = new SuratJpaController();
    
    @GetMapping(value="/GET", produces = APPLICATION_JSON_VALUE)
    public List<Surat> getNama(){
        List<Surat> buffer = new ArrayList<>();
        buffer = control.findSuratEntities();
        return buffer;
    }

    @PostMapping(value = "/POST", consumes = APPLICATION_JSON_VALUE)
    public String sendData(HttpEntity<String> datasend) throws JsonProcessingException{
        ObjectMapper export = new ObjectMapper();
        String feedback = "Data";
        data = export.readValue(datasend.getBody(), Surat.class);
        try {
            control.create(data);
            feedback = data.getJudul()+ " saved";
        } catch (Exception error) {
            feedback = error.getMessage();
        }
        return feedback;
    }
    
    @PutMapping(value = "/PUT", consumes = APPLICATION_JSON_VALUE)
    public String putData(HttpEntity<String> datasend) throws JsonProcessingException{
        ObjectMapper export = new ObjectMapper();
        String feedback = "Data";
        data = export.readValue(datasend.getBody(), Surat.class);
        try {
            control.edit(data);
            feedback = data.getJudul()+ " edited";
        } catch (Exception error) {
            feedback = error.getMessage();
        }
        return feedback;
    }
    
    @DeleteMapping(value = "/Delete", consumes = APPLICATION_JSON_VALUE)
    public String deleteData(HttpEntity<String> datasend) throws JsonProcessingException{
        ObjectMapper export = new ObjectMapper();
        String feedback = "Data";
        data = export.readValue(datasend.getBody(), Surat.class);
        try {
            control.destroy(data.getId());
            feedback = data.getJudul()+ " deleted";
        } catch (Exception error) {
            feedback = error.getMessage();
        }
        return feedback;
    }
}
