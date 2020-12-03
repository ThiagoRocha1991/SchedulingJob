package br.com.SchedulingJob;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.SchedulingJob.model.entity.Job;

import br.com.SchedulingJob.validation.ValidaJob;

/**
 * Unit test for simple App.
 */
public class ValidaJobTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void testValidaJobData() {

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

		String dataStringInicio = "2019/11/10 09:00";
		String dataStringFim = "2019/11/11 12:00";

		LocalDateTime dataInicio = LocalDateTime.parse(dataStringInicio, formato);
		LocalDateTime dataFim = LocalDateTime.parse(dataStringFim, formato);
		
		Job job1 = new Job(1, "Teste 1", "2019/11/11 08:00", "2", 0L, false);
		Job job2 = new Job(2, "Teste 2", "2019/11/10 10:00", "4", 2L, false);

		List<Job> jobs = new ArrayList<Job>();
		jobs.add(job1);
		jobs.add(job2);

		ValidaJob valida = new ValidaJob();

		jobs = valida.validaJobData(jobs, dataInicio, dataFim);
		
		System.out.println(jobs);

		for (Job job : jobs) {

			assertThat(job.validaJob, is(true));
		}

	}
}
