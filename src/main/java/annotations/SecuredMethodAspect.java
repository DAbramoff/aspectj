package annotations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecuredMethodAspect {

    @Pointcut("@annotation(secured)")
    public void callAt(Secured secured) {
    }

    @Around("callAt(secured)")
    public Object around(ProceedingJoinPoint pjp,
                         Secured secured) throws Throwable {
        Boolean result = secured.isLocked() ? null : (Boolean) pjp.proceed();
        if(result == null){
            System.out.println("[around] method locked");
        } else {
            System.out.println("[around] method unlocked");
        }
        return result;
    }
}
