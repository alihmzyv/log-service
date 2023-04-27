package com.alihmzyv.logservice.repo;

import com.alihmzyv.logservice.tables.records.LogRecord;

public interface LogRepo {
    LogRecord insertLog(LogRecord logRecord);
}
