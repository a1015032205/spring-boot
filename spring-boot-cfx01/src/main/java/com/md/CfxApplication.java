package com.md;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;

/**
 * @Author: 秒度
 * @Email: fangxin.md@Gmail.com
 * @Date: 2021-01-25 20:57
 * @Description:
 */
@Slf4j
@SpringBootApplication
public class CfxApplication extends SpringApplication{

	@Override
	protected void afterRefresh(ConfigurableApplicationContext context, ApplicationArguments args) {
		log.info("========================= 容器刷新成功，即将启动 ===========================");
	}

	@Override
	protected void refresh(ConfigurableApplicationContext applicationContext) {
		log.info("========================= 应用预检完成，准备启动 ===========================");
		Assert.isInstanceOf(AbstractApplicationContext.class, applicationContext);
		applicationContext.refresh();
	}



	public CfxApplication(Class<?>... primarySources) {
		super(primarySources);
	}


	public CfxApplication(){}

	public static void main(String[] args) {
		CfxApplication cfxApplication = new CfxApplication(CfxApplication.class);
		cfxApplication.run(args);

	}
}
