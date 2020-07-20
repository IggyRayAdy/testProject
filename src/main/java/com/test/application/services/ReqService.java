package com.test.application.services;

import com.test.application.entities.Request;
import com.test.application.repositories.ReqRepository;
import com.test.application.services.iServices.IReqService;
import org.springframework.stereotype.Service;

@Service
public class ReqService implements IReqService {

    private final ReqRepository reqRepository;

    public ReqService(ReqRepository reqRepository) {
        this.reqRepository = reqRepository;
    }

    @Override
    public Request createReq(Request request) {
        return reqRepository.save(request);
    }


}
