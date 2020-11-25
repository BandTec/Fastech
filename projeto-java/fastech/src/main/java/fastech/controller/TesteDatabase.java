package fastech.controller;

import fastech.services.Connection;
import fastech.model.Collaborator;
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

        List nome = con.queryForList("select * from Collaborator where idCollaborator = 1;");
        System.out.println(nome);

        List<Collaborator> showCollaborators = con.query("Select * From Collaborator;",
                new BeanPropertyRowMapper(Collaborator.class));

        for (Collaborator c : showCollaborators) {
            System.out.println(c);
        }
    }
}
