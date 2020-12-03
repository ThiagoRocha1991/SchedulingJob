package br.com.SchedulingJob.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Job {

	@SerializedName("ID")
	@Expose
	public int id;
	@SerializedName("Descricao")
	@Expose
	public String descricao;
	@SerializedName("Data Maxima de conclusao")
	@Expose
	public String dataMaxima;
	@SerializedName("Tempo estimado")
	@Expose
	public String tempoEstimado;

	public Long difHoraInicioEHoraJob;
	public boolean validaJob;

	public Job(int id, String descricao, String dataMaxima, String tempoEstimado, Long difHoraInicioEHoraJob,
			boolean validaJob) {
		this.id = id;
		this.descricao = descricao;
		this.dataMaxima = dataMaxima;
		this.tempoEstimado = tempoEstimado;
		this.difHoraInicioEHoraJob = difHoraInicioEHoraJob;
		this.validaJob = validaJob;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getDataMaxima() {
		return dataMaxima;
	}

	public String getTempoEstimado() {
		return tempoEstimado;
	}

	public Long getDifHoraInicioEHoraJob() {
		return difHoraInicioEHoraJob;
	}

	public boolean isValidaJob() {
		return validaJob;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDataMaxima(String dataMaxima) {
		this.dataMaxima = dataMaxima;
	}

	public void setTempoEstimado(String tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}

	public void setDifHoraInicioEHoraJob(Long difHoraInicioEHoraJob) {
		this.difHoraInicioEHoraJob = difHoraInicioEHoraJob;
	}

	public void setValidaJob(boolean validaJob) {
		this.validaJob = validaJob;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", descricao=" + descricao + ", dataMaxima=" + dataMaxima + ", tempoEstimado="
				+ tempoEstimado + ", difHoraInicioEHoraJob=" + difHoraInicioEHoraJob + ", validaJob=" + validaJob + "]";
	}

}
