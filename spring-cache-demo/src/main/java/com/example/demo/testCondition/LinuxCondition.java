package com.example.demo.testCondition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition{

	@Override
	public boolean matches(ConditionContext arg0, AnnotatedTypeMetadata arg1) {
		return arg0.getEnvironment().getProperty("os.name").contains("Linux");
	}

}
