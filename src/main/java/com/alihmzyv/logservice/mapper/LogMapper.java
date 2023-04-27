package com.alihmzyv.logservice.mapper;

import com.alihmzyv.logservice.proto.CreateLogRequest;
import com.alihmzyv.logservice.proto.LogResponse;
import com.alihmzyv.logservice.tables.records.LogRecord;

public interface LogMapper {
    LogRecord toRecord(CreateLogRequest createLogRequest);
    LogResponse toDto(LogRecord logRecord);
}
