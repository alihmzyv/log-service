package com.alihmzyv.logservice.service;

import com.alihmzyv.logservice.proto.CreateLogRequest;
import com.alihmzyv.logservice.proto.LogResponse;

public interface LogService {
    LogResponse createLog(CreateLogRequest createLogRequest);
}
