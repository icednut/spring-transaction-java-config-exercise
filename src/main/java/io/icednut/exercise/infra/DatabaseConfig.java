package io.icednut.exercise.infra;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.AbstractTransactionManagementConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.config.TransactionManagementConfigUtils;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-01-24
 */
@Configuration
@EnableJpaAuditing
@EntityScan({"io.icednut.exercise.infra.entity"})
@EnableJpaRepositories({"io.icednut.exercise.infra.repository"})
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ, proxyTargetClass = false)
@EnableAspectJAutoProxy
public class DatabaseConfig extends AbstractTransactionManagementConfiguration {

    @Primary
    @Bean(name = TransactionManagementConfigUtils.TRANSACTION_ASPECT_BEAN_NAME)
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public TransactionCustomAspect userAspect() {
        return new TransactionCustomAspect();
    }

    //    @Bean(name = TransactionManagementConfigUtils.TRANSACTION_ASPECT_BEAN_NAME)
    //    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    //    public AnnotationTransactionAspect transactionAspect() {
    //        AnnotationTransactionAspect txAspect = AnnotationTransactionAspect.aspectOf();
    //        if (this.txManager != null) {
    //            txAspect.setTransactionManager(this.txManager);
    //        }
    //        return txAspect;
    //    }

}
