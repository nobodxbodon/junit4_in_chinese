
package com.github.program_in_chinese.junit4_in_chinese;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.Test.None;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/**
 * 扩展 BlockJUnit4ClassRunner 令其能解析 {@link 测试}。
 * 当 @Test 与 @测试 同时存在时，以 @测试 优先。
 *
 * @author Azige
 */
public class 运行器 extends BlockJUnit4ClassRunner{

    public 运行器(Class<?> klass) throws InitializationError{
        super(klass);
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods(){
        Set<FrameworkMethod> collectedMethods = new HashSet<FrameworkMethod>();
        collectedMethods.addAll(getTestClass().getAnnotatedMethods(Test.class));
        collectedMethods.addAll(getTestClass().getAnnotatedMethods(测试.class));
        return Collections.unmodifiableList(new ArrayList<FrameworkMethod>(collectedMethods));
    }

    @Override
    protected void validateTestMethods(List<Throwable> errors){
        validatePublicVoidNoArgMethods(Test.class, false, errors);
        validatePublicVoidNoArgMethods(测试.class, false, errors);
    }

    @Override
    protected Statement possiblyExpectingExceptions(FrameworkMethod method, Object test, Statement next){
        测试 anno = method.getAnnotation(测试.class);
        if (anno != null){
            return expectsException(method) ? new ExpectException(next,
                getExpectedException(method)) : next;
        }

        Test testAnno = method.getAnnotation(Test.class);
        if (testAnno != null){
            return expectsException(method) ? new ExpectException(next,
                getExpectedException(method)) : next;
        }

        throw new AssertionError("不应该执行到这里");
    }

    @Override
    protected Statement withPotentialTimeout(FrameworkMethod method,
        Object test, Statement next){
        long timeout = getTimeout(method);
        if (timeout <= 0) {
            return next;
        }
        return FailOnTimeout.builder()
               .withTimeout(timeout, TimeUnit.MILLISECONDS)
               .build(next);
    }

    private Class getExpectedException(FrameworkMethod method){
        测试 anno = method.getAnnotation(测试.class);
        // 在测试注解存在时完全忽略Test
        if (anno != null){
            if (anno.期望异常() != None.class){
                return anno.期望异常();
            }else{
                return null;
            }
        }

        Test testAnno = method.getAnnotation(Test.class);
        if (testAnno != null && testAnno.expected() != None.class){
            return testAnno.expected();
        }

        return null;
    }

    private boolean expectsException(FrameworkMethod method){
        return getExpectedException(method) != null;
    }

    private long getTimeout(FrameworkMethod method){
        测试 anno = method.getAnnotation(测试.class);
        // 在测试注解存在时完全忽略Test
        if (anno != null){
            if (anno.期望异常() != None.class){
                return anno.超时();
            }else{
                return 0;
            }
        }

        Test testAnno = method.getAnnotation(Test.class);
        if (testAnno != null && testAnno.expected() != None.class){
            return testAnno.timeout();
        }

        return 0;
    }
}
