package com.spring.boot.service.oracle.scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spring.boot.dbmodel.oracle.DummyEntity;
import com.spring.boot.repository.oracle.DummyEntityRepository;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class SchedulerService {

	@Autowired
	private DummyEntityRepository dummyEntityRepository;
	
	// Runs every 15 seconds
//	@Scheduled(fixedRate = 15000)
    public void saveDummy1() {
		log.info("Task executed at: " + LocalDateTime.now());
		
		DummyEntity de = new DummyEntity();
			de.setDname("s1"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		dummyEntityRepository.save(de);
    }

    // Runs 10 seconds after the previous execution finishes
//     @Scheduled(fixedDelay = 10000)
     public void saveDummy2() {
 		log.info("Task executed at: " + LocalDateTime.now());
 		
 		try {
            Thread.sleep(10000); // 10000 milliseconds = 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace(); 
            Thread.currentThread().interrupt(); 
        }
 		
 		DummyEntity de = new DummyEntity() ;
// 				de.setDid(UUID.randomUUID().toString());
 				de.setDname("s2"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
 				dummyEntityRepository.save(de);
     }
    // Runs every day at 11:445 AM using cron expression
//     @Scheduled(cron = "0 45 11 * * ?")
     public void saveDummy3() {
 		log.info("Task executed at: " + LocalDateTime.now());
 		
 		DummyEntity de = new DummyEntity() ;
// 				de.setDid(UUID.randomUUID().toString());
 				de.setDname("s3"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
 				dummyEntityRepository.save(de);
     }
}
