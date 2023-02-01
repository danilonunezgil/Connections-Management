package com.project.dto;

public class InfoStudentDTO {
    
    private Integer codigo;
    private String facultad;
    private String programa;
    private String estudiante;
    private Number promedio;
    private String matriculado;
    private Integer ano;
    private Integer periodo;

    public InfoStudentDTO() {
    }

    public InfoStudentDTO(Integer codigo, String facultad, String programa, String estudiante, Number promedio, String matriculado, Integer ano, Integer periodo) {
        this.codigo = codigo;
        this.facultad = facultad;
        this.programa = programa;
        this.estudiante = estudiante;
        this.promedio = promedio;
        this.matriculado = matriculado;
        this.ano = ano;
        this.periodo = periodo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public Number getPromedio() {
        return promedio;
    }

    public void setPromedio(Number promedio) {
        this.promedio = promedio;
    }

    public String getMatriculado() {
        return matriculado;
    }

    public void setMatriculado(String matriculado) {
        this.matriculado = matriculado;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }
}
