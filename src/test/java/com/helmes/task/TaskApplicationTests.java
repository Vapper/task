package com.helmes.task;

import com.helmes.task.entities.User;
import com.helmes.task.services.SectorService;
import com.helmes.task.services.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskApplicationTests {

	@Autowired
	UserService userService;
	@Autowired
	SectorService sectorService;

	@Test
	@Ignore
	public void contextLoads() {
	}
}
