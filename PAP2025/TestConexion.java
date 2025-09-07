import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConexion {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/pap2025";
        String usuario = "pap2025_user";
        String password = "1234";
        
        try {
            System.out.println("🔌 Intentando conectar a la base de datos...");
            System.out.println("📍 URL: " + url);
            System.out.println("👤 Usuario: " + usuario);
            
            // Cargar el driver de PostgreSQL
            Class.forName("org.postgresql.Driver");
            
            // Establecer la conexión
            Connection conexion = DriverManager.getConnection(url, usuario, password);
            
            System.out.println("✅ ¡Conexión exitosa!");
            
            // Probar una consulta simple
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as total FROM usuarios");
            
            if (rs.next()) {
                int totalUsuarios = rs.getInt("total");
                System.out.println("📊 Total de usuarios en la BD: " + totalUsuarios);
            }
            
            // Listar todas las tablas
            System.out.println("\n📋 Tablas en la base de datos:");
            ResultSet tablas = stmt.executeQuery(
                "SELECT table_name FROM information_schema.tables " +
                "WHERE table_schema = 'public' ORDER BY table_name"
            );
            
            while (tablas.next()) {
                System.out.println("   • " + tablas.getString("table_name"));
            }
            
            // Cerrar conexiones
            rs.close();
            tablas.close();
            stmt.close();
            conexion.close();
            
            System.out.println("\n🎉 ¡Prueba de conexión completada exitosamente!");
            
        } catch (Exception e) {
            System.err.println("❌ Error de conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
