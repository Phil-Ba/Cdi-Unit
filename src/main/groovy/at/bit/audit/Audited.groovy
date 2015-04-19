package at.bit.audit
import javax.interceptor.InterceptorBinding
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

import static java.lang.annotation.ElementType.METHOD
import static java.lang.annotation.ElementType.TYPE
/**
 * Created by pbayer.*/

@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target([TYPE, METHOD])
@interface Audited {

}