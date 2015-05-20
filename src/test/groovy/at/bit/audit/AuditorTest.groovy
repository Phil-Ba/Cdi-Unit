package at.bit.audit

import org.jglue.cdiunit.CdiRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
/**
 * Created by pbayer.*/

@RunWith(CdiRunner)
class AuditorTest {

    @Test
    void addToBalanceAudited() {
        Mockito.verify(auditDao).logMessage(Mockito.matches('Method .*addToBalance.*100.*'))
        Mockito.verify(auditDao).logMessage(Mockito.matches('Method .*addToBalance.*returned.*200.*'))
    }

}
