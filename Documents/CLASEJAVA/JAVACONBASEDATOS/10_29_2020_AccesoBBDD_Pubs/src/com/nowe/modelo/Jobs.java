/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.modelo;

/**
 *
 * @author Programacion
 */
public class Jobs {
    
    private int job_id;
    private String job_desc;
    private int max_M;
    private int min_M;

    @Override
    public String toString() {
        return "Jobs{" + "job_id=" + job_id + ", job_desc=" + job_desc + ", max_M=" + max_M + ", min_M=" + min_M + '}' + "\n";
    }

    public Jobs() {
    }

    public Jobs(int job_id, String job_desc, int max_M, int min_M) {
        this.job_id = job_id;
        this.job_desc = job_desc;
        this.max_M = max_M;
        this.min_M = min_M;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getJob_desc() {
        return job_desc;
    }

    public void setJob_desc(String job_desc) {
        this.job_desc = job_desc;
    }

    public int getMax_M() {
        return max_M;
    }

    public void setMax_M(int max_M) {
        this.max_M = max_M;
    }

    public int getMin_M() {
        return min_M;
    }

    public void setMin_M(int min_M) {
        this.min_M = min_M;
    }
    
    
    
}
