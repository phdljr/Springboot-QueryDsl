package kr.ac.phdljr.springbootjpaquerydsl.controller;

import kr.ac.phdljr.springbootjpaquerydsl.dto.SubjectScoreResponse;
import kr.ac.phdljr.springbootjpaquerydsl.service.SubjectScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectScoreController {

    private final SubjectScoreService subjectScoreService;

    @GetMapping("/score/{studentId}")
    public ResponseEntity<List<SubjectScoreResponse>> getScoresByStudent(@PathVariable Long studentId){
        List<SubjectScoreResponse> subjectScoreList = subjectScoreService.findScoresByStudent(studentId);
        return ResponseEntity.ok(subjectScoreList);
    }
}
