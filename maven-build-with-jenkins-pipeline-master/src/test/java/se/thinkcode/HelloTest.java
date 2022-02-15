package se.thinkcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloTest {

    @Test
    public void should_verify_test_environment() {
        Hello hello = new Hello();

        String actual = hello.greeting();

        assertThat(actual).isEqualTo("Hello, World!");
    }
}
