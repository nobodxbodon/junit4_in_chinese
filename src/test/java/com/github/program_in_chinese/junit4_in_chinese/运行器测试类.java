
package com.github.program_in_chinese.junit4_in_chinese;

import static com.github.program_in_chinese.junit4_in_chinese.断言类.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Azige
 */
@RunWith(运行器.class)
public class 运行器测试类{

    @测试
    public void 仅测试(){
        相等(2, 1 + 1);
    }

    @Test
    public void 仅Test(){
        assertEquals(2, 1 + 1);
    }

    @测试(期望异常 = IllegalStateException.class)
    public void 期望异常(){
        throw new IllegalStateException();
    }

    @Test(expected = IllegalStateException.class)
    @测试
    public void 混用_Test先(){
        // 什么也不做，如果只有 @Test 的情况下应当测试失败
    }

    @测试
    @Test(expected = IllegalStateException.class)
    public void 混用_测试先(){
        // 什么也不做，如果只有 @Test 的情况下应当测试失败
    }

    @Test(expected = IllegalStateException.class)
    @测试(期望异常 = NumberFormatException.class)
    public void 混用期望异常_Test先(){
        throw new NumberFormatException();
    }

    @测试(期望异常 = NumberFormatException.class)
    @Test(expected = IllegalStateException.class)
    public void 混用期望异常_测试先(){
        throw new NumberFormatException();
    }

}
