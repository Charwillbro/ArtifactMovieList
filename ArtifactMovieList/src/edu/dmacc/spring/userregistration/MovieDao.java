package edu.dmacc.spring.userregistration;
//Charles Broderick
//Charwillbro@gmail.com
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class MovieDao {
	 EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("movies");

	public void insertMovie(Movie movieToAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(movieToAdd);
		em.getTransaction().commit();
		em.close();
		emfactory.close();
	}

	public List<Movie> getAllMovies() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		String q = "select u from Movie u";
		TypedQuery<Movie> typedQuery = em.createQuery(q, Movie.class);
		List<Movie> all = typedQuery.getResultList();
		return all;

	}

}
