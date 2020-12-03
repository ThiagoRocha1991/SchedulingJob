package br.com.SchedulingJob.validation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.SchedulingJob.model.entity.Job;

public class ValidaJob {

	private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

	public List<Job> validaJobData(List<Job> jobs, LocalDateTime dataInicio, LocalDateTime dataFim) {

		for (Job job : jobs) {

			LocalDateTime dt = LocalDateTime.parse(job.getDataMaxima(), formato);

			if (dt.isAfter(dataInicio) && dt.isBefore(dataFim) || dt.isEqual(dataInicio) || dt.isEqual(dataFim)) {
				System.out.println("A data do Job " + job.getId() + " está dentro do Intervalo");
				job.setValidaJob(true);

			} else {
				System.out.println("A data do Job " + job.getId() + " está fora do Intervalo");
				job.setValidaJob(false);
			}
		}
		return jobs;
	}

}
