package com.w2m.superheroes.superheroes_test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.superheroes.superheroes_test.SuperheroesTestApplication;

@SpringBootTest(classes = SuperheroesTestApplication.class)
@ComponentScan(basePackages = {"com.w2m.superheroes.*"})
class SuperheroesTestApplicationTests {
	@Test
	void contextLoads() {
	}

}
