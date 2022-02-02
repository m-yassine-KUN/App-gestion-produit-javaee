package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import modele.Produit;

public class ProduitDaoAvecJDBC implements IProduitDao {
	private static String url = "jdbc:mysql://localhost:3306/bdproduits";
	private static String user = "root";
	private static String password = "";

	private static  Connection cnx=null;
	
	static {
		System.out.println("execution du bloc statique une et une seule fois");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnx = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void add(Produit p) {

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection cnx = DriverManager.getConnection(url, user, password);

			String sql = "insert into Produit (nom,prix,quantite) values(?,?,?)";

			PreparedStatement ps = cnx.prepareStatement(sql);

			ps.setString(1, p.getNom());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());

			ps.executeUpdate();

			//cnx.close();
			ps.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Produit> findAll() {

		Collection<Produit> produits = new ArrayList<Produit>();

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection cnx = DriverManager.getConnection(url, user, password);
			String sql = "select * from Produit";
			Statement st = cnx.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				double prix = rs.getDouble("prix");
				int quantite = rs.getInt("quantite");
				Produit p = new Produit(id, nom, prix, quantite);
				produits.add(p);
			}
			//cnx.close();
			st.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return produits;
	}

	@Override
	public Produit findById(int id) {

		Produit p = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection cnx = DriverManager.getConnection(url, user, password);

			String sql = "select * from Produit where id=?";

			PreparedStatement ps = cnx.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String nom = rs.getString("nom");
				double prix = rs.getDouble("prix");
				int quantite = rs.getInt("quantite");
				p = new Produit(id, nom, prix, quantite);

			}

			//cnx.close();
			ps.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public void deleteById(int id) {

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection cnx = DriverManager.getConnection(url, user, password);
			String sql = "delete from Produit where id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

			//cnx.close();
			ps.close();

		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Produit newP) {

		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection cnx = DriverManager.getConnection(url, user, password);
			String sql = "update Produit set nom=?, prix=?, quantite=? where id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, newP.getNom());
			ps.setDouble(2, newP.getPrix());
			ps.setInt(3, newP.getQuantite());
			ps.setInt(4, newP.getId());

			ps.executeUpdate();

			//cnx.close();
			ps.close();

		} catch (SQLException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
