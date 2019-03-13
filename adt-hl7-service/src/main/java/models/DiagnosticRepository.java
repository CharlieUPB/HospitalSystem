package models;

import org.springframework.data.repository.CrudRepository;
import models.Diagnostic;


public interface DiagnosticRepository extends CrudRepository<Diagnostic, Integer> {

}
