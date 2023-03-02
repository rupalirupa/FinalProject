package com.cjc.DaoI;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.Email;
@Repository
public interface EamilReposioty extends CrudRepository<Email, Integer>
{

}
