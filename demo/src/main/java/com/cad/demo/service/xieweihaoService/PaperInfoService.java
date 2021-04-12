package com.cad.demo.service.xieweihaoService;

import com.cad.demo.xieweihaoPojo.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaperInfoService {
    public List<PaperInfo>getPaperInfo(ReferenceService referenceService) {
        List<PaperInfo> res = new ArrayList<PaperInfo>();
        List<Reference> references = referenceService.getReferenceListAll();
        for(Reference reference: references) {
            PaperInfo paperInfo = new PaperInfo();
            paperInfo.set_id(reference.get_id());
            paperInfo.setAuthor(reference.getAuthor());
            paperInfo.setDate(reference.getDate());
            paperInfo.setTitle(reference.getTitle());
            paperInfo.setIs_marked(reference.getIs_marked());
            res.add(paperInfo);
        }
        return res;
    }

    public List<PaperInfo>getBookInfo(ReferenceService referenceService) {
        List<PaperInfo> res = new ArrayList<PaperInfo>();
        List<Book> references = referenceService.getBookListAll();
        for(Book reference: references) {
            PaperInfo paperInfo = new PaperInfo();
            paperInfo.set_id(reference.get_id());
            paperInfo.setAuthor(reference.getAuthor());
            paperInfo.setDate(reference.getDate());
            paperInfo.setTitle(reference.getTitle());
            paperInfo.setIs_marked(reference.getIs_marked());
            res.add(paperInfo);
        }
        return res;
    }

    public List<PaperInfo>getGuideInfo(ReferenceService referenceService) {
        List<PaperInfo> res = new ArrayList<PaperInfo>();
        List<Guide> references = referenceService.getGuideListAll();
        for(Guide reference: references) {
            PaperInfo paperInfo = new PaperInfo();
            paperInfo.set_id(reference.get_id());
            paperInfo.setAuthor(reference.getAuthor());
            paperInfo.setDate(reference.getDate());
            paperInfo.setTitle(reference.getTitle());
            paperInfo.setIs_marked(reference.getIs_marked());
            res.add(paperInfo);
        }
        return res;
    }

    public List<PaperInfo>getDrugInstructionsInfo(ReferenceService referenceService) {
        List<PaperInfo> res = new ArrayList<PaperInfo>();
        List<DrugInstructions> references = referenceService.getDrugInstructionsListAll();
        for(DrugInstructions reference: references) {
            PaperInfo paperInfo = new PaperInfo();
            paperInfo.set_id(reference.get_id());
            paperInfo.setAuthor(reference.getAuthor());
            paperInfo.setDate(reference.getDate());
            paperInfo.setTitle(reference.getTitle());
            paperInfo.setIs_marked(reference.getIs_marked());
            res.add(paperInfo);
        }
        return res;
    }

    public List<PaperInfo>getDiagnosisReportInfo(ReferenceService referenceService) {
        List<PaperInfo> res = new ArrayList<PaperInfo>();
        List<DiagnosisReport> references = referenceService.getDiagnosisReportListAll();
        for(DiagnosisReport reference: references) {
            PaperInfo paperInfo = new PaperInfo();
            paperInfo.set_id(reference.get_id());
            paperInfo.setAuthor(reference.getAuthor());
            paperInfo.setDate(reference.getDate());
            paperInfo.setTitle(reference.getTitle());
            paperInfo.setIs_marked(reference.getIs_marked());
            res.add(paperInfo);
        }
        return res;
    }
}
