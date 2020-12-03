package br.com.SchedulingJob.config;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import br.com.SchedulingJob.model.entity.Job;

public class AppConfig {

	private static List<Job> jobs = null;

	public static List<Job> getConfig() {

		try {
			byte[] configBytes = Files.readAllBytes(Paths.get(AppConfig.class.getResource("/dados.json").toURI()));
			String jsonConfig = new String(configBytes, "UTF-8");
			Gson gson = new Gson();
			jobs = (List<Job>) Arrays.asList(gson.fromJson(jsonConfig, Job[].class));

		} catch (IOException | URISyntaxException e1) {
			e1.printStackTrace();
		}

		return jobs;
	}

}
