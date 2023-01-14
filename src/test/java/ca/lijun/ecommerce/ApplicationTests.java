package ca.lijun.ecommerce;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@DisplayName("junit5 feature test")
@SpringBootTest
public class ApplicationTests {

  @DisplayName("Test DisplayName Annotation")
  @Test
  void testDisplayName(){
    System.out.println("test method testDisplayName() is running.");
  }

  @Disabled
  @DisplayName("Test method 2")
  @Test
  void test2(){
    System.out.println("test method test2() is running.");
  }

  @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
  @Test
  void testTimeout() throws InterruptedException {
    Thread.sleep(400);
  }

  @RepeatedTest(3)
  void testRepeat(){
    System.out.println("this method will run 3 times");
  }

  @BeforeEach
  void testBeforeEach(){
    System.out.println("-Unit test method is starting now.");
  }

  @AfterEach
  void testAfterEach(){
    System.out.println("-Unit test method finished.");
  }

  @BeforeAll
  static void testBeforeAll(){
    System.out.println("===All test is starting...");
  }

  @AfterAll
  static void testAfterAll(){
    System.out.println("===All test finished...");
  }

  @DisplayName("Test simple assertion")
  @Test
  void testSimpleAssertions(){
    int result = cal(2, 3);
//    Assertions.assertEquals(5, result);
    Assertions.assertEquals(5, result, "business logic error");
//    Assertions.assertNotEquals();
  }

  @Disabled
  @DisplayName("Test Compare Objects")
  @Test
  void testCompareObject(){
    Object o1 = new Object();
    Object o2 = new Object();
    Assertions.assertSame(o1, o2);
  }

  @DisplayName("Test Compare Arrays")
  @Test
  void testCompareArrays(){
    Assertions.assertArrayEquals(new int[]{1, 2}, new int[]{1, 2});
  }

  // This is a business logic method
  int cal(int i, int j){
    // make a mistake in purpose
    return i + j;
  }

  @DisplayName("Test multiple assertions")
  @Test
  void testMultipleAssertions(){
    Assertions.assertAll("Multiple assertions",
            ()->Assertions.assertTrue(true && true),
            ()->Assertions.assertEquals(2, 2));
  }

  @DisplayName("Test exception assertion")
  @Test
  void testException(){

    Assertions.assertThrows(ArithmeticException.class,
            ()->{
              int i = 10/0;
//              int i = 10/2;
            },
            "There should be an exception");
  }

  @Disabled
  @DisplayName("Test fail assertion")
  @Test
  void testFail(){
    // do other test steps

    if(2 == 2) {
      Assertions.fail("Test failed");
    }
  }

  @DisplayName("Test Assumptions")
  @Test
  void testAssumptions(){
    Assumptions.assumeTrue(false, "Assumption is true");
    System.out.println("Assumption is true");
  }
}
