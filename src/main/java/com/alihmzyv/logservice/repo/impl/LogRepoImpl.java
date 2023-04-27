package com.alihmzyv.logservice.repo.impl;

import com.alihmzyv.logservice.repo.LogRepo;
import com.alihmzyv.logservice.tables.records.LogRecord;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.alihmzyv.logservice.Tables.LOG;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Repository
public class LogRepoImpl implements LogRepo {
    DSLContext dslContext;

    @Override
    public LogRecord insertLog(LogRecord logRecord) {
        return dslContext.insertInto(LOG)
                .set(logRecord)
                .returning()
                .fetchOne();
    }
}
