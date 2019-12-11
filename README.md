# demo
基于spring4.3.25

?/**
  * 一、bean的加载顺序.
  *
  * 第一部分：造beanDefinitionMap:
  *  ps：此部分所描述的过程最终都是向beanDefinitionMap（无序）和beanNamesList（按add的先后顺序）放入bean定义
  *
  * 1. new AnnotationConfigApplicationContext时，初始化reader时，会提前注册一些支持注解的工具bean
  * @see org.springframework.context.annotation.AnnotationConfigUtils#registerAnnotationConfigProcessors(org.springframework.beans.factory.support.BeanDefinitionRegistry, java.lang.Object)
  *
  * 2. 手动register的bean
  *
  * 3. 自动扫描bean see{@link ConfigurationClassPostProcessor#processConfigBeanDefinitions(org.springframework.beans.factory.support.BeanDefinitionRegistry)}
  * (1) 先拿到当前已存在的beanDefinitionNames(之前spring 自动注册的，和手动register的)
  * (2) 为拿到的集合排序（注意：此排序不会影响已经存在的bean定义顺序，但是会影响基于这些bean衍生的bean定义的顺序！！！！！！！）
  * (3) 遍历这个集合，做parse操作
  *  A. parse
  *  @see org.springframework.context.annotation.ConfigurationClassParser#parse(java.util.Set)
  *
  *  1> 递归处理成员类
  *  2> 处理PropertySources注解
  *  3> 处理ComponentScan注解
  *  4> 处理Import注解
  *  B. 处理类内部的@Bean
  *  @see ConfigurationClassPostProcessor#processConfigBeanDefinitions(org.springframework.beans.factory.support.BeanDefinitionRegistry)
  *  这行 this.reader.loadBeanDefinitions(configClasses);
  *
  * 第二部分：单例提前getBean
  *  ps: 此部分描述的过程最终是在bean工厂中生产出bean实例
  *
  * 1. 提前实例化所有的BeanPostProcessor
  *  @see AbstractApplicationContext#registerBeanPostProcessors(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
  *
  * 2. 取到第一部分的beanNamesList遍历
  * @see DefaultListableBeanFactory#preInstantiateSingletons()
  * (1) 处理@DependsOn
  * (2) 处理自己
  *  @see AbstractAutowireCapableBeanFactory#createBean(java.lang.String, org.springframework.beans.factory.support.RootBeanDefinition, java.lang.Object[])
  *   1> pupulate时，先创建@Autowired的bean
  *   @see AbstractAutowireCapableBeanFactory#populateBean(java.lang.String, org.springframework.beans.factory.support.RootBeanDefinition, org.springframework.beans.BeanWrapper)
  *   2> 创建本身bean
  *
  *
  * @param args
  */

// ---------------------------

// xml方式
public ClassPathXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent)
			throws BeansException {
		super(parent);
		// 解析bean资源xml路径
		setConfigLocations(configLocations);
		if (refresh) {
			refresh();
		}
	}

// 注解方式：
public AnnotationConfigApplicationContext(Class<?>... annotatedClasses) {
		this();
		// 加载annotatedClasses的beanDefination到map
		register(annotatedClasses);
		refresh();
	}


@Override
	public void refresh() throws BeansException, IllegalStateException {
		synchronized (this.startupShutdownMonitor) {
			// Prepare this context for refreshing.
			// 准备时间等
			prepareRefresh();

			// Tell the subclass to refresh the internal bean factory.
		  // xml方式：创建BeanFactory并加载xml文件中bean到beanDefinationMap
		  // 注解方式：没干啥
			ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

			// Prepare the bean factory for use in this context.
		 // 构建BeanFactory基础东西
 			prepareBeanFactory(beanFactory);

			try {
				// Allows post-processing of the bean factory in context subclasses.
				postProcessBeanFactory(beanFactory);

				// Invoke factory processors registered as beans in the context.
				// xml方式：没干啥
		        // 注解方式：解析annotatedClasses里面方法上面设置的@bean（是否还有其他注解）并加载到beanDefinationMap
		        // 实现了BeanFactoryPostProcessor 提前getBean
				invokeBeanFactoryPostProcessors(beanFactory);

				// Register bean processors that intercept bean creation.
				// 实现了BeanPostProcessor 提前getBean
				registerBeanPostProcessors(beanFactory);

				// Initialize message source for this context.
				initMessageSource();

				// Initialize event multicaster for this context.
				initApplicationEventMulticaster();

				// Initialize other special beans in specific context subclasses.
				onRefresh();

				// Check for listener beans and register them.
				registerListeners();

				// Instantiate all remaining (non-lazy-init) singletons.
				finishBeanFactoryInitialization(beanFactory);

				// Last step: publish corresponding event.
				finishRefresh();
			}

			catch (BeansException ex) {
				if (logger.isWarnEnabled()) {
					logger.warn("Exception encountered during context initialization - " +
							"cancelling refresh attempt: " + ex);
				}

				// Destroy already created singletons to avoid dangling resources.
				destroyBeans();

				// Reset 'active' flag.
				cancelRefresh(ex);

				// Propagate exception to caller.
				throw ex;
			}

			finally {
				// Reset common introspection caches in Spring's core, since we
				// might not ever need metadata for singleton beans anymore...
				resetCommonCaches();
			}
		}
	}
	
	