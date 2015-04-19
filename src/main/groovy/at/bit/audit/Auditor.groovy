package at.bit.audit

import at.bit.dao.AuditDao

import javax.inject.Inject
import javax.interceptor.AroundInvoke
import javax.interceptor.Interceptor
import javax.interceptor.InvocationContext
/**
 * Created by pbayer.*/
@Interceptor
@Audited
class Auditor {

    @Inject
    private AuditDao auditDao

    @AroundInvoke
    private Object auditCall(InvocationContext ic) {
        println('Auditor invoked!')
        auditDao.logMessage("Method \'$ic.method\' was called with parameters \'$ic.parameters\'".toString())
        Object returnValue = ic.proceed()
        auditDao.logMessage("Method \'$ic.method\' returned \'$returnValue\'".toString())
        returnValue
    }
}
