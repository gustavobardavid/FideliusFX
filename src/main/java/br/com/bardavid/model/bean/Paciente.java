package br.com.bardavid.model.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Paciente extends Model {
	
	
	
	
	@NotEmpty @Size(min= 6, max = 20)
	private String nome;
	
	@NotEmpty
	private String comorbidade;
	
	private String dataNascimento;
	
	private String Preocupa;
	
	private String objetivo;
	
	private String dataInicio;
	
	private String prioridade;
	
	private String medicamento;
	
	boolean alcançado = false;
	
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public String getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}
	public boolean isAlcançado() {
		return alcançado;
	}
	public void setAlcançado(boolean alcançado) {
		this.alcançado = alcançado;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getPreocupa() {
		return Preocupa;
	}
	public void setPreocupa(String preocupa) {
		Preocupa = preocupa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getComorbidade() {
		return comorbidade;
	}
	public void setComorbidade(String comorbidade) {
		this.comorbidade = comorbidade;
	}
	
	
	
}
