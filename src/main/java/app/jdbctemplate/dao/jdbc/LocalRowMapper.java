package app.jdbctemplate.dao.jdbc;

import app.jdbctemplate.model.Local;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class LocalRowMapper implements RowMapper<Local> {

    @Override
    public Local mapRow(ResultSet rs, int rowNum) throws SQLException {
       Local local = new Local();
        local.setId(rs.getLong(1));
        local.setDireccion(rs.getString(2));
        local.setDescripcion(rs.getString(3));
        local.setEstado(rs.getInt(4));
        local.setMaps(rs.getString(5));
        local.setTelefono(rs.getString(6));

        return local;
    }

}
