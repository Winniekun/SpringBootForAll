package com.wkk.springbatch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @author kongweikun@163.com
 * @date 2023/1/30
 */
@Slf4j
public class MyJobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("job 开始, id={}",jobExecution.getJobId());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("job 结束, id={}",jobExecution.getJobId());
    }
}
