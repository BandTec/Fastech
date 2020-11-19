package fastech.database;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jorge
 */
public class TesteDatabase {

    public static void main(String[] args) {
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        List nome = con.queryForList("select nameUser, idUser from Usuario where idUser = 1;");
        System.out.println(nome);

        List<Usuario> showUsuarios = con.query("Select * From Usuario;",
                new BeanPropertyRowMapper(Usuario.class));

        for (Usuario u : showUsuarios) {
            System.out.println(u);
        }
    }
}
