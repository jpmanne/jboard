/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;*/
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JBoradApplication /* extends SpringBootServletInitializer */ {
	private static final Logger log = LoggerFactory.getLogger(JBoradApplication.class);

	// =========================================================================

	public static void main(String[] args) {
		SpringApplication.run(JBoradApplication.class, args);
		log.info("Start of the JBoradApplication............... ");
	}

	// =========================================================================

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder application) { return
	 * application.sources(JBoradApplication.class); }
	 */

	// =========================================================================
}
