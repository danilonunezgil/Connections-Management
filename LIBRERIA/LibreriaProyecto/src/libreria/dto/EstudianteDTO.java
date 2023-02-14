package libreria.dto;

import libreria.model.Estudiante;
import java.util.Arrays;
import java.util.Date;

/**
* Clase EstudianteDTO encargada de comunicarse con la vista,controlador y el modelo de Estudiante
* @author Edgar,Danilo y Johan
*/
public class EstudianteDTO extends Estudiante{
    
    private Integer codigo;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String facultad;
    private String programa;
    private Date fecha_inicio;
    private byte[] foto;
    
    public EstudianteDTO() {
    }

    public EstudianteDTO(Integer codigo, String nombres, String apellido1, String apellido2, String telefono, String facultad, String programa, Date fecha_inicio, byte[] foto) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.facultad = facultad;
        this.programa = programa;
        this.fecha_inicio = fecha_inicio;
        this.foto = foto;
    }
    
    public EstudianteDTO(Estudiante estudiante) {
        this.codigo = estudiante.getCodigo();
        this.nombres = estudiante.getNombres();
        this.apellido1 = estudiante.getApellido1();
        this.apellido2 = estudiante.getApellido2();
        this.telefono = estudiante.getTelefono();
        this.facultad = estudiante.getFacultad();
        this.programa = estudiante.getPrograma();
        this.fecha_inicio = estudiante.getFecha_inicio();
        this.foto = estudiante.getFoto();
    }
    
    @Override
    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getNombres() {
        return nombres;
    }

    @Override
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Override
    public String getApellido1() {
        return apellido1;
    }

    @Override
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    @Override
    public String getApellido2() {
        return apellido2;
    }

    @Override
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getFacultad() {
        return facultad;
    }

    @Override
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    @Override
    public String getPrograma() {
        return programa;
    }

    @Override
    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @Override
    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    @Override
    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    @Override
    public byte[] getFoto() {
        return foto;
    }

    @Override
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "EstudianteDTO{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", telefono=" + telefono + ", facultad=" + facultad + ", programa=" + programa + ", fecha_inicio=" + fecha_inicio + ", foto=" + Arrays.toString(foto) + '}';
    }
    
}
