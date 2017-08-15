package com.github.program_in_chinese.junit4_in_chinese;

import static com.github.program_in_chinese.junit4_in_chinese.断言.相等;
import static com.github.program_in_chinese.junit4_in_chinese.断言.不等;
import static com.github.program_in_chinese.junit4_in_chinese.断言.为真;
import static com.github.program_in_chinese.junit4_in_chinese.断言.为假;

import org.junit.Test;

public class 断言测试类 {

  @Test
  public void 相等测试() {
    相等(1, 1);
  }

  @Test
  public void 不等测试() {
    不等(1, 2);
  }

  @Test
  public void 为真测试() {
    为真(true);
  }

  @Test
  public void 为假测试() {
    为假(false);
  }
  
  // TODO: 测试"失败"
}
