package org.bits.service.Service;

import org.bits.service.Domain.Audit.AuditLog;
import org.bits.service.Repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Transactional
    public void createAuditLog(AuditLog log) {
        auditLogRepository.save(log);
    }
}