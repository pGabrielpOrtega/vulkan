/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vulkan.declaracion;

/**
 *
 * @author gabri
 */
public class decSingletonUser {
    private decUsuario Usuario;
    private static decSingletonUser usuario;
 
    public static decSingletonUser getUsuario(decUsuario nombreUsuario) 
    {
        if (usuario == null) 
        {
            usuario = new decSingletonUser(nombreUsuario);
        }
        return usuario;
    }
 
    private decSingletonUser(decUsuario usuario)
    {    
        this.Usuario=usuario; 
    }
 
    public decUsuario getCuenta()
    {
        return Usuario;
    }
 
    public String getNombreUsuario() 
    {
        return Usuario.getNombre_usuario();
    }
 
    public void setUsuario(decUsuario usuario) 
    {
        this.Usuario = usuario;
    }
}
