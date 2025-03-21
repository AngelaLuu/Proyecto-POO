// Administrador.java
public class Administrador {
    private static final String USUARIO = "admin";
    private static final String CONTRASEÑA = "1234";

    public static boolean validarAcceso(String usuario, String contraseña) {
        return USUARIO.equals(usuario) && CONTRASEÑA.equals(contraseña);
    }
}
