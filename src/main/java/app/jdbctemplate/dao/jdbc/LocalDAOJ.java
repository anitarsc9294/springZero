package app.jdbctemplate.dao.jdbc;

import app.jdbctemplate.dao.LocalDAO;
import app.jdbctemplate.model.Local;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/*
http://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/jdbc.html
*/
public class LocalDAOJ extends JdbcDaoSupport implements LocalDAO {


    public List<Local> list() {
        String sql = "select * from local";

        List<Local> locales = new ArrayList<Local>();

        List<Map<String, Object>> rows = this.getJdbcTemplate().queryForList(sql);

        for (Map row : rows) {

            Local local = new Local();
            local.setId(Long.parseLong(String.valueOf(row.get("ID"))));
            local.setDireccion((String) row.get("direccion"));
            local.setDescripcion((String) row.get("descripcion"));
            local.setTelefono((String) row.get("telefono"));
            locales.add(local);

        }
        return locales;
    }

    public Local get(Local t) {
        String sql = "select * from local where id = ?";

        Local local = (Local) this.getJdbcTemplate().queryForObject(
                sql, new Object[]{t.getId()}, new LocalRowMapper());

        return local;
    }

    public void save(Local t) {
        String sql = "insert into local ( direccion, descripcion, estado, telefono) "
                + "values(?, ?, ?, ?);";

        try {

            this.getJdbcTemplate().update(sql, new Object[]{
                t.getDireccion(),
                t.getDescripcion(),
                t.getEstado(),
                t.getTelefono()
            });

        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public void update(Local t) {
        String sql = "update local set direccion=?, descripcion=?, estado=?, telefono=? "
                + " where id=?";

        try {
            this.getJdbcTemplate().update(sql, new Object[]{
                t.getDireccion(),
                t.getDescripcion(),
                t.getEstado(),
                t.getTelefono(),
                t.getId()
            });
        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public void delete(Local t) {
        this.getJdbcTemplate().update("delete from local where id=?",
                new Object[]{t.getId()});
    }

}
