package palindrome.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.stereotype.Component;
import palindrome.domain.Palindrome;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Component
@Data
@Builder
@Entity
@Table( name = "palindromedata")
@AllArgsConstructor
public class PalindromeData implements Serializable {

    private static final int serialVersionUID = 0;
    @JsonIgnoreProperties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonInclude
    @Column(name = "payload")
    private Palindrome payLoad;

    @JsonIgnoreProperties
    @Column(name = "created_timestamp")
    private String createdTimestamp;

    @JsonInclude
    @Column(name = "payloadtext")
    private String payLoadText;

}
