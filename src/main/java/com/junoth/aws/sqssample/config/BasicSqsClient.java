package com.junoth.aws.sqssample.config;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
@Scope("singleton")
public class BasicSqsClient {

	@Value("${cloud.aws.region.static}")
	private String region;

	private AmazonSQS basicSqsClient;

	@PostConstruct
	private void init() {

		this.basicSqsClient = AmazonSQSClientBuilder
			 .standard()
			 .withRegion(this.region)
			 .build();
	}

}