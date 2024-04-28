package com.wkk.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author kongweikun@163.com
 * @date 2023/1/30
 */
@Configuration
@EnableBatchProcessing
public class MyBatchConfig {

    /**
     * JobRepository定义：Job的注册容器以及和数据库打交道（事务管理等）
     * @param dataSource
     * @param transactionManager
     * @return
     * @throws Exception
     */
    @Bean
    public JobRepository myJobRepository(DataSource dataSource, PlatformTransactionManager transactionManager) throws Exception{
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDatabaseType("mysql");
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.setDataSource(dataSource);
        return jobRepositoryFactoryBean.getObject();
    }

    /**
     * jobLauncher定义：job的启动器,绑定相关的jobRepository
     * @param dataSource
     * @param transactionManager
     * @return
     * @throws Exception
     */
    @Bean
    public SimpleJobLauncher myJobLauncher(DataSource dataSource, PlatformTransactionManager transactionManager) throws Exception{
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        // 设置jobRepository
        jobLauncher.setJobRepository(myJobRepository(dataSource, transactionManager));
        return jobLauncher;
    }

    /**
     * 定义job
     * @param jobs
     * @param myStep
     * @return
     */
    @Bean
    public Job myJob(JobBuilderFactory jobs, Step myStep){
        return jobs.get("myJob")
                .incrementer(new RunIdIncrementer())
                .flow(myStep)
                .end()
                .listener(myJobListener())
                .build();
    }

    /**
     * 注册job监听器
     * @return
     */
    @Bean
    public MyJobListener myJobListener(){
        return new MyJobListener();
    }

    /**
     * ItemReader定义：读取文件数据+entirty实体类映射
     * @return
     */
    @Bean
    public ItemReader<BlogInfo> reader(){
        // 使用FlatFileItemReader去读cvs文件，一行即一条数据
        FlatFileItemReader<BlogInfo> reader = new FlatFileItemReader<>();
        // 设置文件处在路径
        reader.setResource(new ClassPathResource("static/bloginfo.csv"));
        // entity与csv数据做映射
        reader.setLineMapper(new DefaultLineMapper<BlogInfo>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[]{"blogAuthor","blogUrl","blogTitle","blogItem"});
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<BlogInfo>() {
                    {
                        setTargetType(BlogInfo.class);
                    }
                });
            }
        });
        return reader;
    }

}
