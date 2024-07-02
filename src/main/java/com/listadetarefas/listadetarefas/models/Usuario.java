package com.listadetarefas.listadetarefas.models;

// import java.util.ArrayList;

// import org.hibernate.mapping.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = Usuario.TABLE_NAME)
public class Usuario {

    public interface CriaUsuario {}
    public interface AtualizaUsuario{}


    public static final String TABLE_NAME = "usuario";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nomeusuario", length = 100, nullable = false, unique = true)
    @NotNull(groups = {CriaUsuario.class, AtualizaUsuario.class})
    @NotEmpty(groups = {CriaUsuario.class, AtualizaUsuario.class})
    @Size(groups = {CriaUsuario.class, AtualizaUsuario.class}, min = 2, max = 100)
    private String nomeusuario;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "senha", length = 60, nullable = false)
    @NotNull (groups = {CriaUsuario.class, AtualizaUsuario.class})
    @NotEmpty (groups = {CriaUsuario.class, AtualizaUsuario.class})
        @Size(groups = {CriaUsuario.class, AtualizaUsuario.class}, min = 8, max = 60)
    private String senha;

    // private List<tarefa> tarefas = new ArrayList<tarefa>();


    public Usuario() {
    }


    public Usuario(Long id, String nomeusuario, String senha) {
        this.id = id;
        this.nomeusuario = nomeusuario;
        this.senha = senha;
    }
    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeusuario() {
        return this.nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null) 
            return false;
        if (!(obj instanceof Usuario))
            return false;
        Usuario other = (Usuario) obj;
        if (this.id == null)
            if (other.id != null)
                return false;
            else if (!this.id.equals(other.id))
                return false;
        return Objects.equals(this.id, other.id) && Objects.equals(this.nomeusuario, other.nomeusuario)
                && Objects.equals(this.senha, other.senha);
    }

    @Override
    public int hashCode () {
        final int prime = 31;
        int result = 1;
        result =  prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }
    
}
