package ca.lijun.ecommerce;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Parameterized Test")
public class ParameterizedTests {

  @ParameterizedTest
  @DisplayName("test Value Source")
  @ValueSource(ints = {1, 2, 3, 4, 5})
  void testValueSource(int i){
    System.out.println("param = " + i);
  }

  @ParameterizedTest
//  @NullSource
//  @EmptySource
  @NullAndEmptySource
  @ValueSource(strings = { " ", "   ", "\t", "\n" })
  void nullEmptyAndBlankStrings(String text) {
    assertTrue(text == null || text.trim().isEmpty());
  }

  @ParameterizedTest
  @EnumSource(ChronoUnit.class)
  void testWithEnumSource(TemporalUnit unit) {
    assertNotNull(unit);
  }

  @ParameterizedTest
  @MethodSource("stringProvider")
  void testWithExplicitLocalMethodSource(String argument) {
    assertNotNull(argument);
  }

  static Stream<String> stringProvider() {
    return Stream.of("apple", "banana");
  }
}
