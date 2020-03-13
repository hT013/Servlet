import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CredentialSubmit extends HttpServlet {
    protected doPost(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException{
        Credential credential = new Credential();
        credential.setEmail(request.getParameter("email"));
        credential.setPassword(request.getParameter("password"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceCred.xml", "Cred");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(credential);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}