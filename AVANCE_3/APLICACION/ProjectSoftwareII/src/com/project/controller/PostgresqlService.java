package com.project.controller;

import com.project.model.Amigo;
import com.project.model.Elemento;
import com.project.model.Estudiante;
import com.project.dto.AmigoDTO;
import com.project.dto.InfoStudentDTO;
import java.util.List;

public class PostgresqlService {

    private static PostgresqlService postgresqlSingleton;
    private final Amigo amigo;
    private final Estudiante estudiante;
    private final Elemento elemento;

    private PostgresqlService() {
        this.amigo = new Amigo();
        this.estudiante = new Estudiante();
        this.elemento = new Elemento();
    }

    public static PostgresqlService getInstance() {
        if (postgresqlSingleton == null) {
            postgresqlSingleton = new PostgresqlService();
        }
        return postgresqlSingleton;
    }

    //CRUD PARA TABLA AMIGO
    public AmigoDTO ingresarAmigo() {
        return (AmigoDTO) amigo.crear(PostgresqlService.class);
    }

    public List<AmigoDTO> listarAmigo() {
        List<?> listaAmigos = amigo.listar(PostgresqlService.class);
        return (List<AmigoDTO>) listaAmigos;
    }

    public AmigoDTO actualizarAmigo(AmigoDTO amigo) {
        return (AmigoDTO) amigo.actualizar(PostgresqlService.class, amigo);
    }

    public void eliminarAmigo(Number idAmigo) {
        amigo.eliminar(OracleService.class, idAmigo);
    }

    public AmigoDTO buscarAmigoId(Number idAmigo) {
        return (AmigoDTO) amigo.buscarId(PostgresqlService.class, idAmigo);
    }

    //CONTROL DE TRANSACCIONES
    /*
    public String savePoint(){
        return ConexionPostgresql.savePoint(PostgresqlService.class);
    }
    
    public String volverSavePoint(){
        return ConexionPostgresql.volverSavePoint(PostgresqlService.class);
    }
    
    public String rollback(){
        return ConexionPostgresql.rollback(PostgresqlService.class);
    }
    
    public String commit(){
        return ConexionPostgresql.commit(PostgresqlService.class);
    }
    
    public String desconectar(){
        return ConexionPostgresql.desconectar(PostgresqlService.class);
    }*/
    //CONTROL DE FUNCIONES
    public Number promedioCarrera(Integer cod_est) {
        return estudiante.promedioCarrera(PostgresqlService.class, cod_est);
    }

    public Integer precioPromedio(Integer cod_ele) {
        return elemento.precioPromedio(PostgresqlService.class, cod_ele);
    }

    public String compararNumeros(Integer numero1, Integer numero2) {
        return estudiante.compararNumeros(PostgresqlService.class, numero1, numero2);
    }

    public List<InfoStudentDTO> informacionEstudiantes() {
        return estudiante.informacionEstudiantes(PostgresqlService.class);
    }
}
