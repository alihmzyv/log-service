package com.alihmzyv.logservice.mapper.impl;

import com.alihmzyv.logservice.mapper.LogMapper;
import com.alihmzyv.logservice.proto.CreateLogRequest;
import com.alihmzyv.logservice.proto.LogResponse;
import com.alihmzyv.logservice.tables.records.LogRecord;
import com.alihmzyv.logservice.util.TimeUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jooq.DSLContext;
import org.jooq.JSONB;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static com.alihmzyv.logservice.Tables.LOG;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Component
public class LogMapperImpl implements LogMapper {
    DSLContext dslContext;

    @Override
    public LogRecord toRecord(CreateLogRequest createLogRequest) {
        if (createLogRequest == null) {
            return null;
        }

        return dslContext.newRecord(LOG)
                .setCreatedAt(LocalDateTime.now().atZone(ZoneId.systemDefault()).toLocalDateTime())
                .setOperationService((short) createLogRequest.getOperationService())
                .setOperationType((short) createLogRequest.getOperationType())
                .setUserId(createLogRequest.getUserId())
                .setCashierCode(createLogRequest.getCashierCode())
                .setJsonData(JSONB.jsonbOrNull(createLogRequest.getJson()));
    }

    @Override
    public LogResponse toDto(LogRecord logRecord) {
        if (logRecord == null) {
            return null;
        }

        return LogResponse.newBuilder()
                .setCreatedAt(TimeUtil.toEpochMilli(logRecord.getCreatedAt()))
                .setOperationService(logRecord.getOperationService())
                .setOperationType(logRecord.getOperationType())
                .setUserId(logRecord.getUserId())
                .setCashierCode(logRecord.getCashierCode())
                .setJson(logRecord.getJsonData().data())
                .build();
    }
}
