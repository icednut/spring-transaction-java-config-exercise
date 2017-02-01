package io.icednut.exercise.infra;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-01-25
 */
@Aspect
public class TransactionCustomAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionCustomAspect.class);

    //    @Pointcut("execution(* io.icednut.exercise.api.support.UserService.get*(..))")
    //    public void pointCut() {
    //    }

    @Around("execution(* io.icednut.exercise.api.support.UserService.get*(..))")
    @Transactional(readOnly = true)
    public Object getAdvice(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        LOGGER.info("********************** call Transaction Custom Aspect");

        return thisJoinPoint.proceed();
    }
}
