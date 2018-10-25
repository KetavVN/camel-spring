package camel.spring.batch.example.domain;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Void>, StepExecutionListener {

	private AtomicLong processedRecords = new AtomicLong(0l);
	
	@Override
	public ExitStatus afterStep(StepExecution arg0) {
		System.out.println(processedRecords);
		return ExitStatus.COMPLETED;
	}

	@Override
	public void beforeStep(StepExecution arg0) {
	}
	
	@Override
	public Void process(Person person) throws Exception {
		System.out.println(person);
		processedRecords.getAndAdd(1);
		return null;
	}

}
