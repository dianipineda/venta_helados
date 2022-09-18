package ventahelados.proyecto.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    @Column(name = "password", nullable = false, length = 30)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
