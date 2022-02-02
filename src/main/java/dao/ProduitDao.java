package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import modele.Produit;

public class ProduitDao implements IProduitDao{

	static private Map<Integer, Produit> map= new HashMap<>();//une table de hachage avec deux colonnes
	
	@Override
	public void add(Produit p) {
		map.put(p.getId(), p);
	}

	@Override
	public Collection<Produit> findAll() {
		
	Collection<Produit> values = map.values();
		
		return values;
	}

	@Override
	public Produit findById(int id) {
		
		Produit produit = map.get(id);
		return produit;
	}

	@Override
	public void deleteById(int id) {
		map.remove(id);
		
	}

	@Override
	public void update(Produit newP) {
		map.put(newP.getId(), newP);
	}
}