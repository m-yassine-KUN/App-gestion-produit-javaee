package dao;

import java.util.Collection;

import modele.Produit;

public interface IProduitDao {
	
	void add(Produit p);
	Collection<Produit> findAll();
	Produit findById(int id);
	void deleteById(int id);
	void update(Produit newP);
	
}


