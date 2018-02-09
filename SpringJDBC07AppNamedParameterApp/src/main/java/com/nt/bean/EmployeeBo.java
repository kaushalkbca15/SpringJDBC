package com.nt.bean;

/**
 * This class Employee Business object
 * @author kaushal
 * @version Spring Jdbc CallBack Interface 1.0
 * */
public class EmployeeBo {

	private Integer e_id;
	private String name;
	private String job;
	/**
	 * @return the e_id
	 */
	public Integer getE_id() {
		return e_id;
	}
	/**
	 * @param e_id the e_id to set
	 */
	public void setE_id(Integer e_id) {
		this.e_id = e_id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}
	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
@Override
	public String toString() {
		return "EmployeeBo [e_id=" + e_id + ", name=" + name + ", job=" + job + "]";
	}
	
}
