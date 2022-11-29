package mititelu.laura.guru.springframework.spring5webapp.repositories;


import mititelu.laura.guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author LMiti3030
 * created on 11/29/2022
 */

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
