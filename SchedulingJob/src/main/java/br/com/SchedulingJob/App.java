package br.com.SchedulingJob;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

import br.com.SchedulingJob.config.AppConfig;
import br.com.SchedulingJob.model.entity.Job;
import br.com.SchedulingJob.validation.ValidaJob;

/**
 * Hello world!
 *
 */
public class App {

	private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

	public static void main(String[] args) {

		String dataStringInicio = "2019/11/10 09:00";
		String dataStringFim = "2019/11/11 12:00";

		LocalDateTime dataInicio = LocalDateTime.parse(dataStringInicio, formato);
		LocalDateTime dataFim = LocalDateTime.parse(dataStringFim, formato);

		List<Job> jobs = new ArrayList<Job>();

		jobs = AppConfig.getConfig();

		ValidaJob valida = new ValidaJob();
		jobs = valida.validaJobData(jobs, dataInicio, dataFim);

		for (Job j : jobs) {

			LocalDateTime dt = LocalDateTime.parse(j.getDataMaxima(), formato);
			Duration dif = Duration.between(dataInicio, dt);
			Long d = dif.toDays();
			Long h = dif.toHours();

			j.setDifHoraInicioEHoraJob(h);

			System.out.println("--------------");
			System.out.println(j.getDescricao());
			System.out.println("ID do Job: " + j.getId());
			System.out.println("Diferenca de dias: " + d);
			System.out.println("Diferenca de horas: " + h);
			System.out.println("--------------");

		}

		System.out.println(jobs);
		System.out.println("--------------");

		System.out.println("Imprimindo a Tarefa dos Jobs");
		jobs.stream().sorted((p1, p2) -> p1.getDifHoraInicioEHoraJob().compareTo(p2.getDifHoraInicioEHoraJob()))
				.forEach(p -> System.out.println(p.id));

	}
}
