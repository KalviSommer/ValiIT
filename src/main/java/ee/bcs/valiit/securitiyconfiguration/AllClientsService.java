package ee.bcs.valiit.securitiyconfiguration;

import ee.bcs.valiit.ApplicationException;
import ee.bcs.valiit.EmployeeName;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AllClientsService {

    @Autowired
    private AllClientsRepository allClientsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createClient(String clientName, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        allClientsRepository.createClient(clientName, encodedPassword);
    }

    public String login(String clientName, String password) {
        String encodedPassword = allClientsRepository.login(clientName);
        if (passwordEncoder.matches(password, encodedPassword)) {
            JwtBuilder builder = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, "secret")
                    .claim("clientname", clientName);
            return builder.compact();
        } else {
            throw new ApplicationException("Vale parool");
        }
    }

    public EmployeeName getName(Integer id) {
        return allClientsRepository.getName(id);
    }

}
