import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConexionSimple {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/pap2025";
        String usuario = "pap2025_user";
        String password = "1234";
        
        try {
            System.out.println("🔌 Probando conexión a la base de datos PAP2025...");
            
            // Cargar el driver de PostgreSQL
            Class.forName("org.postgresql.Driver");
            
            // Establecer la conexión
            Connection conexion = DriverManager.getConnection(url, usuario, password);
            
            System.out.println("✅ ¡Conexión exitosa a la base de datos!");
            
            // Verificar que las tablas existen
            Statement stmt = conexion.createStatement();
            
            // Contar registros en cada tabla
            String[] tablas = {"usuarios", "lectores", "bibliotecarios", "materiales", "libros", "prestamos"};
            
            System.out.println("\n📊 Estado de las tablas:");
            for (String tabla : tablas) {
                try {
                    ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as total FROM " + tabla);
                    if (rs.next()) {
                        int total = rs.getInt("total");
                        System.out.println("   • " + tabla + ": " + total + " registros");
                    }
                    rs.close();
                } catch (Exception e) {
                    System.out.println("   • " + tabla + ": Error - " + e.getMessage());
                }
            }
            
            // Probar una consulta específica
            System.out.println("\n🔍 Datos de prueba:");
            ResultSet usuarios = stmt.executeQuery("SELECT id, nombre, email FROM usuarios LIMIT 3");
            while (usuarios.next()) {
                System.out.println("   Usuario " + usuarios.getInt("id") + ": " + 
                                 usuarios.getString("nombre") + " (" + usuarios.getString("email") + ")");
            }
            usuarios.close();
            
            // Cerrar conexiones
            stmt.close();
            conexion.close();
            
            System.out.println("\n🎉 ¡La base de datos está configurada correctamente!");
            System.out.println("💡 Ahora puedes instalar Java 17 para usar Gradle con el proyecto completo.");
            
        } catch (Exception e) {
            System.err.println("❌ Error de conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
