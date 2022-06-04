package com;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@PostMapping("/project")
	public Project project() {

		return new Project(counter.incrementAndGet());
	}
}
