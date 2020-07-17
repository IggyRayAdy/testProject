package com.test.application.Repositories;

import com.test.application.Entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReqRepository extends JpaRepository<Request, Integer> {


}
