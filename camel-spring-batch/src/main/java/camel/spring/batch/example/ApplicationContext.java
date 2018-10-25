package camel.spring.batch.example;

import java.net.MalformedURLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.UrlResource;

import camel.spring.batch.example.domain.Person;
import camel.spring.batch.example.domain.PersonItemProcessor;

@Configuration
@EnableBatchProcessing
public class ApplicationContext extends DefaultBatchConfigurer {   

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Override
    public void setDataSource(DataSource dataSource) {
    }
	
	@Bean
	public FlatFileItemReader<Person> reader() throws MalformedURLException {
		return new FlatFileItemReaderBuilder<Person>()
				.name("personItemReader")
				.resource(new UrlResource("file:/home/ketav/Documents/workspace/hotels/src/main/resources/sample-data.csv"))
				.delimited()
				.names(new String[]{"firstName", "lastName", "age"})
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
					setTargetType(Person.class);
				}})
				.build();
	}

	@Bean
	public PersonItemProcessor processor() {
		return new PersonItemProcessor();
	}

	@Bean
	public Job importUserJob(/*JobCompletionNotificationListener listener,*/ Step step1) {
		return jobBuilderFactory.get("importUserJob")
				.incrementer(new RunIdIncrementer())
				/*.listener(listener)*/
				.flow(step1)
				.end()
				.build();
	}

	@Bean
	public Step step1() throws MalformedURLException {
		return stepBuilderFactory.get("step1")
				.<Person, Void> chunk(3)
				.reader(reader())
				.processor(itemProcessor())
				.build();
	}

	@Bean
	public ItemProcessor<Person, Void> itemProcessor() {
		return new PersonItemProcessor();
	}

}
