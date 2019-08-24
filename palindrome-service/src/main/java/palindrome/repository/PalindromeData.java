package palindrome.repository;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Basic;


@Component
@Data
@Builder
@Entity
@Table( name = "palindromedata")
@AllArgsConstructor
@NoArgsConstructor
public class PalindromeData implements Serializable {

    private static final int serialVersionUID = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "payload")
    private String payLoad;

    @Column(name = "created_timestamp")
    private String createdTimestamp;

}
