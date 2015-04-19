package at.bit.audit

import at.bit.controller.BankingController
import at.bit.dao.AuditDao
import org.jglue.cdiunit.AdditionalClasses
import org.jglue.cdiunit.CdiRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer

import javax.enterprise.inject.Produces
import javax.inject.Inject

import static org.mockito.Matchers.anyString
import static org.mockito.Matchers.matches
import static org.mockito.Mockito.doAnswer
import static org.mockito.Mockito.verify

/**
 * Created by pbayer.*/

@RunWith(CdiRunner)
@AdditionalClasses(Auditor)
class AuditorTest {

    @Mock
    @Produces
    private AuditDao auditDao;

    @Inject
    BankingController bankingController

    @Before
    void setup() {
        doAnswer(new Answer<Object>() {
            @Override
            Object answer(InvocationOnMock invocation) throws Throwable {
                println(invocation.arguments)
                return null
            }
        }).when(auditDao).logMessage(anyString())
    }

    @Test
    void addToBalanceAudited() {
        bankingController.addToBalance(100)
        verify(auditDao).logMessage(matches('Method .*addToBalance.*100.*'))
        verify(auditDao).logMessage(matches('Method .*addToBalance.*returned.*200.*'))
    }

}
