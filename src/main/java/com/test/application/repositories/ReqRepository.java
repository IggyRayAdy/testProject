package com.test.application.repositories;

import com.test.application.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReqRepository extends JpaRepository<Request, Integer> {

}
