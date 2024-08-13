package zzz.master.REST.instructor.OTO.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zzz.master.REST.instructor.OTO.Entities.DetailEntity;
import zzz.master.REST.instructor.OTO.Entities.InstructorEntity;
import zzz.master.REST.instructor.OTO.Repositories.DetailRepository;
import zzz.master.REST.instructor.OTO.Repositories.InstructorRepository;

import java.util.List;

@RestController
public class InstructorController {

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    DetailRepository detailRepository;

    @GetMapping("/instructors")
    public List<InstructorEntity> getInstructors() {
        return instructorRepository.findAll();
    }

    @GetMapping("/details")
    public List<DetailEntity> getDetails() {
        return detailRepository.findAll();
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<InstructorEntity> getInstructorById(@PathVariable Long id) {
        return ResponseEntity.ok(instructorRepository.findById(id).get());
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<DetailEntity> getDetailById(@PathVariable Long id) {
        return ResponseEntity.ok(detailRepository.findById(id).get());
    }

    @PostMapping("/instructors")
    public void addInstructor(@Valid @RequestBody InstructorEntity instructor) {
        instructorRepository.save(instructor);
    }

    @PostMapping("/details")
    public void addInstructorDetail(@Valid @RequestBody DetailEntity detail) {
        detailRepository.save(detail);
    }

    @PutMapping("/instructors/{id}")
    public void updateInstructor(@PathVariable Long id, @Valid @RequestBody InstructorEntity instructor) {
        instructor.setId(id);
        instructorRepository.save(instructor);
    }

    @PutMapping("/instructors/{id}/detail/{idDetail}")
    public void updateInstructorDetail(@PathVariable Long id, @PathVariable Long idDetail) {
        InstructorEntity instructor = instructorRepository.findById(id).get();
        DetailEntity detail = detailRepository.findById(idDetail).get();
        if (instructor != null) {
            instructor.setDetail(detail);
            instructorRepository.save(instructor);
        }else {
            System.out.println("Instructor not found");
        }
    }

    @PutMapping("/details/{id}")
    public void updateDetail(@PathVariable Long id, @Valid @RequestBody DetailEntity detail) {
        detail.setId(id);
        detailRepository.save(detail);
    }

    @DeleteMapping("instructors/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        instructorRepository.deleteById(id);
    }

    @DeleteMapping("details/{id}")
    public void deleteInstructorDetail(@PathVariable Long id) {
        detailRepository.deleteById(id);
    }
}
