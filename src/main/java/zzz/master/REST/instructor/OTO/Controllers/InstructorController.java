package zzz.master.REST.instructor.OTO.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zzz.master.REST.instructor.OTO.Entities.InstructorEntity;
import zzz.master.REST.instructor.OTO.Repositories.InstructorRepository;

import java.util.List;

@RestController
public class InstructorController {

    @Autowired
    InstructorRepository instructorRepository;

    @GetMapping("/instructors")
    public List<InstructorEntity> getInstructors() {
        return instructorRepository.findAll();
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<InstructorEntity> getInstructorById(Long id) {
        return ResponseEntity.ok(instructorRepository.findById(id).get());
    }

    @PostMapping("/instructors")
    public void addInstructor(InstructorEntity instructor) {
        instructorRepository.save(instructor);
    }

    @PutMapping("instructors/{id}")
    public void updateInstructor(@PathVariable Long id, InstructorEntity instructor) {
        instructor.setId(id);
        instructorRepository.save(instructor);
    }

    @DeleteMapping("instructors/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        instructorRepository.deleteById(id);
    }
}
