package com.alihmzyv.logservice.service.impl;

import com.alihmzyv.logservice.mapper.LogMapper;
import com.alihmzyv.logservice.proto.CreateLogRequest;
import com.alihmzyv.logservice.repo.LogRepo;
import com.alihmzyv.logservice.service.LogService;
import com.alihmzyv.logservice.tables.records.LogRecord;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Service
public class LogServiceImpl implements LogService {
    LogRepo logRepo;
    LogMapper logMapper;

    @Override
    public void createLog(CreateLogRequest createLogRequest) {
        LogRecord logRecord = logMapper.toRecord(createLogRequest);
        logRepo.insertLog(logRecord);
    }
}
