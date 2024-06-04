package persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Persistencia implements IPersistencia {

	private static final String URL = "jdbc:sqlite:videojuegos.db";

	@Override
	public ArrayList<Videojuego> consultarVideojuegos(Integer idPlataforma) {

		Connection con = null;

		ArrayList<Videojuego> listaVj = new ArrayList();

		try {
			con = DriverManager.getConnection(URL);

			String sql = "select v.* " + "from videojuegoplataforma vp join videojuegos v on vp.videojuego_id=v.id "
					+ "where vp.plataforma_id=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idPlataforma);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Integer idVj = rs.getInt(1); // id
				String tituloJv = rs.getString(2);// titulo
				String desarrolladorVj = rs.getString(3);// desarrollador
				Integer anioVj = rs.getInt(4);// anioLanzamiento

				Videojuego vj = new Videojuego(idVj, tituloJv, desarrolladorVj, anioVj);
				listaVj.add(vj);
			}

			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaVj;
	}

	public Boolean insertarNuevoVideojuego(Videojuego vj) {

		Connection con = null;
		int n = 0;
		try {
			con = DriverManager.getConnection(URL);

			PreparedStatement ps = con.prepareStatement("insert into videojuegos values(?,?,?,?)");
			ps.setInt(1, vj.getId());
			ps.setString(2, vj.getTitulo());
			ps.setString(3, vj.getDesarrollador());
			ps.setInt(4, vj.getAnoLanzamiento());

			n = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return n != 0;

	}

	private Boolean insertarNuevoVideojuego(Videojuego vj, Connection con) throws SQLException {

		int n = 0;

		PreparedStatement ps = con.prepareStatement("insert into videojuegos values(?,?,?,?)");
		ps.setInt(1, vj.getId());
		ps.setString(2, vj.getTitulo());
		ps.setString(3, vj.getDesarrollador());
		ps.setInt(4, vj.getAnoLanzamiento());

		n = ps.executeUpdate();

		return n != 0;

	}

	private Boolean insertarNuevaPlataforma(Plataforma pf, Connection con) throws SQLException {

		int n = 0;

		PreparedStatement ps = con.prepareStatement("insert into plataformas values(?,?)");
		ps.setInt(1, pf.getId());
		ps.setString(2, pf.getNombre());

		n = ps.executeUpdate();

		return n != 0;

	}

	public Boolean insertarNuevaPlataforma(Plataforma pf) {

		Connection con = null;
		int n = 0;
		try {
			con = DriverManager.getConnection(URL);

			PreparedStatement ps = con.prepareStatement("insert into plataformas values(?,?)");
			ps.setInt(1, pf.getId());
			ps.setString(2, pf.getNombre());

			n = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return n != 0;

	}

	public Boolean existeVideojuego(Integer idVj) {
		Connection con = null;
		Boolean existe = false;
		try {
			con = DriverManager.getConnection(URL);

			PreparedStatement ps = con.prepareStatement("select * from videojuegos where id=?");
			ps.setInt(1, idVj);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				existe = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return existe;
	}

	private Boolean existeVideojuego(Integer idVj, Connection con) throws SQLException {
		Boolean existe = false;

		PreparedStatement ps = con.prepareStatement("select * from videojuegos where id=?");
		ps.setInt(1, idVj);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			existe = true;
		}

		return existe;
	}

	public Boolean existePlataforma(Integer idPf) {
		Connection con = null;
		Boolean existe = false;
		try {
			con = DriverManager.getConnection(URL);

			PreparedStatement ps = con.prepareStatement("select * from plataformas where id=?");
			ps.setInt(1, idPf);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				existe = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return existe;
	}

	public Boolean existePlataforma(Integer idPf, Connection con) throws SQLException {
		Boolean existe = false;

		PreparedStatement ps = con.prepareStatement("select * from plataformas where id=?");
		ps.setInt(1, idPf);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			existe = true;
		}

		return existe;
	}

	private Boolean insertVideojuegoPlataforma(Videojuego vj, Plataforma pf, Connection con) throws SQLException {
		int n = 0;

		PreparedStatement ps = con.prepareStatement("insert into videojuegoplataforma values(?,?)");
		ps.setInt(1, vj.getId());
		ps.setInt(2, pf.getId());

		n = ps.executeUpdate();

		return n != 0;
	}

	@Override
	public Boolean insertarVideojuegoPlataforma(Videojuego vj, Plataforma pf) {

		Connection con = null;
		Boolean insertado = false;
		try {
			con = DriverManager.getConnection(URL);
			con.setAutoCommit(false);

			if (!existeVideojuego(vj.getId(), con)) {
				insertarNuevoVideojuego(vj, con);
			}

			if (!existePlataforma(pf.getId(), con)) {
				insertarNuevaPlataforma(pf, con);
			}

			insertado = insertVideojuegoPlataforma(vj, pf, con);

			con.commit();

		} catch (SQLException e) {

			e.printStackTrace();

			try {
				if (con != null)
					con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return insertado;
	}

	public Videojuego getVideojuegoById(Integer idVj) {
		
	}
	
	
}
