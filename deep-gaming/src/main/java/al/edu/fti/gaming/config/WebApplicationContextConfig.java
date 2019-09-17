package al.edu.fti.gaming.config;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.util.UrlPathHelper;

import al.edu.fti.gaming.validator.CpuCacheValidator;
import al.edu.fti.gaming.validator.CpuCoresValidator;
import al.edu.fti.gaming.validator.CpuSpeedValidator;
import al.edu.fti.gaming.validator.CpuValidator;
import al.edu.fti.gaming.validator.GpuSpeedValidator;
import al.edu.fti.gaming.validator.GpuValidator;
import al.edu.fti.gaming.validator.ProductPriceQuantityValidator;

@Configuration
@EnableWebMvc
@ComponentScan("al.edu.fti.gaming")
public class WebApplicationContextConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));
		return resolver;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
		resource.addBasenames("messages");
		return resource;
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	
	

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
		registry.addResourceHandler("/img/**").addResourceLocations("/resources/img/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("/resources/fonts/");

	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		UrlPathHelper urlPathHelper = new UrlPathHelper();
		urlPathHelper.setRemoveSemicolonContent(false);

		configurer.setUrlPathHelper(urlPathHelper);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		registry.addInterceptor(localeChangeInterceptor);
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		resolver.setMaxUploadSize(1000000);
		return resolver;
	}

	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	@Override
	public Validator getValidator() {
		return localValidatorFactoryBean();
	}

	@Bean
	public CpuValidator cpuValidator() {
		Set<Validator> springValidators = new HashSet<Validator>();
		springValidators.add(new CpuSpeedValidator());
		springValidators.add(new CpuCoresValidator());
		springValidators.add(new CpuCacheValidator());
		springValidators.add(new ProductPriceQuantityValidator());
		CpuValidator cpuValidator = new CpuValidator();
		cpuValidator.setSpringValidators(springValidators);
		return cpuValidator;
	}
	
	@Bean
	public GpuValidator gpuValidator() {
		Set<Validator> springValidators = new HashSet<Validator>();
		springValidators.add(new GpuSpeedValidator());
		springValidators.add(new ProductPriceQuantityValidator());
		GpuValidator gpuValidator = new GpuValidator();
		gpuValidator.setSpringValidators(springValidators);
		return gpuValidator;
	}

}
