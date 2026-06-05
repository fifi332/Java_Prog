import javax.xml.transform.Source;
import java.sql.*;
import java.util.ArrayList;


public class OficinaDAO {
    /**
     * Xestión da táboa oficina en PostgreSQL.
     */

    //  Conexión

    private static Connection conectar(String url, String usuario, String contrasinal) {
        Connection con = null;
        System.out.println("Conectando á base de datos...");
        try {
            con = DriverManager.getConnection(url, usuario, contrasinal);
        } catch (SQLException e) {
            System.out.println("Erro realizando a conexión a base de datos.\n");
        }
        System.out.println("Conexión establecida correctamente.\n");
        return con;
    }

    //  creación da táboa

    public static void crearTaboa()  {
        Connection con = conectar("jdbc:postgresql://10.0.8.166:5432/empresa", "postgres", "vboxuser");
        String sql = """
                CREATE TABLE IF NOT EXISTS oficina (
                    cif         VARCHAR(9)   PRIMARY KEY,
                    nome        VARCHAR(100) NOT NULL,
                    direccion   VARCHAR(200) NOT NULL,
                    localidade  VARCHAR(100) NOT NULL,
                    provincia   VARCHAR(100) NOT NULL
                )
                """;
        try {
            Statement st = con.createStatement();
            st.execute(sql);
            con.close();
            System.out.println("Táboa 'oficina' creada (ou xa existía).\n");
        } catch ( SQLException e){
            System.out.println("Erro o crear a táboa");
        }
    }

    //  inserción de datos de exemplo

    public static void inserirDatosExemplo(Connection conn){
        Connection con = null;
        try {
            con = conectar("jdbc:postgresql://10.0.8.166:5432/empresa", "postgres", "vboxuser");
            String sql = """ 
            INSERT INTO oficina (cif, nome, direccion, localidade, provincia)
                                VALUES ("B36012345", "Industrias Galicia S.L.",       "Rúa do Mar 12",          "Vigo",          "Pontevedra") """;
            Statement ps = conn.createStatement();
            ps.executeUpdate(sql);
            sql = """ 
            INSERT INTO oficina (cif, nome, direccion, localidade, provincia)
                          VALUES ("A15098765", "Construcións do Norte S.A.",    "Avda. da Coruña 45",     "A Coruña",      "A Coruña") """;
            ps.executeUpdate(sql);
            sql = """ 
            INSERT INTO oficina (cif, nome, direccion, localidade, provincia)
                          VALUES ("B27054321", "Servizos Lugo S.L.",            "Praza Maior 3",          "Lugo",          "Lugo") """;

            ps.executeUpdate(sql);
            sql = """ 
            INSERT INTO oficina (cif, nome, direccion, localidade, provincia)
                        VALUES ("A32011223", "Tecnoloxías Ourense S.A.",      "Rúa Progreso, 88",        "Ourense",       "Ourense") """;
            ps.executeUpdate(sql);
            sql = """ 
            INSERT INTO oficina (cif, nome, direccion, localidade, provincia)
                          VALUES ("B36099887", "Pesca e Mar Cooperativa",       "Porto Pesqueiro, s/n",    "Marín",         "Pontevedra") """;
            ps.executeUpdate(sql);
            con.close();
            System.out.printf("Datos de exemplo insertados");
        }catch (SQLException e){
            System.out.println("Erro o insertar os datos de exemplo: " + e.getMessage());
        }
    }

    public static ArrayList<Oficina> importarOficinasPorCif(String cif){
        ArrayList<Oficina> lista = new ArrayList<>();

        Connection con = conectar("jdbc:postgresql://10.0.8.166:5432/empresa", "postgres", "vboxuser");
        String sql = "SELECT nome,direccion,localidade,provincia FROM oficina WHERE cif = ?";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,cif);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                String nom = rs.getString("nome");
                String dir = rs.getString("direccion");
                String loc = rs.getString("localidade");
                String prov = rs.getString("provincia");

                Oficina o = new Oficina(nom, dir, loc, prov);
                lista.add(o);
            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al importar oficina" + e.getMessage());
        }
        return lista;

    }

    public static void actualizarOficina(Oficina c, String cif) {
        Connection con = conectar("jdbc:postgresql://10.0.8.166:5432/empresa", "postgres", "vboxuser");
        String sql = "UPDATE oficina SET nome = ?, direccion = ?, localidade = ?, provincia = ? WHERE cif = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, c.getNome());
            ps.setString(2, c.getDireccion());
            ps.setString(3, c.getLocalidade());
            ps.setString(4, c.getProvincia());
            ps.setString(5, cif);

            ps.executeUpdate();

            ps.close();
            con.close();
            System.out.println("Oficina actualizada correctamente.");

        } catch (SQLException e) {
            System.out.println("Erro ao actualizar a oficina: " + e.getMessage());
        }
    }
}