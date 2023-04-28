package com.alihmzyv.logservice.service;

import com.alihmzyv.logservice.proto.CreateLogRequest;

public interface LogService {
    void createLog(CreateLogRequest createLogRequest);
}
