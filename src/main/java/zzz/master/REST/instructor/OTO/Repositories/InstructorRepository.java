package zzz.master.REST.instructor.OTO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zzz.master.REST.instructor.OTO.Entities.InstructorEntity;

public interface InstructorRepository extends JpaRepository<InstructorEntity, Long> {
}
