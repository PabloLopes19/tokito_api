//import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm
//import io.jsonwebtoken.Jwts
//import io.jsonwebtoken.SignatureAlgorithm
//import io.jsonwebtoken.Claims
//import org.ietf.jgss.GSSCredential
//import org.ietf.jgss.GSSName
//import org.springframework.stereotype.Component
//import java.util.Date
//import javax.security.auth.Subject
//import kotlin.reflect.KFunction2
//
//@Component
//class JwtUtil {
//    private val SECRET_KEY = "seuSegredoSeguro"
//
//    fun generateToken(username: String): String {
//        val claims: Map<String, Any> = HashMap()
//        return Jwts.builder()
//            .setClaims(claims)
//            .setSubject(username)
//            .setIssuedAt(Date())
//            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas
//            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//            .compact()
//    }
//
//    fun validateToken(token: String, username: String): Boolean {
//        val tokenUsername = extractUsername(token)
//        return (username == tokenUsername && !isTokenExpired(token))
//    }
//
//    fun extractUsername(token: String): String {
//        return extractClaim(token, Claims::getSubject)
//    }
//
//    private fun isTokenExpired(token: String): Boolean {
//        return extractExpiration(token).before(Date())
//    }
//
//    private fun extractExpiration(token: String): Date {
//        return extractClaim(token, Claims::getExpiration)
//    }
//
//    private fun <T> extractClaim(token: String, claimsResolver: KFunction2<GSSName, GSSCredential, Subject>): T {
//        val claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).body
//        return claimsResolver(claims)
//    }
//}