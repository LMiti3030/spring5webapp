package mititelu.laura.guru.springframework.spring5webapp.repositories;


import mititelu.laura.guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author LMiti3030
 * created on 11/29/2022
 */

public interface BookRepository extends CrudRepository<Book,Long> {
}
