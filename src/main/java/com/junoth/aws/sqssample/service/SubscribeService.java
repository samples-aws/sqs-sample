package com.junoth.aws.sqssample.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.Acknowledgment;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SubscribeService {

	@SqsListener(value = "${cloud.aws.sqs.url}", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
	public void receive(String message, Acknowledgment ack) {

		log.info(message);
		ack.acknowledge();
	}

}
