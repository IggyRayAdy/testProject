package com.test.application.Services;

import com.test.application.Entities.Request;
import com.test.application.Repositories.ReqRepository;
import com.test.application.Services.IServices.IReqService;
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
