package com.junoth.aws.sqssample.service;

import com.amazonaws.services.sqs.model.SendMessageResult;
import com.junoth.aws.sqssample.config.BasicSqsClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PublishService {

	@Autowired
	private BasicSqsClient basicClient;

	@Value("${cloud.aws.sqs.url}")
	private String url;

	@Scheduled(fixedRate = 10000)
	private void sendMessage() {

		SendMessageResult rs = this.basicClient.getBasicSqsClient().sendMessage(this.url, "Hello!");
		log.info(rs.getMessageId());
	}

}
